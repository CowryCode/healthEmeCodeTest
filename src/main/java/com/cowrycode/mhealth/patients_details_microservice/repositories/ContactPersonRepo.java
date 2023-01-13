package com.cowrycode.mhealth.patients_details_microservice.repositories;

import com.cowrycode.mhealth.patients_details_microservice.domains.ContactPerson;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContactPersonRepo extends JpaRepository<ContactPerson, Long> {
}
