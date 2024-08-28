package com.student.Student.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "studentdetails")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class StudentEntity {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "student_id")
    private Integer id;
    @Column(name="student_name")
    private String studentname;

    @OneToMany(mappedBy = "student", cascade = CascadeType.ALL,orphanRemoval = false)
    private List<Address> addresses = new ArrayList<>();




}
