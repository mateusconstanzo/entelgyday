package com.example.multitenancy;

public enum TenantEnum {

    CLIENTE1("cliente1"), DEFAULT("default");

    private String value;

    TenantEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
