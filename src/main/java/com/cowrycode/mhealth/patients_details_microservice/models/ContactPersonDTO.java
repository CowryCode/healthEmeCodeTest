package com.cowrycode.mhealth.patients_details_microservice.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ContactPersonDTO {
    private Long id;
    private Long owneridentifier;
    private String contactPersonName;
    private String contactPhoneNumber;
    private String contactEmailAddress;
    private String contactentityownerIdentifier;
}
