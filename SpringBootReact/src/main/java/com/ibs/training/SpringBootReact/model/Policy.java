package com.ibs.training.SpringBootReact.model;



import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "POLICIES")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Policy implements Serializable {
    private static final long serialVersionUID = 1L;

    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    @Column(name="POLICY_ID")
    private long policyId;

    @Column(name="POLICY_NAME")
    private String policyName;

    @Column(name="POLICY_DESCRIPTION")
    private String policyDescription;

    @Column(name="POLICY_SOURCE")
    private String policySource;

    @Column(name="POLICY_CANCEL_RESTRICTION_DAYS")
    private int policyCancelRestrictionDays;

    @Column(name="POLICY_CANCEL_RESTRICTION_HOURS")
    private int policyCancelRestrictionHours;

    @Column(name="POLICY_UPDATED_BY")
    private String policyUpdatedBy;

    @Column(name="POLICY_UPDATED_ON")
    private LocalDateTime policyUpdatedOn;


    public long getPolicyId() {
        return policyId;
    }

    public void setPolicyId(long policyId) {
        this.policyId = policyId;
    }

    public String getPolicyName() {
        return policyName;
    }

    public void setPolicyName(String policyName) {
        this.policyName = policyName;
    }

    public String getPolicyDescription() {
        return policyDescription;
    }

    public void setPolicyDescription(String policyDescription) {
        this.policyDescription = policyDescription;
    }

    public String getPolicySource() {
        return policySource;
    }

    public void setPolicySource(String policySource) {
        this.policySource = policySource;
    }

    public int getPolicyCancelRestrictionDays() {
        return policyCancelRestrictionDays;
    }

    public void setPolicyCancelRestrictionDays(int policyCancelRestrictionDays) {
        this.policyCancelRestrictionDays = policyCancelRestrictionDays;
    }

    public int getPolicyCancelRestrictionHours() {
        return policyCancelRestrictionHours;
    }

    public void setPolicyCancelRestrictionHours(int policyCancelRestrictionHours) {
        this.policyCancelRestrictionHours = policyCancelRestrictionHours;
    }

    public String getPolicyUpdatedBy() {
        return policyUpdatedBy;
    }

    public void setPolicyUpdatedBy(String policyUpdatedBy) {
        this.policyUpdatedBy = policyUpdatedBy;
    }

    public LocalDateTime getPolicyUpdatedOn() {
        return policyUpdatedOn;
    }

    public void setPolicyUpdatedOn(LocalDateTime policyUpdatedOn) {
        this.policyUpdatedOn = policyUpdatedOn;
    }

    @OneToMany(mappedBy = "policy", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Rules> rules;

    public List<Rules> getRules() {
        return rules;
    }

    public void setRules(List<Rules> rules) {
        this.rules = rules;
    }
}
