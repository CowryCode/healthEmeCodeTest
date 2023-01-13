package com.cowrycode.mhealth.provider_services_microservice.services;

import com.cowrycode.mhealth.provider_services_microservice.models.HealthCareServiceDTO;

public interface HealthcareserviceService {
    HealthCareServiceDTO createService(HealthCareServiceDTO healthCareServiceDTO);
    HealthCareServiceDTO deleteService(Long id);
    HealthCareServiceDTO updateService(HealthCareServiceDTO healthCareServiceDTO);
}
