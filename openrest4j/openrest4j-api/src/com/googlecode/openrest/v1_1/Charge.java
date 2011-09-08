package com.googlecode.openrest.v1_1;

import java.io.Serializable;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.map.annotate.JsonSerialize;

/**
 * An extra charge or a discount associated with an order.
 * Examples: delivery charge, state tax, discount coupon.
 * 
 * TODO: time availability ("happy hour"), geography filter (delivery charge).
 * 
 * @author DL
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Charge implements Serializable {
	/** Delivery charge. */
    public static final String CHARGE_TYPE_DELIVERY = "delivery";
    /** Discount coupon. */
    public static final String CHARGE_TYPE_COUPON = "coupon";
    /** Member discount. */
    public static final String CHARGE_TYPE_CLUB_COUPON = "club_coupon";
    
    /** All known charges. */
    public static final Set<String> ALL_CHARGE_TYPES = new HashSet<String>(Arrays.asList(new String[] {
    		CHARGE_TYPE_DELIVERY, CHARGE_TYPE_COUPON, CHARGE_TYPE_CLUB_COUPON
    }));
    
	/** Amount rule is a fixed number. */
    public static final String AMOUNT_RULE_TYPE_FIXED = "fixed";
	/** Amount rule is percentage of some baseline amount. */
    public static final String AMOUNT_RULE_TYPE_PERCENTAGE = "percentage";
	/** Amount rule is variable, depending on external factors. */
    public static final String AMOUNT_RULE_TYPE_VARIABLE = "variable";

    /** All known amount rule types. */
    public static final Set<String> ALL_AMOUNT_RULE_TYPES = new HashSet<String>(Arrays.asList(new String[] {
    		AMOUNT_RULE_TYPE_FIXED, AMOUNT_RULE_TYPE_PERCENTAGE, AMOUNT_RULE_TYPE_VARIABLE
    }));

    /** Constructs a previously submitted charge from persisted data. */
    public Charge(String id, String restaurantId, String type, Double priority,
    		String code, String clubId,
    		String tagId, String tagMode,
    		String amountRuleType, Integer amountRule, Coupon coupon, Integer amount) {
    	this.id = id;
    	this.restaurantId = restaurantId;
        this.type = type;
        this.priority = priority;
        this.code = code;
        this.clubId = clubId;
        this.tagId = tagId;
        this.tagMode = tagMode;
        this.amountRuleType = amountRuleType;
        this.amountRule = amountRule;
        this.coupon = coupon;
        this.amount = amount;
    }
    
    /** Constructs a new charge to be submitted. */
    public Charge(String type, Double priority, String code, String clubId,
    		String tagId, String tagMode,
    		String amountRuleType, Integer amountRule, Coupon coupon) {
    	this(null, null, type, priority, code, clubId, tagId, tagMode, amountRuleType, amountRule, coupon, null);
    }

	/** Default constructor for JSON deserialization. */
    public Charge() {}

    /** Charge id. */
    @JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
    public String id;
    
    /** Restaurant id. */
    @JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
    public String restaurantId;
    
    /** Charge type. */
    @JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
    public String type;

    /** Charge priority. Lower numbers appear first in the list. */
    @JsonSerialize(include = JsonSerialize.Inclusion.NON_DEFAULT)
    public Double priority = 0.0;
    
    /** Optional activation code (GoDaddy-style). */
    @JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
    public String code;
    
    /** Optional internal club-id. */
    @JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
    public String clubId;
    
    /** Items for which the charge applies, null if applies for every item. */
    @JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
    public String tagId;
   
    /** Tag mode: inclusive or exclusive. */
    @JsonSerialize(include = JsonSerialize.Inclusion.NON_DEFAULT)
    public String tagMode = Tag.TAG_MODE_INCLUDE;
    
    /** Charge amount rule type. */
    @JsonSerialize(include = JsonSerialize.Inclusion.NON_DEFAULT)
    public String amountRuleType = AMOUNT_RULE_TYPE_VARIABLE;
    
    /**
     * Charge amount rule (cents for fixed amounts, basis points for percentage
     * amounts, undefined for variable amounts).
     * 
     * Basis points are 1/100th of a percentage, e.g. -500 bp referes to 5% discount. 
     * 
     * Positive numbers are extra charges, negatives are discounts.
     */
    @JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
    public Integer amountRule;
    
    /** Coupon information (valid for CHARGE_TYPE_COUPON and CHARGE_TYPE_CLUB_COUPON). */
    @JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
    public Coupon coupon;
    
    /** Bottom-line charge amount (in cents). */
    @JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
    public Integer amount;
    
	public boolean equalsIgnoreAmount(Charge other) {
		if (this == other)
			return true;
		if (other == null)
			return false;
		if (amountRule == null) {
			if (other.amountRule != null)
				return false;
		} else if (!amountRule.equals(other.amountRule))
			return false;
		if (amountRuleType == null) {
			if (other.amountRuleType != null)
				return false;
		} else if (!amountRuleType.equals(other.amountRuleType))
			return false;
		if (coupon == null) {
			if (other.coupon != null)
				return false;
		} else if (!coupon.equals(other.coupon))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (restaurantId == null) {
			if (other.restaurantId != null)
				return false;
		} else if (!restaurantId.equals(other.restaurantId))
			return false;
		if (priority == null) {
			if (other.priority != null)
				return false;
		} else if (!priority.equals(other.priority))
			return false;
		if (code == null) {
			if (other.code != null)
				return false;
		} else if (!code.equals(other.code))
			return false;
		if (clubId == null) {
			if (other.clubId != null)
				return false;
		} else if (!clubId.equals(other.clubId))
			return false;
		if (tagId == null) {
			if (other.tagId != null)
				return false;
		} else if (!tagId.equals(other.tagId))
			return false;
		if (tagMode == null) {
			if (other.tagMode != null)
				return false;
		} else if (!tagMode.equals(other.tagMode))
			return false;
		if (type == null) {
			if (other.type != null)
				return false;
		} else if (!type.equals(other.type))
			return false;
		
		return true;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Charge other = (Charge) obj;
		
		if (!equalsIgnoreAmount(other)) {
			return false;
		} else if (amount == null) {
			if (other.amount != null) {
				return false;
			}
		} else if (!amount.equals(other.amount)) {
			return false;
		}
		
		return true;
	}
	
    @Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((amount == null) ? 0 : amount.hashCode());
		result = prime * result
				+ ((amountRule == null) ? 0 : amountRule.hashCode());
		result = prime * result
				+ ((amountRuleType == null) ? 0 : amountRuleType.hashCode());
		result = prime * result + ((code == null) ? 0 : code.hashCode());
		result = prime * result + ((coupon == null) ? 0 : coupon.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result
				+ ((priority == null) ? 0 : priority.hashCode());
		result = prime * result
				+ ((restaurantId == null) ? 0 : restaurantId.hashCode());
		result = prime * result + ((tagId == null) ? 0 : tagId.hashCode());
		result = prime * result + ((tagMode == null) ? 0 : tagMode.hashCode());
		result = prime * result + ((type == null) ? 0 : type.hashCode());
		return result;
	}
    
    private static final long serialVersionUID = 1L;
}
