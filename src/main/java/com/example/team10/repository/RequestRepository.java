package com.example.team10.repository;

import com.example.team10.entity.Request;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RequestRepository extends JpaRepository<Request, Integer> {
    Request findFirstByOrderByIdDesc();

    Request findTopByOrderByIdDesc();
}
