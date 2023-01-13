package com.cowrycode.mhealth.provider_services_microservice.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class HealthCareServiceDTO {
    private Long id;
    private Long owneridentifier;
    private String servicename;
    private Double price;
    private int priority;
    private String providers; // Collection of providers' ID separated by comma
    private String patients;
    private boolean subscribed; // This indicates if the User pulling this subscribes to this server - it is not saved on DB
}
