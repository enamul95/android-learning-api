package com.app.repository;

import com.app.entity.RegistrationEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RegistrationRepo extends JpaRepository<RegistrationEntity,Long> {

}
