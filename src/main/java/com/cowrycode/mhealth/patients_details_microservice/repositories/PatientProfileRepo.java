package com.cowrycode.mhealth.patients_details_microservice.repositories;

import com.cowrycode.mhealth.patients_details_microservice.domains.PatientProfile;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PatientProfileRepo extends JpaRepository<PatientProfile, Long> {
    PatientProfile findPatientProfileByOwneridentifier(Long ownerIdentifier);
    List<PatientProfile> findPatientProfileByProvidersContainsIgnoreCase(String providerID);
}
