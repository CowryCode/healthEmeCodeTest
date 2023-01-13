package com.cowrycode.mhealth.provider_services_microservice.services;

import com.cowrycode.mhealth.provider_services_microservice.domains.HealthCareServiceEntity;
import com.cowrycode.mhealth.provider_services_microservice.mappers.HealthCareServiceMapper;
import com.cowrycode.mhealth.provider_services_microservice.models.HealthCareServiceDTO;
import com.cowrycode.mhealth.provider_services_microservice.repositories.HealthCareServiceRepo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

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
    public List<HealthCareServiceDTO> getPatientSubscribedServices(String patietnID) {
        try{
            List<HealthCareServiceEntity> services = healthCareServiceRepo.findHealthCareServiceEntitiesByPatientsContainingIgnoreCase(patietnID);
            return services.stream().map(healthCareServiceMapper::entityToDTO).collect(Collectors.toList());
        }catch (Exception e){
            return null;
        }
    }

    @Override
    public List<HealthCareServiceDTO> getProviderSubscribedServices(String providerID) {
        try{
            List<HealthCareServiceEntity> services = healthCareServiceRepo.findHealthCareServiceEntitiesByProvidersContainingIgnoreCase(providerID);
            return services.stream().map(healthCareServiceMapper::entityToDTO).collect(Collectors.toList());
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
