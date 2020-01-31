package com.piris.bank.common.enums;

public enum GenderType {

    MALE("Male"),
    FEMALE("Female"),
    OTHER("Other");

    private String gender;

    GenderType(String gender) {
        this.gender = gender;
    }

    public String getGender() {
        return gender;
    }
}
