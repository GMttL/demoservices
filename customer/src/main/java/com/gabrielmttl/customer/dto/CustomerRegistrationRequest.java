package com.gabrielmttl.customer.dto;



public record CustomerRegistrationRequest(
        String firstName,
        String lastName,
        String email) {

}
