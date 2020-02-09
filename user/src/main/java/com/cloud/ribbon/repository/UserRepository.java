package com.cloud.ribbon.repository;

import com.cloud.ribbon.entity.user;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.web.bind.annotation.RequestParam;

public interface UserRepository extends JpaRepository<user,Long> {
    @Query(value = "select * from t_user where u_name=:u_name",nativeQuery = true)
    user getUserByName(@RequestParam("u_name") String u_name);
}
