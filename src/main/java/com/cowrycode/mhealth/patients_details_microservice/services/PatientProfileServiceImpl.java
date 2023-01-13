package com.cowrycode.mhealth.patients_details_microservice.services;

import com.cowrycode.mhealth.patients_details_microservice.domains.PatientProfile;
import com.cowrycode.mhealth.patients_details_microservice.mappers.PatientProfileMapper;
import com.cowrycode.mhealth.patients_details_microservice.models.PatientProfileDTO;
import com.cowrycode.mhealth.patients_details_microservice.repositories.PatientProfileRepo;
import org.springframework.stereotype.Service;

@Service
public class PatientProfileServiceImpl implements PatientProfileService {
    private final PatientProfileRepo patientProfileRepo;

    private final PatientProfileMapper patientMapper = PatientProfileMapper.INSTANCE;

    public PatientProfileServiceImpl(PatientProfileRepo patientProfileRepo) {
        this.patientProfileRepo = patientProfileRepo;
    }

    @Override
    public PatientProfileDTO createProfile(PatientProfileDTO patientProfileDTO) {
        try {
            PatientProfile savedPatient = patientProfileRepo.save(patientMapper.DTOtoEntty(patientProfileDTO));
            return patientMapper.entityToDTO(savedPatient);
        }catch (Exception e){
            return null;
        }
    }

    @Override
    public PatientProfileDTO getProfile(Long ownerIdentifer) {
        try{
            PatientProfile profile = patientProfileRepo.findPatientProfileByOwneridentifier(ownerIdentifer);
            return patientMapper.entityToDTO(profile);
        }catch (Exception e){
            return null;
        }
    }

    @Override
    public PatientProfileDTO updateProfile(PatientProfileDTO patientProfileDTO) {
        return null;
    }
}
