package com.cowrycode.mhealth.provider_services_microservice.services;

import com.cowrycode.mhealth.provider_services_microservice.domains.HealthCareServiceEntity;
import com.cowrycode.mhealth.provider_services_microservice.mappers.HealthCareServiceMapper;
import com.cowrycode.mhealth.provider_services_microservice.models.HealthCareServiceDTO;
import com.cowrycode.mhealth.provider_services_microservice.repositories.HealthCareServiceRepo;
import org.springframework.stereotype.Service;

@Service
public class HealthcareserviceServiceimpl implements HealthcareserviceService{
    private final HealthCareServiceRepo healthCareServiceRepo;
    private final HealthCareServiceMapper healthCareServiceMapper = HealthCareServiceMapper.INSTANCE;

    public HealthcareserviceServiceimpl(HealthCareServiceRepo healthCareServiceRepo) {
        this.healthCareServiceRepo = healthCareServiceRepo;
    }

    @Override
    public HealthCareServiceDTO createService(HealthCareServiceDTO healthCareServiceDTO) {
        try{
            HealthCareServiceEntity saveService = healthCareServiceRepo.save(healthCareServiceMapper.DTOtoEntity(healthCareServiceDTO));
            return healthCareServiceMapper.entityToDTO(saveService);
        }catch (Exception e){
            return null;
        }
    }

    @Override
    public HealthCareServiceDTO deleteService(Long id) {
        return null;
    }

    @Override
    public HealthCareServiceDTO updateService(HealthCareServiceDTO healthCareServiceDTO) {
        return null;
    }
}
