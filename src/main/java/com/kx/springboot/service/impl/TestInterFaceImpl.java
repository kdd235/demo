package com.kx.springboot.service.impl;

import com.kx.springboot.bean.User;
import com.kx.springboot.service.TestInterFace;
import org.springframework.stereotype.Service;

//业务层接口实现
@Service
public class TestInterFaceImpl implements TestInterFace {
    @Override public int testInterFace() {
        return 0;
    }

    @Override public User testUser() {
        return new User();
    }
}
