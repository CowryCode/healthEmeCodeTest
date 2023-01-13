package com.cowrycode.mhealth.provider_details_microservice.controllers;

import com.cowrycode.mhealth.provider_details_microservice.models.ProviderProfileDTO;
import com.cowrycode.mhealth.provider_details_microservice.services.ProviderProfileService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping("/mhealth/provider-service/v1")
public class ProviderProfileController {
    final ProviderProfileService providerProfileService;

    public ProviderProfileController(ProviderProfileService providerProfileService) {
        this.providerProfileService = providerProfileService;
    }

    @PostMapping("/create-profile")
    public ResponseEntity<ProviderProfileDTO> createProvider(@RequestBody @Validated ProviderProfileDTO providerProfileDTO , HttpServletRequest request){
        //TODO: AUTHENTICATE VIA LOGIN SERVICE LOGIN
        try{
            ProviderProfileDTO profileDTO = providerProfileService.createProviderProfile(providerProfileDTO);
            if(profileDTO != null){
                return new ResponseEntity<>(profileDTO, HttpStatus.OK);
            }else {
                return new ResponseEntity<>(null, HttpStatus.NOT_IMPLEMENTED);
            }
        }catch (Exception e){
            return new ResponseEntity<>(null, HttpStatus.NOT_IMPLEMENTED);
        }
    }

    @GetMapping("/get-profile")
    public ResponseEntity<ProviderProfileDTO> getProvider(HttpServletRequest request){
        //TODO: GET ID FROM LOGIN
        try{
            ProviderProfileDTO profileDTO = providerProfileService.getProviderProfile(4L);
            if(profileDTO != null){
                return new ResponseEntity<>(profileDTO, HttpStatus.OK);
            }else {
                return new ResponseEntity<>(null, HttpStatus.NOT_IMPLEMENTED);
            }
        }catch (Exception e){
            return new ResponseEntity<>(null, HttpStatus.NOT_IMPLEMENTED);
        }
    }

    @GetMapping("/get-patient-providers")
    public ResponseEntity<List<ProviderProfileDTO>> getPatientProviders(HttpServletRequest request){
        //TODO: GET ID FROM LOGIN
        try{
            List<ProviderProfileDTO> profiles = providerProfileService.getPatientProviders("4");
            if(profiles != null ){
                return new ResponseEntity<>(profiles, HttpStatus.OK);
            }else {
                return new ResponseEntity<>(null, HttpStatus.NOT_IMPLEMENTED);
            }
        }catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity<>(null, HttpStatus.NOT_IMPLEMENTED);
        }
    }

    @GetMapping("/get-product-providers")
    public ResponseEntity<List<ProviderProfileDTO>> getProductProviders(HttpServletRequest request){
        //TODO: GET ID FROM LOGIN
        try{
            List<ProviderProfileDTO> profiles = providerProfileService.getServiceProviders("4");
            if(profiles != null ){
                return new ResponseEntity<>(profiles, HttpStatus.OK);
            }else {
                return new ResponseEntity<>(null, HttpStatus.NOT_IMPLEMENTED);
            }
        }catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity<>(null, HttpStatus.NOT_IMPLEMENTED);
        }
    }

}