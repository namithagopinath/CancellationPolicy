package com.ibs.training.SpringBootReact.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import com.ibs.training.SpringBootReact.exception.NotFoundException;
import com.ibs.training.SpringBootReact.model.Policy;
import com.ibs.training.SpringBootReact.repository.CancellationPolicyRepository;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins="http://localhost:3000")
@RestController
@RequestMapping("/api")
public class CancellationPolicyController {

    @Autowired
    private CancellationPolicyRepository cancellationPolicyRepository;
    @GetMapping("/cancellationpolicies")
    private List<Policy> getAllCancellationPolicies(){

        return cancellationPolicyRepository.findAll();
    }

    @GetMapping("/cancellationpolicies/{policyId}")
    public Policy getCancellationPoliciesByID(@PathVariable Long policyId) throws NotFoundException{

        Optional optPolicy = cancellationPolicyRepository.findById(policyId);
        if(optPolicy.isPresent()) {
            return (Policy)optPolicy.get();
        }else {
            throw new NotFoundException("Policy not found with id " + policyId);

        }

    }

    @PostMapping("/cancellationpolicies")
    public Policy createCancellationPolicies(@RequestBody Policy policy) {
        return cancellationPolicyRepository.save(policy);
    }

    @PutMapping("/cancellationpolicies/{policyId}")
    public Policy updateCancellationPolicies(@PathVariable Long policyId,
                                  @RequestBody Policy policyUpdated) throws NotFoundException{
        return cancellationPolicyRepository.findById(policyId)
                .map(policy -> {
                    policy.setPolicyName(policyUpdated.getPolicyName());
                    policy.setPolicyDescription(policyUpdated.getPolicyDescription());
                    policy.setPolicySource(policyUpdated.getPolicySource());
                    policy.setPolicyCancelRestrictionDays(policyUpdated.getPolicyCancelRestrictionDays());
                    policy.setPolicyCancelRestrictionHours(policyUpdated.getPolicyCancelRestrictionHours());
                    policy.setPolicyUpdatedBy(policyUpdated.getPolicyUpdatedBy());
                    policy.setPolicyUpdatedOn(policyUpdated.getPolicyUpdatedOn());
                    return cancellationPolicyRepository.save(policy);
                }).orElseThrow(() -> new NotFoundException("Policy not found with id " + policyId));
    }

    @DeleteMapping("/cancellationpolicies/{policyId}")
    public String deleteCancellationPolicies(@PathVariable Long policyId) throws NotFoundException{
        return cancellationPolicyRepository.findById(policyId)
                .map(policy -> {
                    cancellationPolicyRepository.delete(policy);
                    return "Delete Successfully!";
                }).orElseThrow(() -> new NotFoundException("Policy not found with id " + policyId));
    }



}