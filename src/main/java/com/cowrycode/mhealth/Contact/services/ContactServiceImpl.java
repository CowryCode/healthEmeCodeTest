package com.cowrycode.mhealth.Contact.services;

import com.cowrycode.mhealth.Contact.domains.ContactEntity;
import com.cowrycode.mhealth.Contact.mappers.ContactMapper;
import com.cowrycode.mhealth.Contact.models.ContactDTO;
import com.cowrycode.mhealth.Contact.repositories.ContactRepo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ContactServiceImpl implements ContactService{

    private final ContactRepo contactRepo;
    private final ContactMapper mapper = ContactMapper.INSTANCE;

    public ContactServiceImpl(ContactRepo contactRepo) {
        this.contactRepo = contactRepo;
    }

    @Override
    public List<ContactDTO> getAllContacts() {
        try {
            return contactRepo.findAll().stream().map(mapper::entityToDTO).collect(Collectors.toList());
        }catch (Exception e){
            return null;
        }
    }

    @Override
    public ContactDTO saveContact(ContactDTO contact) {
       try{
           ContactEntity savedContact = contactRepo.save(mapper.DTOtoEntity(contact));
           return mapper.entityToDTO(savedContact);
       }catch (Exception e){
           return null;
       }
    }

    @Override
    public ContactDTO updateContact(ContactDTO contact) {
        try {
            ContactEntity contEnt = contactRepo.findById(contact.getId()).orElse(null);
            if(contEnt != null){
                contEnt.setFirstName(contact.getFirstName());
                contEnt.setLastName(contact.getLastName());
                contEnt.setEmail(contact.getEmail());
                contEnt.setPhoneNumber(contact.getPhoneNumber());
                contEnt.setImgURL(contact.getImgURL());
                ContactEntity updated = contactRepo.save(contEnt);
                return mapper.entityToDTO(updated);
            }else return null;
        }catch (Exception e){
            return null;
        }
    }

    @Override
    public void deleteContact(Long contactID) {
        contactRepo.deleteById(contactID);
    }
}
