package com.cowrycode.mhealth.provider_details_microservice.repositories;

import com.cowrycode.mhealth.provider_details_microservice.domains.ProviderProfileEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProviderProfileRepo extends JpaRepository<ProviderProfileEntity, Long> {
    List<ProviderProfileEntity> findProviderProfileEntitiesByServicesContainingIgnoreCase(String serviceID);
    List<ProviderProfileEntity> findProviderProfileEntitiesByPatientsContainingIgnoreCase(String serviceID);

}
