package com.cowrycode.mhealth.provider_details_microservice.domains;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import java.time.LocalDate;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProviderProfileEntity extends ProviderBaseEntity{
    private String username;
    private String firstName;
    private String lastName;
    private LocalDate dateOfBirth;
    private String homeAddress;
    private String phoneNumber;
    private String emailAddress;
    private String userLanguage;
    private String services; // List of ID of all services (separated by comma)user subscribed to
    private String licenceNumber;
    private String patients; // List of Patients ID (Separated by comma.) a user can subscribe to different services managed by different providers
}
