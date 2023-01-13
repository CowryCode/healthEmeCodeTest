package com.cowrycode.mhealth.patients_details_microservice.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TestDTO {
    private Long id;
    private Long owneridentifier;
    private LocalDateTime dateCreated;
    String status;
}
