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
        HttpSession session = request.getSession(true); // 技记 碍力 积己
        session.setAttribute("userId", "fromJs"); // 抛胶飘侩 蔼
        return ResponseEntity.ok("技记 积己凳");
    }
}