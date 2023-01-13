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
}
