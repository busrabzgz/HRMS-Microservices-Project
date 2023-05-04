package com.example.userservice.repository;

import org.apache.catalina.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UserRepository extends JpaRepository<User,Long> {
    @Query("SELECT user FROM User user WHERE date_part('month', user.birthOfDate) = date_part('month', CURRENT_DATE)")
    List<User> getEmployeesBirthday();
}
