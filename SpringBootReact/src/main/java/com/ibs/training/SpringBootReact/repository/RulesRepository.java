package com.ibs.training.SpringBootReact.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ibs.training.SpringBootReact.model.Rules;

public interface RulesRepository extends JpaRepository<Rules,Long> {
    List findByPolicyId(Long policyId);

}