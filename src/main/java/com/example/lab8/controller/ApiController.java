package com.example.lab8.controller;

import org.springframework.web.bind.annotation.*;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;
import java.util.List;
import java.util.ArrayList;

@RestController
public class ApiController {

    private final List<Map<String, String>> chatHistory = new ArrayList<>();

    @GetMapping("/hello")
    public String sayHello() {
        return "Hello from Spring Boot REST Server!";
    }

    @GetMapping("/time")
    public Map<String, String> getServerTime() {
        Map<String, String> response = new HashMap<>();
        response.put("serverTime", LocalDateTime.now().toString());
        return response;
    }

    @PostMapping("/chat")
    public Map<String, String> chat(@RequestBody Map<String, String> body) {
        String msg = body.get("message");
        Map<String, String> response = new HashMap<>();
        response.put("userMessage", msg);
        response.put("serverReply", "You said: " + msg);

        chatHistory.add(response);
        return response;
    }
    @GetMapping("/status")
    public Map<String, String> status() {
        Map<String, String> response = new HashMap<>();
        response.put("uptime", "00:10:25"); // example, replace with actual logic
        return response;
    }
    @GetMapping("/chat/history")
    public List<Map<String, String>> chatHistory() {
    return chatHistory;
    }

}
