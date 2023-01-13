package com.cowrycode.mhealth.provider_services_microservice.mappers;

import com.cowrycode.mhealth.provider_services_microservice.domains.HealthCareServiceEntity;
import com.cowrycode.mhealth.provider_services_microservice.models.HealthCareServiceDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface HealthCareServiceMapper {
    HealthCareServiceMapper INSTANCE = Mappers.getMapper(HealthCareServiceMapper.class);

    HealthCareServiceEntity DTOtoEntity(HealthCareServiceDTO healthCareServiceDTO);
    HealthCareServiceDTO entityToDTO(HealthCareServiceEntity healthCareServiceEntity);
}
