package com.ibs.training.casestudy.policycancellation.controllers;



import com.ibs.training.casestudy.policycancellation.models.CancellationPolicy;
import com.ibs.training.casestudy.policycancellation.models.ExpediaRules;
import com.ibs.training.casestudy.policycancellation.repository.CancellationPolicyRepository;
import com.ibs.training.casestudy.policycancellation.repository.ExpediaRuleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class ExpediaRulesController {
    @Autowired
    ExpediaRuleRepository expediaRuleRepository;

    @Autowired
    CancellationPolicyRepository cancellationPolicyRepository;

    @GetMapping("/cancellationpolicies/{id}/rules")
    public ResponseEntity<ExpediaRules> getRulesById(@PathVariable("id") long policyId) {
        Optional<ExpediaRules> policy = expediaRuleRepository.findById(policyId);
        if (policy.isPresent()) {
            return new ResponseEntity<>(policy.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
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
/*@PostMapping("/cancellationpolicies")
//Add new Cancellation Policy (Learn more about ResponseEntity)
public ResponseEntity<ExpediaRules> addExpediaRules(@RequestBody ExpediaRules newRule) {
    try {
        List<ExpediaRules> expediaRules = newRule.getPolicy();
        expediaRules.forEach((rule) ->{
            rule.setPolicy(newRule);
        });
        newRule.setPolicy(expediaRules);
        ExpediaRules addedPolicy = expediaRuleRepository.save(newRule);

        return new ResponseEntity<>(addedPolicy, HttpStatus.CREATED);
    } catch (Exception exception) {
        return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}








    @PutMapping("/cancellationpolicies/{id}")
    public ResponseEntity<ExpediaRules> updateExpediaRules(@PathVariable("id") long policyId, @RequestBody ExpediaRules updatesPolicy) {
        Optional<ExpediaRules> policy = cancellationPolicyRepository.findById(policyId).map((selectedPolicy) ->{
            selectedPolicy.setPolicyId(updatesPolicy.getPolicyId());
            selectedPolicy.setPolicyName(updatesPolicy.getPolicyName());
            selectedPolicy.setPolicySource(updatesPolicy.getPolicySource());
            selectedPolicy.setPolicyDescription(updatesPolicy.getPolicyDescription());
            selectedPolicy.setPolicyUpdatedBy(updatesPolicy.getPolicyUpdatedBy());
            selectedPolicy.setPolicyUpdatedOn(updatesPolicy.getPolicyUpdatedOn());
            selectedPolicy.setPolicyCancelRestrictionDays(updatesPolicy.getPolicyCancelRestrictionDays());
            selectedPolicy.setPolicyCancelRestrictionHours(updatesPolicy.getPolicyCancelRestrictionHours());
            selectedPolicy.setRules(updatesPolicy.getRules());
            return expediaRuleRepository.save(selectedPolicy);
        });
        if (policy.isPresent()) {
            ExpediaRules updatedPolicy = policy.get();
            return new ResponseEntity<>(updatedPolicy, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }



    @DeleteMapping("/cancellationpolicies/{id}")
    public ResponseEntity<HttpStatus> deleteExpediaRules(@PathVariable("id") long policyId) {
        try {
            expediaRuleRepository.deleteById(policyId);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }*/






}
