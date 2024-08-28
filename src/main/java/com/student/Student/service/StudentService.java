package com.student.Student.service;

import com.student.Student.entity.StudentEntity;

import java.util.List;
import java.util.Optional;

public interface StudentService {
    List<StudentEntity> findAllStudent();
    StudentEntity findById(Integer id);

    StudentEntity saveStudent(StudentEntity studentEntity);
    StudentEntity updatestudent(StudentEntity studentEntity,Integer id);
    void  deletestudent(Integer id);
}
