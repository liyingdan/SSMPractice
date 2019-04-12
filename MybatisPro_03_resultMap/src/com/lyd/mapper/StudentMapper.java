package com.lyd.mapper;

import com.lyd.domain.Student;

import java.util.List;

public interface StudentMapper {
    /*根据老师的id查询学生*/
    public List<Student> getStudentByTea(Integer id);

    /*添加学生*/
    public void insertStudent(Student student);
}
