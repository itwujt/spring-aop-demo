package com.bestwu.aspect.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * <br>
 *
 * @author Best Wu
 * @date 2020/7/14 20:07 <br>
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserEntity implements Serializable {
    private static final long serialVersionUID = -8882446472072635514L;

    private Integer userId;

    private String username;

    private String password;
}
