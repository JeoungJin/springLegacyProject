package com.shinhan.spring.socket;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SessionInitController {

    @GetMapping(value = "/session-init", produces = "text/plain;charset=utf-8")
    public ResponseEntity<String> init(HttpServletRequest request) {
        HttpSession session = request.getSession(true);  
        session.setAttribute("userId", "fromJs");  
        return ResponseEntity.ok("session init OK");
    }
}