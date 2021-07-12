package com.ibs.training.SpringBootReact.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.io.Serializable;


@Entity
@Table(name = "RULE_SET")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Rules  implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Column(name = "POLICY_ID")
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private long policyId;

    @Column(name = "OFFSET_HOURS")
    private int offsetHours;

    @Column(name = "OFFSET_DAYS")
    private int offsetDays;

    @Column(name = "FEE_BASIS")
    private String feeBasis;

    @Column(name = "VALUE")
    private int value;

    @Column(name = "CURRENCY")
    private String currency;

    @Column(name = "NO_SHOW")
    private boolean noShow;

    public long getPolicyId() {
        return policyId;
    }

    public void setPolicyId(long policyId) {
        this.policyId = policyId;
    }

    public int getOffsetHours() {
        return offsetHours;
    }

    public void setOffsetHours(int offsetHours) {
        this.offsetHours = offsetHours;
    }

    public int getOffsetDays() {
        return offsetDays;
    }

    public void setOffsetDays(int offsetDays) {
        this.offsetDays = offsetDays;
    }

    public String getFeeBasis() {
        return feeBasis;
    }

    public void setFeeBasis(String feeBasis) {
        this.feeBasis = feeBasis;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public boolean isNoShow() {
        return noShow;
    }

    public void setNoShow(boolean noShow) {
        this.noShow = noShow;
    }

    @ManyToOne
    @JoinColumn(name = "POLICYID")
    @JsonIgnore
    private Policy policy;

	public Policy getPolicy() {
		return policy;
	}

	public void setPolicy(Policy policy) {
		this.policy = policy;
	}

    
}
