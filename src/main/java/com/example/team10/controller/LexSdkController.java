package com.example.team10.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import software.amazon.awssdk.auth.credentials.AwsBasicCredentials;
import software.amazon.awssdk.auth.credentials.StaticCredentialsProvider;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.lexruntime.model.DependencyFailedException;
import software.amazon.awssdk.services.lexruntime.model.LexRuntimeException;
import software.amazon.awssdk.services.lexruntimev2.LexRuntimeV2Client;
import software.amazon.awssdk.services.lexruntimev2.model.Message;
import software.amazon.awssdk.services.lexruntimev2.model.RecognizeTextRequest;
import software.amazon.awssdk.services.lexruntimev2.model.RecognizeTextResponse;

import java.util.List;
import java.util.UUID;


@RestController
public class LexSdkController {

    private LexRuntimeV2Client lexRuntimeV2Client = LexRuntimeV2Client.builder()
            .region(Region.AP_NORTHEAST_2)
            .credentialsProvider(StaticCredentialsProvider.create(AwsBasicCredentials.create("AKIAV5BXM55AVMWRXSHW", "nPYaJ6WFAzOCnFZDhnScrQfIny0TxLkGLgzccCNh")))
            .build();

    @PostMapping("/askLexV2")
    public String askLexV2(@RequestBody String userMessage) {
        String botId = "AWJPW47JO2";
        String botAliasId = "J6QWJ17NDB";
        String localeId = "ko_KR";
        String sessionId = UUID.randomUUID().toString();

        try{
            RecognizeTextRequest recognizeTextRequest = RecognizeTextRequest.builder()
                    .botId(botId)
                    .botAliasId(botAliasId)
                    .localeId(localeId)
                    .sessionId(sessionId)
                    .text(userMessage)
                    .build();

            RecognizeTextResponse recognizeTextResponse = lexRuntimeV2Client.recognizeText(recognizeTextRequest);

            return "OK";
        } catch (DependencyFailedException e) {
            e.printStackTrace();

            return "수행이 됨";
        } catch (LexRuntimeException e){
            e.printStackTrace();
        }

        return "FAIL";
    }
}
