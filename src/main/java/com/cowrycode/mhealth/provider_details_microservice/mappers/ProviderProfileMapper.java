package com.cowrycode.mhealth.provider_details_microservice.mappers;

import com.cowrycode.mhealth.provider_details_microservice.domains.ProviderProfileEntity;
import com.cowrycode.mhealth.provider_details_microservice.models.ProviderProfileDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ProviderProfileMapper {
    ProviderProfileMapper INSTANCE = Mappers.getMapper(ProviderProfileMapper.class);

    ProviderProfileEntity DTOtoEntity(ProviderProfileDTO providerProfileDTO);
    ProviderProfileDTO entitiToDTO(ProviderProfileEntity providerProfileEntity);
}
