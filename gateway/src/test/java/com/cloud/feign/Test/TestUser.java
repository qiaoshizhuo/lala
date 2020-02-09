package com.cloud.feign.Test;

import com.cloud.feign.service.UserService;
import org.junit.Assert;
import org.junit.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class TestUser {
    @Test
    public void getUser()
    {
        long u_id=1l;
        UserService userService = mock(UserService.class);
        when(userService.getUser(u_id)).thenReturn("user");
        String user=userService.getUser(u_id);
        Assert.assertSame(user,"user");

    }
    @Test
    public void getUserByName()
    {
        String u_name="tiger";
        String u_password="password";
        UserService userService = mock(UserService.class);
        when(userService.getUserByName(u_name,u_password)).thenReturn("tiger");
        String tiger=userService.getUserByName(u_name,u_password);
        Assert.assertSame(tiger,"tiger");
    }
}
