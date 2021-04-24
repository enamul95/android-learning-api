package com.app.service;

import com.app.entity.RegistrationEntity;
import com.app.responsemodel.RegistratioResponseModel;

import java.util.List;

public interface RegistrationService {
    List<RegistrationEntity> getAll();
    RegistratioResponseModel insert (RegistrationEntity registrationEntity);

}
