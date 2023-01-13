package com.cowrycode.mhealth.patients_details_microservice.services;

import com.cowrycode.mhealth.patients_details_microservice.domains.ContactPerson;
import com.cowrycode.mhealth.patients_details_microservice.domains.PatientProfile;
import com.cowrycode.mhealth.patients_details_microservice.mappers.PatientProfileMapper;
import com.cowrycode.mhealth.patients_details_microservice.models.PatientProfileDTO;
import com.cowrycode.mhealth.patients_details_microservice.repositories.ContactPersonRepo;
import com.cowrycode.mhealth.patients_details_microservice.repositories.PatientProfileRepo;
import org.springframework.stereotype.Service;

@Service
public class PatientProfileServiceImpl implements PatientProfileService {
    private final PatientProfileRepo patientProfileRepo;
    private final ContactPersonRepo contactPersonRepo;

    private final PatientProfileMapper patientMapper = PatientProfileMapper.INSTANCE;

    public PatientProfileServiceImpl(PatientProfileRepo patientProfileRepo, ContactPersonRepo contactPersonRepo) {
        this.patientProfileRepo = patientProfileRepo;
        this.contactPersonRepo = contactPersonRepo;
    }

    @Override
    public PatientProfileDTO createProfile(PatientProfileDTO patientProfileDTO) {
        try {
            ContactPerson savedContact = contactPersonRepo.save(patientProfileDTO.getContactPerson());

            PatientProfile profile = patientMapper.DTOtoEntty(patientProfileDTO);
            profile.setContactPerson(savedContact);
            PatientProfile savedPatient = patientProfileRepo.save(profile);
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
