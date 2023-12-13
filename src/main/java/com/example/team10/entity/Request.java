package com.example.team10.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.Getter;

@Entity(name = "request")
@Getter
public class Request {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int id;
    public String symptom;
    public String itemName;
    public String sideEffect;
    public String storageMethod;
    public String effect;
    public String userMethod;
}
