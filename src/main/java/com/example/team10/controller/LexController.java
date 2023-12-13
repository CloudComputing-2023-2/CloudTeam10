package com.example.team10.controller;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import java.util.HashMap;
import java.util.Map;

@RestController
public class LexController {

    private final String awsLexEndpoint = "https://runtime-v2-lex.ap-northeast-2.amazonaws.com";

    @PostMapping("/message")
    public String sendMessageToLex(@RequestBody String message) {
        try {
            // 필요한 정보 설정
            String botName = "medibot";
            String botAlias = "james";
            String userId = "yourUserId"; // 사용자를 식별할 수 있는 고유 ID

            // AWS Lex API 엔드포인트 구성
            String url = awsLexEndpoint + "/bot/" + botName + "/alias/" + botAlias + "/user/" + userId + "/text";

            // 요청 본문 구성
            Map<String, String> requestBody = new HashMap<>();
            requestBody.put("inputText", message);

            // HTTP 헤더 설정 (여기에 AWS 서명 추가 필요)
            HttpHeaders headers = new HttpHeaders();
            headers.add("Content-Type", "application/json");
            // AWS 서명 로직 추가...

            // 요청 보내기
            RestTemplate restTemplate = new RestTemplate();
            HttpEntity<Map<String, String>> entity = new HttpEntity<>(requestBody, headers);
            ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.POST, entity, String.class);

            return response.getBody();

        } catch (Exception e) {
            e.printStackTrace();
            return "Error: " + e.getMessage();
        }
    }
}

