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
 * @date 2020/7/14 20:29 <br>
 */
@Component
@Aspect
public class DecryptAspect {
    @Pointcut("execution(* com.bestwu.aspect.service.impl.UserServiceImpl.getUser(..)) && @annotation(com.bestwu.aspect.annotation.Decrypt)")
    public void decrypt(){}

    @Around("decrypt()")
    public Object advice(ProceedingJoinPoint joinPoint) {
        Object[] args = joinPoint.getArgs();
        UserEntity user = UserRepository.getUser((Integer) args[0]);
        user.setPassword(new String(Base64.decodeBase64(user.getPassword()), StandardCharsets.UTF_8));
        try {
            return joinPoint.proceed(args);
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        return null;
    }

}
