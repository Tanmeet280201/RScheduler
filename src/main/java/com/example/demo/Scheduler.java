package com.example.demo;

import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Component
public class Scheduler {

    private final RestTemplate restTemplate = new RestTemplate();

    @Scheduled(fixedRate = 10000) // 120,000 milliseconds = 2 minutes
    public void sendPostRequest() {
        String url = "https://regnskapsapplikasjon.onrender.com/login";
        Map<String, String> requestBody = new HashMap<>();
        requestBody.put("username", UUID.randomUUID().toString());
        requestBody.put("password", UUID.randomUUID().toString());

        ResponseEntity<String> responseEntity = restTemplate.postForEntity(url, requestBody, String.class);

        if (responseEntity.getStatusCode().is2xxSuccessful()) {
            System.out.println("Successful response received");
        } else {
            System.out.println("Request failed with status: " + responseEntity.getStatusCode());
        }

        System.out.println("Response body: " + responseEntity.getBody());
    }
}
