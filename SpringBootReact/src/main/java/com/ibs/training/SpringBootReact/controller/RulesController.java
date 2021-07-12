package com.ibs.training.SpringBootReact.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.ibs.training.SpringBootReact.exception.NotFoundException;
import com.ibs.training.SpringBootReact.model.Policy;
import com.ibs.training.SpringBootReact.model.Rules;
import com.ibs.training.SpringBootReact.repository.CancellationPolicyRepository;
import com.ibs.training.SpringBootReact.repository.RulesRepository;

import java.util.List;

@RestController
@RequestMapping("/api")
public class RulesController {
    @Autowired
    private RulesRepository rulesRepository;

    @Autowired
    private CancellationPolicyRepository cancellationPolicyRepository;

    @GetMapping("/cancellationpolicies/{policyId}/rules")
    public List getRulesById(@PathVariable Long policyId) throws NotFoundException{

        if(!cancellationPolicyRepository.existsById(policyId)) {
            throw new NotFoundException("Policy not found!");
        }

        return rulesRepository.findByPolicyId(policyId);
    }
    /*@PostMapping("/cancellationpolicies/{policyId}/rules")
    public Rules addRules(@PathVariable Long policyId,
                                    @RequestBody Rules rules)throws NotFoundException {
        return rulesRepository.findById(policyId)
                .map(policy -> {
                    rules.setPolicy(policy);
                    return rulesRepository.save(rules);
                }).orElseThrow(() -> new NotFoundException("Rule not found!"));
    }*/
    @PutMapping("/cancellationpolicies/{policyId}/rules{rulesId}")
    public Rules updateRules(@PathVariable Long policyId,
                                       @PathVariable Long rulesId,
                                        @RequestBody Rules rulesUpdated) throws NotFoundException {

        if(!cancellationPolicyRepository.existsById(policyId)) {
            throw new NotFoundException("Policy not found!");
        }

        return rulesRepository.findById(rulesId)
                .map(rules -> {
                    rules.setOffsetHours(rulesUpdated.getOffsetHours());
                    rules.setOffsetDays(rulesUpdated.getOffsetDays());
                    rules.setFeeBasis(rulesUpdated.getFeeBasis());
                    rules.setValue(rulesUpdated.getValue());
                    rules.setCurrency(rulesUpdated.getCurrency());
                    rules.setNoShow(rulesUpdated.isNoShow());
                    return rulesRepository.save(rules);
                }).orElseThrow(() -> new NotFoundException("Rule not found!"));
    }
    @DeleteMapping("/cancellationpolicies/{policyId}/rules{rulesId}")
    public String deleteRules(@PathVariable Long policyId,
                                   @PathVariable Long rulesId) throws NotFoundException {

        if(!cancellationPolicyRepository.existsById(policyId)) {
            throw new NotFoundException("Policy not found!");
        }

        return rulesRepository.findById(rulesId)
                .map(rules -> {
                    rulesRepository.delete(rules);
                    return "Deleted Successfully!";
                }).orElseThrow(() -> new NotFoundException("Rule not found!"));
    }



}
