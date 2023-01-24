package com.cowrycode.mhealth.Contact.controllers;

import com.cowrycode.mhealth.Contact.models.ContactDTO;
import com.cowrycode.mhealth.Contact.services.ContactService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/healthEme/api/V1")
public class HomeController {

    private final ContactService contactService;

    public HomeController(ContactService contactService) {
        this.contactService = contactService;
    }

    @GetMapping("/")
    public ResponseEntity<String> start(){
        return new ResponseEntity<>("HealthEme Backend is live !!!", HttpStatus.OK);
    }

    @PostMapping("/save-contact")
    public ResponseEntity<ContactDTO> createPatient(@RequestBody @Validated ContactDTO contact){
        try{
            ContactDTO savedContact = contactService.saveContact(contact);
            if(savedContact != null){
                return new ResponseEntity<>(savedContact, HttpStatus.OK);
            }else {
                return new ResponseEntity<>(null, HttpStatus.NOT_IMPLEMENTED);
            }
        }catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity<>(null, HttpStatus.NOT_IMPLEMENTED);
        }
    }

    @PutMapping("/updatecontact/{id}")
    public ResponseEntity<ContactDTO> updateMyEntity(@PathVariable Long id, @RequestBody ContactDTO contact) {
        try{
            ContactDTO updatedContact = contactService.updateContact(contact);
            if(updatedContact != null){
                return new ResponseEntity<>(updatedContact, HttpStatus.OK);
            }else {
                return new ResponseEntity<>(null, HttpStatus.NOT_IMPLEMENTED);
            }
        }catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity<>(null, HttpStatus.NOT_IMPLEMENTED);
        }
    }

    @GetMapping("/get-contacts")
    public ResponseEntity<List<ContactDTO>> updateMyEntity() {
        try{
            List<ContactDTO> contacts = contactService.getAllContacts();
            if(contacts != null){
                return new ResponseEntity<>(contacts, HttpStatus.OK);
            }else {
                return new ResponseEntity<>(null, HttpStatus.NOT_IMPLEMENTED);
            }
        }catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity<>(null, HttpStatus.NOT_IMPLEMENTED);
        }
    }


    @DeleteMapping("/remove-contact/{id}")
    public ResponseEntity<Void> deleteMyEntity(@PathVariable Long id) {
        contactService.deleteContact(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
