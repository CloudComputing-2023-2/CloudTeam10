package com.example.team10;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.regions.providers.DefaultAwsRegionProviderChain;

import java.net.InetAddress;
import java.net.UnknownHostException;


@SpringBootApplication
public class Team10Application {

    public static void main(String[] args) {
        SpringApplication.run(Team10Application.class, args);
    }

}
@Component
class MyApplicationRunner implements ApplicationRunner {

    @Override
    public void run(ApplicationArguments args) {
        try {
            // 현재 서버의 InetAddress를 얻어옵니다.
            InetAddress inetAddress = InetAddress.getLocalHost();
            System.out.println("Server IP Address: " + inetAddress.getHostAddress());
        } catch (UnknownHostException e) {
            e.printStackTrace();
            System.out.println("Unable to retrieve server IP address.");
        }
    }
}


