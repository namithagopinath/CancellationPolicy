package com.ibs.training.SpringBootReact.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ibs.training.SpringBootReact.model.Policy;

public interface CancellationPolicyRepository extends JpaRepository<Policy,Long> {
}