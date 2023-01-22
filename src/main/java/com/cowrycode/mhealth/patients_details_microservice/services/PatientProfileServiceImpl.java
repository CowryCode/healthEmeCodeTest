package com.cowrycode.mhealth.patients_details_microservice.services;

import com.cowrycode.mhealth.patients_details_microservice.domains.ContactPerson;
import com.cowrycode.mhealth.patients_details_microservice.domains.PatientProfile;
import com.cowrycode.mhealth.patients_details_microservice.mappers.PatientProfileMapper;
import com.cowrycode.mhealth.patients_details_microservice.models.PatientProfileDTO;
import com.cowrycode.mhealth.patients_details_microservice.repositories.ContactPersonRepo;
import com.cowrycode.mhealth.patients_details_microservice.repositories.PatientProfileRepo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public PatientProfileDTO getProfile(Long id) {
        try{
            Optional<PatientProfile> optProfile = patientProfileRepo.findById(id);
            if(optProfile.isPresent()){
                return patientMapper.entityToDTO(optProfile.get());
            }else {
                return null;
            }
        }catch (Exception e){
            return null;
        }
    }

    @Override
    public PatientProfileDTO getPrfoileByemail(String patientemail) {
        try{
            PatientProfile optProfile = patientProfileRepo.findPatientProfileByEmailAddress(patientemail);
            if(optProfile != null ){
                return patientMapper.entityToDTO(optProfile);
            }else {
                return null;
            }
        }catch (Exception e){
            return null;
        }
    }

    @Override
    public List<PatientProfileDTO> getProviderPatients(String providerID) {
        try{
            List<PatientProfile> patientProfiles = patientProfileRepo.findPatientProfileByProvidersContainsIgnoreCase(providerID);
            return patientProfiles.stream().map(patientMapper::entityToDTO).collect(Collectors.toList());
        }catch (Exception e){
            return null;
        }
    }

    @Override
    public PatientProfileDTO updateProfile(PatientProfileDTO patientProfileDTO) {
        return null;
    }
}
