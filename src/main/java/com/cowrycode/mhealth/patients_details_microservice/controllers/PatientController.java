package com.cowrycode.mhealth.patients_details_microservice.controllers;

import com.cowrycode.mhealth.patients_details_microservice.models.PatientProfileDTO;
import com.cowrycode.mhealth.patients_details_microservice.services.PatientProfileService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping("/mhealth/patient-service/v1")
public class PatientController {
    final PatientProfileService patientProfileService;

    public PatientController(PatientProfileService patientProfileService) {
        this.patientProfileService = patientProfileService;
    }

    @PostMapping("/create-profile")
    public ResponseEntity<PatientProfileDTO> createPatient(@RequestBody @Validated PatientProfileDTO patientProfileDTO , HttpServletRequest request){
        //TODO: AUTHENTICATE VIA LOGIN SERVICE LOGIN
        try{
            PatientProfileDTO profileDTO = patientProfileService.createProfile(patientProfileDTO);
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
    public ResponseEntity<PatientProfileDTO> getPatient(HttpServletRequest request){
        //TODO: GET ID FROM LOGIN
        try{
            PatientProfileDTO profileDTO = patientProfileService.getProfile(4L);
            if(profileDTO != null){
                return new ResponseEntity<>(profileDTO, HttpStatus.OK);
            }else {
                return new ResponseEntity<>(null, HttpStatus.NOT_IMPLEMENTED);
            }
        }catch (Exception e){
            return new ResponseEntity<>(null, HttpStatus.NOT_IMPLEMENTED);
        }
    }

    @GetMapping("/get-provider-patients")
    public ResponseEntity<List<PatientProfileDTO>> getProviderPatient(HttpServletRequest request){
        //TODO: GET ID FROM LOGIN
        try{
            List<PatientProfileDTO> profiles = patientProfileService.getProviderPatients("4");
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
