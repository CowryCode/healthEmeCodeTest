package com.cowrycode.mhealth.provider_services_microservice.repositories;

import com.cowrycode.mhealth.provider_services_microservice.domains.HealthCareServiceEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface HealthCareServiceRepo extends JpaRepository<HealthCareServiceEntity, Long> {
    List<HealthCareServiceEntity> findHealthCareServiceEntitiesByPatientsContainingIgnoreCase(String patientID);
    List<HealthCareServiceEntity> findHealthCareServiceEntitiesByProvidersContainingIgnoreCase(String providerID);
}
