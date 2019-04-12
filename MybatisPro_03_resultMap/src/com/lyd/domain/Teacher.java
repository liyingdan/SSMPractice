package com.lyd.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@Setter@Getter@ToString
public class Teacher {
    private Integer teacher_id;
    private String teacher_name;
    private List<Student> students = new ArrayList<>();
}
