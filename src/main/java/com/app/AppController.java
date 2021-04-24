package com.app;

import com.app.entity.RegistrationEntity;
import com.app.responsemodel.RegistratioResponseModel;
import com.app.service.RegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

import static org.springframework.http.MediaType.APPLICATION_JSON_UTF8_VALUE;

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

    @PostMapping(
            path = "/save-user",
            consumes = {MediaType.APPLICATION_FORM_URLENCODED_VALUE})
    public RegistratioResponseModel doSave(
            @RequestParam("fullname") String fullname,
            @RequestParam("email") String email,
            @RequestParam("phone") String phone,
            @RequestParam("password") String password
    ){

      RegistrationEntity registrationEntity = new RegistrationEntity();
        registrationEntity.setFullname(fullname);
        registrationEntity.setEmail(email);
        registrationEntity.setPhone(phone);
        registrationEntity.setPassword(password);
       return registrationService.insert(registrationEntity);
    }

}
