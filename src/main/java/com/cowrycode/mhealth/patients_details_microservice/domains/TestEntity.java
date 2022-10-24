package com.cowrycode.mhealth.patients_details_microservice.domains;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TestEntity extends BaseEntity {
    String status;
}
