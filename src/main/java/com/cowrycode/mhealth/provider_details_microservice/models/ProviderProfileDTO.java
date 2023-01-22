package com.cowrycode.mhealth.provider_details_microservice.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProviderProfileDTO {
    private Long id;
    private Long owneridentifier;
    private String username;
    private String firstName;
    private String lastName;
    private String specialty;
    private String languages;
    private String country;
    private String state;
    private String gender;
    private String avatar; // Image Url
    private double rating;
    private boolean isVailable;
    private LocalTime openingTime;
    private LocalTime closingTime;
    private LocalDate dateOfBirth;
    private String homeAddress;
    private String phoneNumber;
    private String emailAddress;
    private String services; // List of ID of all services (separated by comma)user subscribed to
    private String licenceNumber;
    private String patients; // List of Patients ID (Separated by comma.) a user can subscribe to different services managed by different providers

}
