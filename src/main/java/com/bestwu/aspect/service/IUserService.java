package com.bestwu.aspect.service;

import com.bestwu.aspect.entity.UserEntity;

import java.util.Map;

/**
 * <br>
 *
 * @author Best Wu
 * @date 2020/7/14 20:20 <br>
 */
public interface IUserService {

    UserEntity getUser(Integer userId);

    Map<Integer, UserEntity> saveUser(UserEntity userEntity);

    UserEntity removeUser(Integer userId);



}
