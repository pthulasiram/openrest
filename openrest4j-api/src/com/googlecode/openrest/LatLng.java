package com.googlecode.openrest;

import java.io.Serializable;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.map.annotate.JsonSerialize;

@JsonIgnoreProperties(ignoreUnknown = true)
public class LatLng implements Serializable {
    public LatLng(Double lat, Double lng) {
        this.lat = lat;
        this.lng = lng;
    }

    /** Default constructor for JSON deserialization. */
    public LatLng() {}

    @JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
    public Double lat;

    @JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
    public Double lng;
    
    private static final long serialVersionUID = 1L;
}
