package com.cowrycode.mhealth.authentication_microservice.services;

import javax.servlet.http.HttpServletRequest;

public interface AuthService {
    String getIdentifier(HttpServletRequest request);
}
