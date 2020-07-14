package com.bestwu.aspect.repository;

import com.bestwu.aspect.entity.UserEntity;
import org.apache.commons.codec.binary.Base64;
import org.springframework.stereotype.Repository;

import java.nio.charset.StandardCharsets;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * <br>
 *
 * @author Best Wu
 * @date 2020/7/14 20:08 <br>
 */
@Repository
public class UserRepository {

    private static Map<Integer, UserEntity> userRepo = new ConcurrentHashMap<>(16);


    static {
        userRepo.put(1, UserEntity.builder().userId(1).username("Best Wu").password(Base64.encodeBase64URLSafeString("123456".getBytes(StandardCharsets.UTF_8))).build());
        userRepo.put(2, UserEntity.builder().userId(2).username("Best Wang").password(Base64.encodeBase64URLSafeString("123456".getBytes(StandardCharsets.UTF_8))).build());
        userRepo.put(3, UserEntity.builder().userId(3).username("Best Xu").password(Base64.encodeBase64URLSafeString("123456".getBytes(StandardCharsets.UTF_8))).build());
        userRepo.put(4, UserEntity.builder().userId(4).username("Best Ding").password(Base64.encodeBase64URLSafeString("123456".getBytes(StandardCharsets.UTF_8))).build());
    }


    public static UserEntity getUser(Integer userId){
        return userRepo.get(userId);
    }

    public static Map<Integer, UserEntity> saveUser(UserEntity user) {
        if (!userRepo.isEmpty()) {
            userRepo.forEach((id, userEntity) -> {
                if (user.getUserId().equals(id)) {
                    throw new RuntimeException("用户 id 已存在");
                }
            });
        }
        userRepo.put(user.getUserId(), user);
        return userRepo;
    }

    public static UserEntity removeUser(Integer userId) {
        if (!userRepo.isEmpty() && userRepo.containsKey(userId)) {
            return userRepo.remove(userId);
        }
        throw new RuntimeException("未找到该用户数据");
    }

}
