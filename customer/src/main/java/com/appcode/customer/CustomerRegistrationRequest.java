package com.appcode.customer;

public record CustomerRegistrationRequest(
        String firstNam,
        String lastName,
        String email) {
}
