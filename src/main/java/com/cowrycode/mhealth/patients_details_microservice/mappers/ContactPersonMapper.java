package com.cowrycode.mhealth.patients_details_microservice.mappers;

import com.cowrycode.mhealth.patients_details_microservice.domains.ContactPerson;
import com.cowrycode.mhealth.patients_details_microservice.models.ContactPersonDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ContactPersonMapper {
    ContactPersonMapper INSTANCE = Mappers.getMapper(ContactPersonMapper.class);

    ContactPerson entityToDTO(ContactPersonDTO contactPersonDTO);
    ContactPersonDTO DTOtoEntity(ContactPerson contactPerson);
}
