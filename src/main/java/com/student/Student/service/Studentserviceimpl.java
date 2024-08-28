package com.student.Student.service;

import com.student.Student.entity.Address;
import com.student.Student.entity.StudentEntity;
import com.student.Student.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class Studentserviceimpl implements StudentService{

    private final StudentRepository studentRepository;
    @Autowired
    public Studentserviceimpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public List<StudentEntity> findAllStudent() {
        return studentRepository.findAll();
    }

    @Override
    public StudentEntity findById(Integer id) {
        return studentRepository.findById(id).get();
    }




    @Override
    public StudentEntity saveStudent(StudentEntity studentEntity) {
        for(Address address : studentEntity.getAddresses()){
            address.setStudent(studentEntity);
        }
        return studentRepository.save(studentEntity);
    }

    @Override
    public StudentEntity updatestudent(StudentEntity studentEntity,Integer id) {
        StudentEntity existingStudent = findById(id);
        if (existingStudent!=null) {
            StudentEntity student = existingStudent;
            student.setStudentname(studentEntity.getStudentname());
            student.getAddresses().clear();
            student.getAddresses().addAll(studentEntity.getAddresses());
            for (Address address : student.getAddresses()) {
                address.setStudent(student);
            }
            return studentRepository.save(student);
        } else {
            throw new RuntimeException("Student not found with id " + id);


    }}

    @Override
    public void deletestudent(Integer id) {
        studentRepository.deleteById(id);
    }


}
