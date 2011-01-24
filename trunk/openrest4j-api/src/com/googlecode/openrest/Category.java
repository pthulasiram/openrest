package com.googlecode.openrest;

import java.io.Serializable;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.map.annotate.JsonSerialize;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Category implements Serializable {
    public Category(String id, String restaurantId, String title, String description,
            String parentCategoryId, String tagId, Double priority) {
        this.id = id;
        this.restaurantId = restaurantId;
        this.title = title;
        this.description = description;
        this.parentCategoryId = parentCategoryId;
        this.tagId = tagId;
        this.priority = priority;
    }

    /** Default constructor for JSON deserialization. */
    public Category() {}

    /** The category's unique id. */
    @JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
    public String id;

    /** The restaurant's id. */
    @JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
    public String restaurantId;

    /** The category's title. */
    @JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
    public String title;

    /** The category's description. */
    @JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
    public String description;

    /** The parent category's id. */
    @JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
    public String parentCategoryId;

    /** The item-ids in this category. */
    @JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
    public String tagId;

    /** Order priority. Higher means first in the list. */
    @JsonSerialize(include = JsonSerialize.Inclusion.NON_DEFAULT)
    public Double priority = 0.0;
    
    private static final long serialVersionUID = 1L;
}
