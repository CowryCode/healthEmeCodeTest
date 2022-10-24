package com.cowrycode.mhealth.patients_details_microservice.mappers;

import com.cowrycode.mhealth.patients_details_microservice.domains.TestEntity;
import com.cowrycode.mhealth.patients_details_microservice.models.TestDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface TestMapper {
    TestMapper INSTANCE = Mappers.getMapper(TestMapper.class);
    TestEntity DTOtoEntity(TestDTO testDTO);
    TestDTO EntitytoDTO(TestEntity testEntity);
}
