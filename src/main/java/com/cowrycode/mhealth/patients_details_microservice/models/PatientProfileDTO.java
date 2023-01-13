package com.cowrycode.mhealth.patients_details_microservice.models;

import com.cowrycode.mhealth.patients_details_microservice.domains.ContactPerson;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PatientProfileDTO {
    private Long id;
    private Long owneridentifier;
    private String username;
    private String firstName;
    private String lastName;
    private LocalDate dateOfBirth;
    private String homeAddress;
    private String phoneNumber;
    private String emailAddress;
    private String userLanguage;
    private String services; // List of ID of all services (separated by comma)user subscribed to
    private ContactPerson contactPerson;
}
