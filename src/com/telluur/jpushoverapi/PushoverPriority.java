package com.telluur.pushover;

public enum PushoverPriority {
    LOWEST(-2),
    LOW(-1),
    NORMAL(0),
    HIGH(1),
    EMERGENCY(2);

    private int value;

    private PushoverPriority(int value) {
        this.value = value;
    }

    public int getValue() {
        return this.value;
    }
}
