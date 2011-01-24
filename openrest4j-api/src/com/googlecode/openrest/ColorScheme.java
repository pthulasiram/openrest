package com.googlecode.openrest;

import java.io.Serializable;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.map.annotate.JsonSerialize;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ColorScheme implements Serializable {
    public static final String THEME_LIGHT = "light";
    public static final String THEME_DARK = "dark";

    public ColorScheme(String theme, String background, String font, String border, String imageBackground,
            String buttonFont, String buttonUp, String buttonDown, String buttonOver) {

        this.theme = theme;
        this.background = background;
        this.font = font;
        this.border = border;
        this.imageBackground = imageBackground;
        this.buttonFont = buttonFont;
        this.buttonUp = buttonUp;
        this.buttonDown = buttonDown;
        this.buttonOver = buttonOver;
    }

    /** Default constructor for JSON deserialization. */
    public ColorScheme() {}

    @JsonSerialize(include=JsonSerialize.Inclusion.NON_NULL)
    public String theme;

    @JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
    public String background;

    @JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
    public String font;

    @JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
    public String border;

    @JsonSerialize(include=JsonSerialize.Inclusion.NON_NULL)
    public String imageBackground;

    @JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
    public String buttonFont;

    @JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
    public String buttonUp;

    @JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
    public String buttonDown;

    @JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
    public String buttonOver;
    
    private static final long serialVersionUID = 1L;
}
