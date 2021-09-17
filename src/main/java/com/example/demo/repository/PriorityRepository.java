package com.example.demo.repository;

import com.example.demo.entity.Cathegory;
import com.example.demo.entity.Priority;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PriorityRepository extends JpaRepository<Priority, Long> {
    Optional<Priority> findPriorityByName(String name);
}
