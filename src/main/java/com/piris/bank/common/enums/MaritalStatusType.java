package com.piris.bank.common.enums;

public enum MaritalStatusType {

    MARRIED("Married"),
    DIVORCE("Divorce"),
    WIDOW("Widow/Widower"),
    SINGLE("Single"),
    CONJUGAL_RELATIONSHIP("Conjugal relationship");

    private String label;

    MaritalStatusType(String label) {
        this.label = label;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }
}
