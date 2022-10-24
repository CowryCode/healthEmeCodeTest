package com.cowrycode.mhealth.patients_details_microservice.repositories;

import com.cowrycode.mhealth.patients_details_microservice.domains.TestEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TestRepo extends JpaRepository<TestEntity, Long> {
}
