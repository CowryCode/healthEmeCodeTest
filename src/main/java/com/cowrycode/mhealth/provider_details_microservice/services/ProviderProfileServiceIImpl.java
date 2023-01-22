package com.cowrycode.mhealth.provider_details_microservice.services;

import com.cowrycode.mhealth.provider_details_microservice.domains.ProviderProfileEntity;
import com.cowrycode.mhealth.provider_details_microservice.mappers.ProviderProfileMapper;
import com.cowrycode.mhealth.provider_details_microservice.models.ProviderProfileDTO;
import com.cowrycode.mhealth.provider_details_microservice.repositories.ProviderProfileRepo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProviderProfileServiceIImpl implements ProviderProfileService {
    private final ProviderProfileRepo profileRepo;
    private final ProviderProfileMapper providerProfileMapper = ProviderProfileMapper.INSTANCE;

    public ProviderProfileServiceIImpl(ProviderProfileRepo profileRepo) {
        this.profileRepo = profileRepo;
    }

    @Override
    public ProviderProfileDTO createProviderProfile(ProviderProfileDTO providerProfileDTO) {
        try{
            ProviderProfileEntity saved = profileRepo.save(providerProfileMapper.DTOtoEntity(providerProfileDTO));
            return providerProfileMapper.entitiToDTO(saved);
        }catch (Exception e){
            return null;
        }
    }

    @Override
    public ProviderProfileDTO getProfileByEmail(String email) {
        try{
            ProviderProfileEntity profile = profileRepo.findProviderProfileEntityByEmailAddress(email);
            return providerProfileMapper.entitiToDTO(profile);
        }catch (Exception e){
            return null;
        }
    }

    @Override
    public ProviderProfileDTO getProviderProfile(Long providerID) {
        try{
            Optional<ProviderProfileEntity> optProfile = profileRepo.findById(providerID);
            return optProfile.map(providerProfileMapper::entitiToDTO).orElse(null);
        }catch (Exception e){
            return null;
        }
    }

    @Override
    public List<ProviderProfileDTO> getPatientProviders(String patientID) {
        try{
            List<ProviderProfileEntity> profiles = profileRepo.findProviderProfileEntitiesByPatientsContainingIgnoreCase(patientID);
            return profiles.stream().map(providerProfileMapper::entitiToDTO).collect(Collectors.toList());
        }catch (Exception e){
            return null;
        }
    }

    @Override
    public List<ProviderProfileDTO> getServiceProviders(String providerID) {
        try{
            List<ProviderProfileEntity> profiles = profileRepo.findProviderProfileEntitiesByServicesContainingIgnoreCase(providerID);
            return profiles.stream().map(providerProfileMapper::entitiToDTO).collect(Collectors.toList());
        }catch (Exception e){
            return null;
        }
    }
}
