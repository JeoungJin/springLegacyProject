package com.shinhan.spring.controller.card;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.shinhan.spring.model.pay.CardInfo;
import com.shinhan.spring.model.pay.PaymentService;

@Controller
@RequestMapping("/payment")
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    @GetMapping("/register")
    public String showRegisterPage() {
        return "card/cardRegister";
    }

    @PostMapping(value = "/saveCard.do", consumes = "application/json")
    @ResponseBody
    public String saveCard(@RequestBody CardInfo cardInfo) {
        paymentService.saveCardInfo(cardInfo);
        return "카드 등록 성공";
    }

    @PostMapping("/charge.do")
    @ResponseBody
    public String charge(@RequestParam String userId, @RequestParam int amount) {
        return paymentService.charge(userId, amount);
    }
}