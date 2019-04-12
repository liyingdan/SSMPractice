package com.lyd.test;

import com.lyd.domain.Student;
import com.lyd.domain.Teacher;
import com.lyd.mapper.StudentMapper;
import com.lyd.mapper.TeacherMapper;
import com.lyd.util.MybatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

public class Mytest2 {
   private SqlSession sqlSession = MybatisUtil.openSession();

    @Test
    public void test(){
        TeacherMapper teacherMapper = sqlSession.getMapper(TeacherMapper.class);
        List<Teacher> allTeachers = teacherMapper.getAllTeachers();
        for (Teacher teacher : allTeachers) {
            System.out.println(teacher);
        }
        sqlSession.close();
    }

    @Test
    public void test2(){
        TeacherMapper teacherMapper = sqlSession.getMapper(TeacherMapper.class);
        Teacher teacher = teacherMapper.getTeacherWithId(2);
        System.out.println(teacher);
        sqlSession.close();
    }

    @Test
    public void test3(){
        TeacherMapper teacherMapper = sqlSession.getMapper(TeacherMapper.class);
        StudentMapper studentMapper = sqlSession.getMapper(StudentMapper.class);

        Student student1 = new Student();
        student1.setStu_name("新学生1");
        Student student2 = new Student();
        student2.setStu_name("新学生2");

        Teacher teacher1 = new Teacher();
        teacher1.setTeacher_name("面面");
        teacher1.getStudents().add(student1);
        teacher1.getStudents().add(student2);
        /*保存老师*/
        teacherMapper.insertTeacher(teacher1);
        /*保存学生*/
        studentMapper.insertStudent(student1);
        studentMapper.insertStudent(student2);
        
        /*插入关系表*/
        for (Student student : teacher1.getStudents()) {
            teacherMapper.insertRelation(student.getStu_id(),teacher1.getTeacher_id());
        }

        sqlSession.commit();
        sqlSession.close();
    }
}
