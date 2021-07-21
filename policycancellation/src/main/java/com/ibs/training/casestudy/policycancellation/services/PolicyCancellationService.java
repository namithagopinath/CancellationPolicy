package com.ibs.training.casestudy.policycancellation.services;

import com.ibs.training.casestudy.policycancellation.models.CancellationPolicy;

import java.util.List;
import java.util.Optional;

public interface PolicyCancellationService {
    CancellationPolicy addCancellationPolicy(CancellationPolicy newPolicy) throws Exception;
    List<CancellationPolicy> retrievePolicies() throws Exception ;
    Optional<CancellationPolicy> updatePolicy(long policyId, CancellationPolicy editedPolicy);
    void deletePolicy(long policyId) throws Exception;

}