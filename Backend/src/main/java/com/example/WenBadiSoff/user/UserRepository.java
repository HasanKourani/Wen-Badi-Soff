package com.example.WenBadiSoff.user;

import com.example.WenBadiSoff.user.model.CustomUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<CustomUser, String> {
    Optional<CustomUser> findByEmail(String email);
    Optional<CustomUser> findByUsername(String username);
    Optional<CustomUser> findByPhoneNumber(String phoneNumber);
    Optional<CustomUser> findByCarPlate(String carPlate);
}
