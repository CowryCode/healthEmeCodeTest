package com.cowrycode.mhealth.patients_details_microservice.mappers;

import com.cowrycode.mhealth.patients_details_microservice.domains.PatientProfile;
import com.cowrycode.mhealth.patients_details_microservice.models.PatientProfileDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface PatientProfileMapper {
    PatientProfileMapper INSTANCE = Mappers.getMapper(PatientProfileMapper.class);

    PatientProfileDTO entityToDTO (PatientProfile patientProfile);
    PatientProfile DTOtoEntty (PatientProfileDTO patientProfileDTO);
}
