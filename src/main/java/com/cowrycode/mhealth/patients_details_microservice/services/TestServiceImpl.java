package com.cowrycode.mhealth.patients_details_microservice.services;

import com.cowrycode.mhealth.patients_details_microservice.domains.TestEntity;
import com.cowrycode.mhealth.patients_details_microservice.repositories.TestRepo;
import org.springframework.stereotype.Service;

@Service
public class TestServiceImpl implements TestService{

    private final TestRepo testRepo;

    public TestServiceImpl(TestRepo testRepo) {
        this.testRepo = testRepo;
    }

    @Override
    public String test() {
        TestEntity tt = new TestEntity();
        tt.setStatus("ygjhb");
        testRepo.save(tt);
        return "project is alive!";
    }
}
