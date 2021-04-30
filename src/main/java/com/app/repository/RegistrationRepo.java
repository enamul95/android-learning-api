package com.app.repository;

import com.app.entity.RegistrationEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface RegistrationRepo extends JpaRepository<RegistrationEntity,Long> {

    @Query("FROM RegistrationEntity where phone=?1 and  password =?2")
    public RegistrationEntity getUser(String phone,String password);

    @Query("FROM RegistrationEntity where phone=?1")
    public RegistrationEntity getUserByPhone(String phone);

}
