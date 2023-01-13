package com.cowrycode.mhealth.patients_details_microservice.services;

import com.cowrycode.mhealth.patients_details_microservice.models.PatientProfileDTO;

import java.util.List;

public interface PatientProfileService {
    PatientProfileDTO createProfile(PatientProfileDTO patientProfileDTO);
    PatientProfileDTO getProfile(Long id);
    List<PatientProfileDTO> getProviderPatients(String providerID);
    PatientProfileDTO updateProfile(PatientProfileDTO patientProfileDTO);
}
