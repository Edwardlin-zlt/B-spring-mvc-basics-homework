package com.thoughtworks.capacity.gtb.mvc.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    private Integer id;
    @NotNull(message = "用户名不为空")
    @Pattern(message = "用户名不合法", regexp = "^[\\w-]{3,10}$")
    private String username;
    @NotNull(message = "密码不为空")
    @Size(min = 5, max = 12, message = "密码不合法")
    private String password;
    @Pattern(message = "邮箱地址不合法", regexp = "^[\\w-.]+@([\\w-]+\\.)+[\\w-]{2,4}$")
    private String email;
}
