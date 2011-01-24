package com.googlecode.openrest;

import java.io.Serializable;
import java.util.Collections;
import java.util.List;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.map.annotate.JsonSerialize;

/**
 * An item that can be ordered, e.g. a main dish ("hamburger"), a side ("fries")
 * or a dish variation ("well done").
 * @author DL
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Item implements Serializable {
    public Item(String id, String restaurantId, String title, String description,
            Integer price, List<com.googlecode.openrest.Variation> variations,
            com.googlecode.openrest.Availability availability, Boolean inactive) {
        this.id = id;
        this.restaurantId = restaurantId;
        this.title = title;
        this.description = description;
        this.price = price;
        this.variations = variations;
        this.availability = availability;
        this.inactive = inactive;
    }

    /** Default constructor for JSON deserialization. */
    public Item() {}

    /** The item's unique id. */
    @JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
    public String id;

    /** The restaurant's id. */
    @JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
    public String restaurantId;

    /** The item's name. */
    @JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
    public String title;

    /** The item's one line description. */
    @JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
    public String description;

    /** The item's price, in "cents". */
    @JsonSerialize(include = JsonSerialize.Inclusion.NON_DEFAULT)
    public Integer price = 0;

    /** List of possible variations. */
    @JsonSerialize(include = JsonSerialize.Inclusion.NON_DEFAULT)
    public List<Variation> variations = Collections.emptyList();

    /** Time windows in which this item is regularly available. */
    @JsonSerialize(include = JsonSerialize.Inclusion.NON_DEFAULT)
    public Availability availability = new Availability();

    /** Human readable availability string. */
    @JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
    public String availabilityStr;

    /** Whether the item is deactivated (i.e. suspended or disabled). */
    @JsonSerialize(include = JsonSerialize.Inclusion.NON_DEFAULT)
    public Boolean inactive = Boolean.FALSE;

    /** The current status. */
    @JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
    public Status status;
    
    private static final long serialVersionUID = 1L;
}
