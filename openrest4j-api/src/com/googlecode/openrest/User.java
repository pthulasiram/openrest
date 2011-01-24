package com.googlecode.openrest;

import java.io.Serializable;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.map.annotate.JsonSerialize;

/**
 * Information regarding a remote user of the system.
 * @author DL
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class User implements Serializable {
    public User(String id, String ipAddress, String upIpAddress) {
        this.id = id;
        this.ipAddress = ipAddress;
        this.upIpAddress = upIpAddress;
    }

    /** Default constructor for JSON deserialization. */
    public User() {}

    /** The user's Facebook id. */
    @JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
    public String id;

    /**
     * The immediate client's IP address. If the real client is separated from the
     * server by a proxy server, this will return the IP address of the proxy.
     */
    @JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
    public String ipAddress;

    /**
     * The IP address of the upstream client component.
     * In general this will correspond the the user agent IP address (but can be spoofed).
     */
    @JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
    public String upIpAddress;

    private static final long serialVersionUID = 1L;
}
