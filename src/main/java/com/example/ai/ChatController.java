package com.example.ai;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ChatController {
    private final ChatClient chatClient;

    public ChatController(ChatClient.Builder builder) {
        this.chatClient = builder
                .defaultSystem("You are an AI assistant answering questions about different products")
                .build();
    }

    @GetMapping("/ai/generate")
    public ResponseEntity<String> generate(@RequestParam(value = "message") String message) {
        try {
            String response = chatClient.prompt()
                    .user(message)
                    .functions("getProductDetails")
                    .call()
                    .content();

            return ResponseEntity.ok(response);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.internalServerError().body("An error occurred: " + e.getMessage());
        }
    }
}