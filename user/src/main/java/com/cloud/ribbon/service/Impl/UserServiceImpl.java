package com.cloud.ribbon.service.Impl;

import com.cloud.ribbon.entity.user;
import com.cloud.ribbon.repository.UserRepository;
import com.cloud.ribbon.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;
    @Override
    public user getUser(Long u_id) {
        return userRepository.findById(u_id).get();
    }

    @Override
    public user getUserByName(user user) {
        user loginUser=userRepository.getUserByName(user.getU_name());
        if(loginUser==null||!user.getU_password().equals(loginUser.getU_password()))
            return null;
        else
            return loginUser;
    }
}
