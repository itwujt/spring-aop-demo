package com.bestwu.aspect.service.impl;

import com.bestwu.aspect.annotation.Decrypt;
import com.bestwu.aspect.annotation.Encrypt;
import com.bestwu.aspect.entity.UserEntity;
import com.bestwu.aspect.repository.UserRepository;
import com.bestwu.aspect.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * <br>
 *
 * @author Best Wu
 * @date 2020/7/14 20:20 <br>
 */
@Service
public class UserServiceImpl implements IUserService {

    @Decrypt
    @Override
    public UserEntity getUser(Integer userId) {
        return UserRepository.getUser(userId);
    }

    @Encrypt
    @Override
    public Map<Integer, UserEntity> saveUser(UserEntity userEntity) {
        return UserRepository.saveUser(userEntity);
    }

    @Override
    public UserEntity removeUser(Integer userId) {
        return UserRepository.removeUser(userId);
    }
}
