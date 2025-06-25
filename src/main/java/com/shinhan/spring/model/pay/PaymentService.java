package com.shinhan.spring.model.pay;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class PaymentService {

    // 실무에서는 DAO 또는 Repository 연동
    private Map<String, String> cardDB = new HashMap<>(); // [userId → customer_uid] 임시 저장

    private final String apiKey = "imp_apikey";
    private final String apiSecret = "3sFjNq8rM6cMlgC0I2q5E6xTg3K5Z9P7QDzA0vZHsGQy8wSXA1QhI8zP5qK9X2gE";

    public void saveCardInfo(CardInfo cardInfo) {
        cardDB.put(cardInfo.getUserId(), cardInfo.getCustomerUid());
    }

    public String charge(String userId, int amount) {
        try {
            String customerUid = cardDB.get(userId);
            String token = getIamportToken();

            RestTemplate restTemplate = new RestTemplate();
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_JSON);
            headers.setBearerAuth(token);

            Map<String, Object> body = new HashMap<>();
            body.put("customer_uid", customerUid);
            body.put("merchant_uid", "order_" + System.currentTimeMillis());
            body.put("amount", amount);
            body.put("name", "간편결제 상품");

            HttpEntity<Map<String, Object>> entity = new HttpEntity<>(body, headers);
            ResponseEntity<String> response = restTemplate.postForEntity(
                "https://api.iamport.kr/subscribe/payments/again", entity, String.class
            );

            return response.getBody();
        } catch (Exception e) {
            return "결제 실패: " + e.getMessage();
        }
    }

    private String getIamportToken() throws Exception {
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        Map<String, String> body = new HashMap<>();
        body.put("imp_key", apiKey);
        body.put("imp_secret", apiSecret);

        HttpEntity<Map<String, String>> entity = new HttpEntity<>(body, headers);
        ResponseEntity<Map> response = restTemplate.postForEntity(
            "https://api.iamport.kr/users/getToken", entity, Map.class);

        Map<String, Object> responseBody = (Map<String, Object>) response.getBody().get("response");
        return (String) responseBody.get("access_token");
    }
}