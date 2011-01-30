package com.googlecode.openrest;

import java.io.Serializable;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.TimeZone;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.map.annotate.JsonSerialize;

/**
 * Restaurant information.
 * @author DL
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Restaurant implements Serializable {
    public Restaurant(String id, String name, Contact contact, Integer deliveryCharge,
            Integer minOrderPrice, Address address, List<LatLng> deliveryArea,
            String welcomeMessage, String confirmationMessage, ColorScheme colorScheme,
            Availability openTimes, Availability deliveryTimes, Boolean inactive,
            Boolean deliveryInactive, String timezone, List<String> paymentTypes,
            Map<String, Integer> minPayments, String link) {
        
        this.id = id;
        this.name = name;
        this.contact = contact;
        this.deliveryCharge = deliveryCharge;
        this.minOrderPrice = minOrderPrice;
        this.address = address;
        this.deliveryArea = deliveryArea;
        this.welcomeMessage = welcomeMessage;
        this.confirmationMessage = confirmationMessage;
        this.colorScheme = colorScheme;
        this.openTimes = openTimes;
        this.deliveryTimes = deliveryTimes;
        this.inactive = inactive;
        this.deliveryInactive = deliveryInactive;
        this.timezone = timezone;
        this.paymentTypes = paymentTypes;
        this.minPayments = minPayments;
        this.link = link;
    }

    /** Default constructor for JSON deserialization. */
    public Restaurant() {}

    public TimeZone timezone() {
        return TimeZone.getTimeZone(timezone);
    }
    
    /** The restaurant's unique id. */
    @JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
    public String id;

    /** The restaurant's name. */
    @JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
    public String name;

    /** The restaurant's contact. */
    @JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
    public Contact contact;

    /** The delivery charge (in "cents"). */
    @JsonSerialize(include = JsonSerialize.Inclusion.NON_DEFAULT)
    public Integer deliveryCharge = 0;

    /** The minimum allowed order price (in "cents"). */
    @JsonSerialize(include = JsonSerialize.Inclusion.NON_DEFAULT)
    public Integer minOrderPrice = 0;

    /** The address of this restaurant. */
    @JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
    public Address address;

    /** The delivery area (polygon vertices). */
    @JsonSerialize(include = JsonSerialize.Inclusion.NON_DEFAULT)
    public List<LatLng> deliveryArea = Collections.emptyList();

    /** The restaurant's welcome message. */
    @JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
    public String welcomeMessage;

    /** The default order confirmation message. */
    @JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
    public String confirmationMessage;

    /** The color scheme. */
    @JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
    public ColorScheme colorScheme;

    /** Restaurant availability. */
    @JsonSerialize(include = JsonSerialize.Inclusion.NON_DEFAULT)
    public Availability openTimes = new Availability();

    /** Deliveries availability. */
    @JsonSerialize(include = JsonSerialize.Inclusion.NON_DEFAULT)
    public Availability deliveryTimes = new Availability();

    /** Whether the restaurant is deactivated (i.e. suspended or disabled). */
    @JsonSerialize(include = JsonSerialize.Inclusion.NON_DEFAULT)
    public Boolean inactive = Boolean.FALSE;

    /** Whether deliveries are deactivated (i.e. suspended or disabled). */
    @JsonSerialize(include = JsonSerialize.Inclusion.NON_DEFAULT)
    public Boolean deliveryInactive = Boolean.FALSE;

    /** The current status. */
    @JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
    public Status status;

    /** The current delivery status. */
    @JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
    public Status deliveryStatus;

    /** Human readable status string. */
    @JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
    public String openTimesStr;

    /** Human readable delivery status string. */
    @JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
    public String deliveryTimesStr;

    /**
     * The restaurant's timezone.
     * @see http://en.wikipedia.org/wiki/List_of_tz_database_time_zones
     */
    @JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
    public String timezone;

    /** Available payment methods. */
    @JsonSerialize(include = JsonSerialize.Inclusion.NON_DEFAULT)
    public List<String> paymentTypes = Payment.ALL_PAYMENT_TYPES;

    /**
     * Maps available payment types to minimal charge allowed per payment, e.g.
     * "credit cards can only be used for paying $5 or more". Non-referenced
     * payment types have zero minimum by default.
     */
    @JsonSerialize(include = JsonSerialize.Inclusion.NON_DEFAULT)
    public Map<String, Integer> minPayments = Collections.emptyMap();

    /** Official restaurant web-site. */
    @JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
    public String link;

    private static final long serialVersionUID = 1L;
}
