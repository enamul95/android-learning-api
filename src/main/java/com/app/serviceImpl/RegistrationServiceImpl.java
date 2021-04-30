package com.app.serviceImpl;

import com.app.entity.RegistrationEntity;
import com.app.repository.RegistrationRepo;
import com.app.responsemodel.RegistratioResponseModel;
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

    @Override
    public RegistratioResponseModel insert(RegistrationEntity registrationEntity) {

        RegistrationEntity saveModel = registrationRepo.save(registrationEntity);

        RegistratioResponseModel model = new RegistratioResponseModel();
        if(saveModel !=null){
            if(saveModel.getId()>0){
                model.setOutCode("0");
                model.setOutMessage("User Registration successful");
            }else{
                model.setOutCode("1");
                model.setOutMessage("fail to register user.");
            }
        }else {
            model.setOutCode("1");
            model.setOutMessage("fail to register user.");
        }
        return  model;
    }

    @Override
    public RegistratioResponseModel getUser(String phone, String password) {

        RegistrationEntity user = registrationRepo.getUser(phone, password);
        RegistratioResponseModel ourModel = new RegistratioResponseModel();

        if(user !=null){
            if(!phone.equals(user.getPhone())){
                ourModel.setOutCode("1");
                ourModel.setOutMessage("Phone is invalid");
            }else if(!password.equals(user.getPassword())){
                ourModel.setOutCode("1");
                ourModel.setOutMessage("Password is invalid");
            }else {
                ourModel.setOutCode("0");
                ourModel.setOutMessage("Login Successfull");
            }
        }else{
            ourModel.setOutCode("1");
            ourModel.setOutMessage("Invaid User Id or password");
        }
        return ourModel;
    }

    @Override
    public RegistrationEntity getUserByPhone(String phone) {
        return registrationRepo.getUserByPhone(phone);
    }


}
