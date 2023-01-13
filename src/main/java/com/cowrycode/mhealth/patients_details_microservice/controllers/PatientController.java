package com.cowrycode.mhealth.patients_details_microservice.controllers;

import com.cowrycode.mhealth.patients_details_microservice.models.PatientProfileDTO;
import com.cowrycode.mhealth.patients_details_microservice.services.PatientProfileService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/mhealth/patient-service/v1")
public class PatientController {
    final PatientProfileService patientProfileService;

    public PatientController(PatientProfileService patientProfileService) {
        this.patientProfileService = patientProfileService;
    }

    @PostMapping("/create-profile")
    public ResponseEntity<PatientProfileDTO> createPatient(@RequestBody @Validated PatientProfileDTO patientProfileDTO , HttpServletRequest request){
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
}
