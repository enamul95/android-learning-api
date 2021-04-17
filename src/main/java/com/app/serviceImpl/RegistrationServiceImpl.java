package com.app.serviceImpl;

import com.app.entity.RegistrationEntity;
import com.app.repository.RegistrationRepo;
import com.app.service.RegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RegistrationServiceImpl  implements RegistrationService {

    @Autowired
    private RegistrationRepo registrationRepo;

    @Override
    public List<RegistrationEntity> getAll() {
        return registrationRepo.findAll();
    }
}
