package com.lyd.domain;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;
import java.util.Arrays;

@Setter@Getter
public class User {
    @NotBlank(message = "性名不能为空")
    private String username;
    @NotNull
    @Max(value = 140,message = "年龄不正确")
    private Integer age;
    private Integer gender;
    private String[] hobby;
    private Pet pet;

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", age=" + age +
                ", gender=" + gender +
                ", hobby=" + Arrays.toString(hobby) +
                ", pet=" + pet +
                '}';
    }
}
