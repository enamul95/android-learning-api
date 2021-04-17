package com.app;

import com.app.entity.RegistrationEntity;
import com.app.service.RegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/app-api")
public class AppController {

    @Autowired
    private RegistrationService registrationService;

    @GetMapping("/getAllData")
    @ResponseBody
    List<RegistrationEntity> getData(){
        return registrationService.getAll();
    }

}
