package com.exercise.model;

public enum SpinType {
    LEFT("L"),
    RIGHT("R"),
    UNKNOWN("U");


    private final String code;
    SpinType(String code) {
        this.code = code;
    }


    public static SpinType fromCode(String code) {
        for (SpinType type : values()) {
            if (type.code.equals(code)) {
                return type;
            }
        }
        return UNKNOWN;
    }
}
