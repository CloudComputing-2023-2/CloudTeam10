package com.example.team10.controller;

import com.example.team10.entity.Request;
import com.example.team10.service.RequestService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class RequestController {

    private final RequestService requestService;

    @Autowired
    public RequestController(RequestService requestService) {
        this.requestService = requestService;
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/api/requests")
    @ResponseBody
    public String getRequest() {
        return requestService.getLatestRequest();

    }

}