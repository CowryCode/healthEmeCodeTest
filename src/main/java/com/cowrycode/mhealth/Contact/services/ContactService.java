package com.cowrycode.mhealth.Contact.services;

import com.cowrycode.mhealth.Contact.models.ContactDTO;

import java.util.List;

public interface ContactService {
    List<ContactDTO> getAllContacts();
    ContactDTO saveContact(ContactDTO contact);
    ContactDTO updateContact(ContactDTO contact);

    void  deleteContact(Long contactID);

//    void uploadImage(Long contactID, ImageEntity imageEntity);


}
