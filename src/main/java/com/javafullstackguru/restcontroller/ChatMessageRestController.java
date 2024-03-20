package com.javafullstackguru.restcontroller;

import com.javafullstackguru.entity.ChatMessage;
import org.springframework.web.bind.annotation.*;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@RestController
public class ChatMessageRestController {

    private final String OPENAI_API_TOKEN = System.getenv("OPENAI_API_TOKEN");

    @PostMapping("/getChatCompletion")
    public String getChatCompletion(@RequestBody String userMessage) {

        // Construct request body
        String requestBody = "{\n" +
                "  \"model\": \"gpt-3.5-turbo\",\n" +
                "  \"messages\": [\n" +
                "    {\n" +
                "      \"role\": \"user\",\n" +
                "      \"content\": \"" + userMessage + "\"\n" +
                "    }\n" +
                "  ],\n" +
                "  \"temperature\": 1,\n" +
                "  \"max_tokens\": 256,\n" +
                "  \"top_p\": 1,\n" +
                "  \"frequency_penalty\": 0,\n" +
                "  \"presence_penalty\": 0\n" +
                "}";

        // Set headers
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.set("Authorization", "Bearer " + OPENAI_API_TOKEN);

        // Make the HTTP request
        RestTemplate restTemplate = new RestTemplate();
        HttpEntity<String> entity = new HttpEntity<>(requestBody, headers);
        String apiUrl = "https://api.openai.com/v1/chat/completions";
        String response = restTemplate.postForObject(apiUrl, entity, String.class);

        return response;
    }

    @GetMapping("/get")
    public List<ChatMessage> get() {
        // Create a list of ChatMessage objects
        List<ChatMessage> chatMessages = new ArrayList<>();

        // Populate the list with example ChatMessage objects (replace with your actual data)
        chatMessages.add(new ChatMessage("User 1", "Hello"));
        chatMessages.add(new ChatMessage("User 2", "Hi there"));

        return chatMessages;
    }

    // Define your ChatMessage class if it's not already defined
    // Example:
    static class ChatMessage {
        private String sender;
        private String message;

        public ChatMessage(String sender, String message) {
            this.sender = sender;
            this.message = message;
        }

        // Getters and setters (if needed)
    }

    @PutMapping("/update")
    public String update() {
        return "This is an example of PUT request.";
    }

    @DeleteMapping("/delete")
    public String delete() {
        return "This is an example of DELETE request.";
    }
}
