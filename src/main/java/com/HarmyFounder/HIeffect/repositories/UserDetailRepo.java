package com.HarmyFounder.HIeffect.repositories;

import com.HarmyFounder.HIeffect.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDetailRepo extends JpaRepository<User, String> {



}
