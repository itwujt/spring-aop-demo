package com.bestwu.aspect.aspect;

import com.bestwu.aspect.entity.UserEntity;
import com.bestwu.aspect.repository.UserRepository;
import org.apache.commons.codec.binary.Base64;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.nio.charset.StandardCharsets;

/**
 * <br>
 *
 * @author Best Wu
 * @date 2020/7/14 20:23 <br>
 */
@Component
@Aspect
public class EncryptAspect {
    @Pointcut("execution(* com.bestwu.aspect.service.impl.UserServiceImpl.saveUser(..)) && @annotation(com.bestwu.aspect.annotation.Encrypt)")
    public void encrypt(){}

    @Around("encrypt()")
    public Object advice(ProceedingJoinPoint joinPoint) {
        Object[] args = joinPoint.getArgs();
        UserEntity user = (UserEntity) args[0];
        user.setPassword(Base64.encodeBase64URLSafeString(user.getPassword().getBytes(StandardCharsets.UTF_8)));
        try {
            return joinPoint.proceed(args);
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        return null;
    }
}
