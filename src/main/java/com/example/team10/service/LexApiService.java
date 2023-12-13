package com.example.team10.service;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpHeaders;
import java.time.Duration;

public class LexApiService {

    public String postTextToLex(String botName, String botAlias, String userId, String inputText) {
        try {
            HttpClient client = HttpClient.newHttpClient();
            String lexUri = "https://runtime-v2-lex.ap-northeast-2.amazonaws.com" + botName + "/alias/" + botAlias + "/user/" + userId + "/text";

            // 요청 본문 구성
            String requestBody = "{\"inputText\": \"" + inputText + "\"}";

            // 요청 생성
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(lexUri))
                    .timeout(Duration.ofMinutes(1))
                    .header("Content-Type", "application/json")
                    // AWS 서명 관련 헤더 추가 필요
                    .POST(HttpRequest.BodyPublishers.ofString(requestBody))
                    .build();

            // 요청 보내기
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            return response.body();

        } catch (Exception e) {
            e.printStackTrace();
            return "Error: " + e.getMessage();
        }
    }
}
