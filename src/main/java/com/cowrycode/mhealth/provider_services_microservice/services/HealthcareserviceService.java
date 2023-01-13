package com.cowrycode.mhealth.provider_services_microservice.services;

import com.cowrycode.mhealth.provider_services_microservice.models.HealthCareServiceDTO;

import java.util.List;

public interface HealthcareserviceService {
    HealthCareServiceDTO createService(HealthCareServiceDTO healthCareServiceDTO);
    List<HealthCareServiceDTO> getPatientSubscribedServices(String patietnID);
    List<HealthCareServiceDTO> getProviderSubscribedServices(String providerID);

    HealthCareServiceDTO deleteService(Long id);
    HealthCareServiceDTO updateService(HealthCareServiceDTO healthCareServiceDTO);
}
