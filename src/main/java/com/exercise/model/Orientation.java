package com.exercise.model;

public enum Orientation {

    NORTH("N"),
    SOUTH("S"),
    WEST("W"),
    EAST("E"),
    UNKNOWN("U"),

    ;

    private final String code;
    Orientation(String code) {
        this.code = code;
    }

    public static Orientation fromCode(String code) {
        for (Orientation orientation : values()) {
            if (orientation.code.equals(code)) {
                return orientation;
            }
        }
        return UNKNOWN;
    }

    @Override
    public String toString() {
        return code;
    }
}
