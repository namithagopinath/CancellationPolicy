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
            rule.setRules(newRule);
        });
        newRule.setRules(expediaRules);
        ExpediaRules addedRules = expediaRuleRepository.save(newRule);

        return new ResponseEntity<>(addedRules, HttpStatus.CREATED);
    } catch (Exception exception) {
        return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}*/


    @PutMapping("/cancellationpolicies/{id}")
    public ResponseEntity<ExpediaRules> updateExpediaRules(@PathVariable("id") long ruleId, @RequestBody ExpediaRules updatesRule) {
        Optional<ExpediaRules> rule = expediaRuleRepository.findById(ruleId).map((selectedRules) ->{
            selectedRules.setRuleId(updatesRule.getRuleId());
            selectedRules.setOffsetHours(updatesRule.getOffsetHours());
            selectedRules.setOffsetDays(updatesRule.getOffsetDays());
            selectedRules.setFeeBasis(updatesRule.getFeeBasis());
            selectedRules.setValue(updatesRule.getValue());
            selectedRules.setCurrency(updatesRule.getCurrency());
            selectedRules.setNoShow(updatesRule.isNoShow());

            selectedRules.setPolicy(updatesRule.getPolicy());
            return expediaRuleRepository.save(selectedRules);
        });
        if (rule.isPresent()) {
            ExpediaRules updatedRule = rule.get();
            return new ResponseEntity<>(updatedRule, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }



    @DeleteMapping("/cancellationpolicies/{id}")
    public ResponseEntity<HttpStatus> deleteExpediaRules(@PathVariable("id") long ruleId) {
        try {
            expediaRuleRepository.deleteById(ruleId);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }


    }

    }






}
