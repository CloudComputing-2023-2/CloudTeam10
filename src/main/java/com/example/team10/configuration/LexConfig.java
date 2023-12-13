package com.example.team10.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import software.amazon.awssdk.services.lexruntimev2.LexRuntimeV2Client;

//@Configuration
public class LexConfig {

    @Bean
    public LexRuntimeV2Client lexRuntimeV2Client() {
        return LexRuntimeV2Client.builder().build();
    }
}
