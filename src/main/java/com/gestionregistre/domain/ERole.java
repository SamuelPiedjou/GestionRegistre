package com.gestionregistre.domain;

public enum ERole {
    USER("USER"), AGENT("AGENT"), ADMIN("ADMIN"), CUSTOMER("CUSTOMER");

    String status;

    ERole(String status) {
        this.status = status;
    }
}
