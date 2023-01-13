package com.cowrycode.mhealth.provider_services_microservice.domains;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class HealthCareServiceEntity extends ProviderBaseEntity{
    private String servicename;
    private Double price;
    private int priority; //This is in the order they will be displayed for users
    private String providers; // Collection of providers' ID separated by comma
}
