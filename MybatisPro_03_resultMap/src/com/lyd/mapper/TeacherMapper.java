package com.lyd.mapper;

import com.lyd.domain.Teacher;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TeacherMapper {
    /*查询老师 并且把关联的学生查出来*/
    public List<Teacher> getAllTeachers();

    /*查询指定的老师*/
    public Teacher getTeacherWithId(Integer id);

    /*添加老师*/
    public void insertTeacher(Teacher teacher);

    /*插入关系表*/
    public void insertRelation(@Param("stuId") Integer stuId, @Param("teacherId") Integer teacherId);
}
