package com.cowrycode.mhealth.patients_details_microservice.services;

import com.cowrycode.mhealth.patients_details_microservice.models.PatientProfileDTO;

public interface PatientProfileService {
    PatientProfileDTO createProfile(PatientProfileDTO patientProfileDTO);
    PatientProfileDTO getProfile(Long ownerIdentifer);
    PatientProfileDTO updateProfile(PatientProfileDTO patientProfileDTO);
}
