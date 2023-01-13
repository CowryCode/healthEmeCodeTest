package com.cowrycode.mhealth.provider_services_microservice.domains;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Transient;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class HealthCareServiceEntity extends ServiceBaseEntity {
    private String servicename;
    private Double price;
    private int priority; //This is in the order they will be displayed for users
    private String providers; // Collection of providers' ID separated by comma
    private String patients; // Collection of Patients' ID that subscribed to the service separated by comma
    @Transient
    private boolean subscribed;
}
