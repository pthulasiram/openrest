package com.googlecode.openrest;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.map.annotate.JsonSerialize;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Payment implements Serializable {
    /** Cash payment. */
    public static final String PAYMENT_TYPE_CASH = "cash";
    /** Credit card payment. */
    public static final String PAYMENT_TYPE_CREDIT = "credit";

    /** All payment methods, in ascending alphabetic order! */
    public static final List<String> ALL_PAYMENT_TYPES = Arrays.asList(new String[] {
        PAYMENT_TYPE_CASH, PAYMENT_TYPE_CREDIT
    });

    public Payment(String type, Integer amount, CreditCard card) {
        this.type = type;
        this.amount = amount;
        this.card = card;
    }

    /** Default constructor for JSON deserialization. */
    public Payment() {}

    /** Payment type. */
    @JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
    public String type;

    /** Amount to pay. */
    @JsonSerialize(include = JsonSerialize.Inclusion.NON_DEFAULT)
    public Integer amount = 0;

    /** Credit card details (valid only if type is PAYMENT_TYPE_CREDIT) */
    @JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
    public CreditCard card;

    private static final long serialVersionUID = 1L;
}
