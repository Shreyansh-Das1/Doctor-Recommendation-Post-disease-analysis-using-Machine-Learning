package com.example.codeblooded;

import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import java.util.*;

@RestController
public class Controller {

    @PostMapping("/diagnose")
    public ResponseEntity<?> diagnose(@RequestBody Map<String, Object> payload) {
       
        Map<String, Integer> symptoms = (Map<String, Integer>) payload.get("symptoms");
        String locality = (String) payload.get("locality");
        
        RestTemplate restTemplate = new RestTemplate();
        String pythonUrl = "http://localhost:5000/predict"; // placeholder url

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        Map<String, Object> pythonPayload = new HashMap<>();
        pythonPayload.put("symptoms", symptoms);

        HttpEntity<Map<String, Object>> request = new HttpEntity<>(pythonPayload, headers);

        try {
            ResponseEntity<Map> response = restTemplate.postForEntity(pythonUrl, request, Map.class);
            return ResponseEntity.ok(response.getBody());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(Collections.singletonMap("error", "Failed to connect to model endpoint: " + e.getMessage()));
        }
    }
}
