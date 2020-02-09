package com.cloud.feign.service;

import com.cloud.feign.rpc.UserRPC;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserRPC userRPC;
    public String getUser(Long u_id)
    {
        return userRPC.getUser(u_id);
    }
    public String getUserByName(String u_name,String u_password)
    {
        return userRPC.getUserByName(u_name,u_password);
    }
}
