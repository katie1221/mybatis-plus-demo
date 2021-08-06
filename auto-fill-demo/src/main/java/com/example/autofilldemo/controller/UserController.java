package com.example.autofilldemo.controller;

import com.example.autofilldemo.dao.UserMapper;
import com.example.autofilldemo.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.HashMap;
import java.util.Map;

/**
 * @author qzz
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserMapper userMapper;

    /**
     * 添加用户信息
     */
    @PostMapping("add")
    public Map<String,Object> addProduct(@RequestBody User user){
        Map<String,Object> result = new HashMap<>();
        int n = userMapper.insert(user);
        if(n>0){
            result.put("code","200");
            result.put("id",user.getId());
        }else{
            result.put("code","400");
            result.put("msg","添加用户失败");
        }
        return result;
    }

    /**
     * 编辑商品信息
     */
    @PostMapping("update")
    public Map<String,Object> updateProduct(@RequestBody User user){
        Map<String,Object> result = new HashMap<>();
        int n = userMapper.updateById(user);
        if(n>0){
            result.put("code","200");
        }else{
            result.put("code","400");
            result.put("msg","编辑用户失败");
        }
        return result;
    }
}
