package com.cowrycode.mhealth.provider_services_microservice.contollers;

import com.cowrycode.mhealth.provider_services_microservice.models.HealthCareServiceDTO;
import com.cowrycode.mhealth.provider_services_microservice.services.HealthcareserviceService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping("/mhealth/products-service/v1")
public class HealthcareServiceController {
    private final HealthcareserviceService healthcareserviceService;

    public HealthcareServiceController(HealthcareserviceService healthcareserviceService) {
        this.healthcareserviceService = healthcareserviceService;
    }

    @PostMapping("/create-product")
    public ResponseEntity<HealthCareServiceDTO> createPatient(@RequestBody @Validated HealthCareServiceDTO healthCareServiceDTO , HttpServletRequest request){
        try{
            HealthCareServiceDTO service = healthcareserviceService.createService(healthCareServiceDTO);
            if(service != null){
                return new ResponseEntity<>(service, HttpStatus.OK);
            }else {
                return new ResponseEntity<>(null, HttpStatus.NOT_IMPLEMENTED);
            }
        }catch (Exception e){
            return new ResponseEntity<>(null, HttpStatus.NOT_IMPLEMENTED);
        }
    }

    @GetMapping("/get-provider-services")
    public ResponseEntity<List<HealthCareServiceDTO>> getProviderServices(HttpServletRequest request){
        //TODO: GET ID FROM LOGIN
        try{
            List<HealthCareServiceDTO> services = healthcareserviceService.getProviderSubscribedServices("4");
            if(services != null ){
                return new ResponseEntity<>(services, HttpStatus.OK);
            }else {
                return new ResponseEntity<>(null, HttpStatus.NOT_IMPLEMENTED);
            }
        }catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity<>(null, HttpStatus.NOT_IMPLEMENTED);
        }
    }

    @GetMapping("/get-patient-services")
    public ResponseEntity<List<HealthCareServiceDTO>> getPatientServices(HttpServletRequest request){
        //TODO: GET ID FROM LOGIN
        try{
            List<HealthCareServiceDTO> services = healthcareserviceService.getProviderSubscribedServices("4");
            if(services != null ){
                return new ResponseEntity<>(services, HttpStatus.OK);
            }else {
                return new ResponseEntity<>(null, HttpStatus.NOT_IMPLEMENTED);
            }
        }catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity<>(null, HttpStatus.NOT_IMPLEMENTED);
        }
    }



}
