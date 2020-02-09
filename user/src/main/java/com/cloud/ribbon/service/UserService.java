package com.cloud.ribbon.service;

import com.cloud.ribbon.entity.user;


import java.util.Optional;


public interface UserService {

    user getUser(Long u_id);
    user getUserByName(user user);
}
