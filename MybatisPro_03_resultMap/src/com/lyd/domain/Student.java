package com.lyd.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@Setter@Getter@ToString
public class Student {
    private Integer stu_id;
    private String stu_name;
    private List<Teacher> teachers = new ArrayList<>();
}
