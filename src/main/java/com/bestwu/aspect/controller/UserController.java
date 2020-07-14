package com.bestwu.aspect.controller;

import com.bestwu.aspect.entity.UserEntity;
import com.bestwu.aspect.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * <br>
 *
 * @author Best Wu
 * @date 2020/7/14 20:20 <br>
 */
@RestController
public class UserController {

    @Autowired
    private IUserService userService;

    @GetMapping("/get")
    public UserEntity getUser(@RequestParam("userId") Integer userId) {
        return userService.getUser(userId);
    }

    @PostMapping("/save")
    public Map<Integer, UserEntity> saveUser(@RequestBody UserEntity userEntity) {
        return userService.saveUser(userEntity);
    }

    @DeleteMapping("/remove")
    public UserEntity removeUser(@RequestParam("userId") Integer userId) {
        return userService.removeUser(userId);
    }
}
