package com.cowrycode.mhealth.patients_details_microservice.domains;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Transient;
import java.time.LocalDate;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PatientProfile extends BaseEntity{
    private String username;
    private String firstName;
    private String lastName;
    private LocalDate dateOfBirth;
    private String homeAddress;
    private String phoneNumber;
    private String emailAddress;
    private String userLanguage;
    private String services; // List of ID of all services (separated by comma)user subscribed to
    @Transient
    private String contactPersonName;
    @Transient
    private String contactPhoneNumber;
    @Transient
    private String contactEmailAddress;
    @Transient
    private String contactentityownerIdentifier;
}
