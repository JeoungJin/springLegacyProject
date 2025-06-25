package com.shinhan.spring.controller;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
 
@RestController
@RequestMapping("/another")
public class AnotherController {
	@GetMapping("/py")
	public List<String> f3() {
		RestTemplate restTemplate = new RestTemplate();
		String url = "http://localhost:8000/recommend";

		Map<String, Object> request = new HashMap<>();
		request.put("user_id", "user123");
		request.put("items", Arrays.asList("item1", "item2", "item3"));

		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);

		HttpEntity<Map<String, Object>> entity = new HttpEntity<>(request, headers);
		ResponseEntity<Map> response = restTemplate.postForEntity(url, entity, Map.class);

		List<String> recommended = (List<String>) response.getBody().get("recommended_items");
		System.out.println(recommended);
		return recommended;
	}
	
	@GetMapping("/a")
	public String f1() {
		RestTemplate restTemplate = new RestTemplate();
		String url = "http://192.168.0.2:9999/bank/api/a";

		// GET 요청
		String response = restTemplate.getForObject(url, String.class);
		System.out.println(response);
		return "get OK";
	}
	@GetMapping("/b")
	public String f2() {
		RestTemplate restTemplate = new RestTemplate();
		String url = "http://192.168.0.2:9999/bank/api/b";

	 	// POST 요청
		Map<String, String> requestBody = new HashMap<>();
		requestBody.put("name", "Jeoung");
		requestBody.put("age", "28");

		String result = restTemplate.postForObject(url, requestBody, String.class);
		System.out.println(result);
		return "post OK";
	}
	
	
	
}
