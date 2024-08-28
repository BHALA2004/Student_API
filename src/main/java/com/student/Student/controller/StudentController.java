package com.student.Student.controller;

import com.student.Student.entity.StudentEntity;
import com.student.Student.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/student")
public class StudentController {
    private final StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping
    public List<StudentEntity> findAllStudent(){
        return studentService.findAllStudent();
    }
    @GetMapping("/{id}")
    public StudentEntity findById(@PathVariable("id") Integer id){
        return studentService.findById(id);
    }


//    @PostMapping
//    public StudentEntity saveStudent(@RequestBody StudentEntity studentEntity){
//        return studentService.saveStudent(studentEntity);
//    }

    @PostMapping
    public StudentEntity studentWithAddress(@RequestBody StudentEntity studentEntity){

        return studentService.saveStudent(studentEntity);
    }
    @PutMapping("/put/{id}")
    public StudentEntity updatestudent(@RequestBody StudentEntity studentEntity,@PathVariable("id") Integer id){
        return studentService.updatestudent(studentEntity,id);
    }

    @DeleteMapping("{id}")
    public void deleteStudent(@PathVariable("id") Integer id){
        studentService.deletestudent(id);
    }



}
