package com.cowrycode.mhealth.Contact.repositories;

import com.cowrycode.mhealth.Contact.domains.ContactEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContactRepo extends JpaRepository<ContactEntity, Long> {

}
