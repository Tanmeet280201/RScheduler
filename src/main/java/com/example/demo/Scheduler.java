package com.example.demo;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class Scheduler {

    private final RestTemplate restTemplate = new RestTemplate();

    @Scheduled(fixedRate = 30000) // 120,000 milliseconds = 2 minutes
    public void makeGetRequest() {
        String url = "https://regnskapsapplikasjon.onrender.com/";
        String response = restTemplate.getForObject(url, String.class);
        System.out.println("Response received: " + response);
    }
}
