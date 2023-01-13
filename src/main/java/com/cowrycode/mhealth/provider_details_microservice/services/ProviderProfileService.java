package com.cowrycode.mhealth.provider_details_microservice.services;

import com.cowrycode.mhealth.provider_details_microservice.models.ProviderProfileDTO;

import java.util.List;

public interface ProviderProfileService {
    ProviderProfileDTO createProviderProfile(ProviderProfileDTO providerProfileDTO);
    ProviderProfileDTO getProviderProfile(Long providerID);
    List<ProviderProfileDTO> getPatientProviders(String patientID);
    List<ProviderProfileDTO> getServiceProviders(String providerID);
}
