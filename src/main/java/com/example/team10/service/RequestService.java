package com.example.team10.service;

import com.example.team10.entity.Request;
import com.example.team10.repository.RequestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RequestService{
    private final RequestRepository requestRepository;

    @Autowired
    public RequestService(RequestRepository requestRepository){
        this.requestRepository = requestRepository;
    }

    public Request getLatestRequest() {
        // 모든 Request를 ID의 내림차순으로 정렬하여 가져오기

        //return requestRepository.findFirstByOrderByIdDesc();
        Request request = requestRepository.findTopByOrderByIdDesc();

        /*
        String itemName = (request != null && request.getItemName() != null) ? request.getItemName() : "";
        String sideEffect = (request != null && request.getSideEffect() != null) ? request.getSideEffect() : "";
        String storageMethod = (request != null && request.getStorageMethod() != null) ? request.getStorageMethod() : "";
        String effect = (request != null && request.getEffect() != null) ? request.getEffect() : "";
        String userMethod = (request != null && request.getUserMethod() != null) ? request.getUserMethod() : "";

        // 유니코드 이스케이프를 해제하는 부분 추가
        itemName = decodeUnicode(itemName);
        sideEffect = decodeUnicode(sideEffect);
        storageMethod = decodeUnicode(storageMethod);
        effect = decodeUnicode(effect);
        userMethod = decodeUnicode(userMethod);*/

        /*return "약 이름은 " + itemName + "이고\n" + "약 효과는 " + effect + "에 사용하고\n"+
                "보관 법은 " + storageMethod + "이고\n" + "사용 법은 " + userMethod +
                "이고\n" + "부작용은 " + sideEffect + "입니다.";*/

        return request;
    }
}