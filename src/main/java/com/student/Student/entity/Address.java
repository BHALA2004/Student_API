package com.student.Student.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "addressdetails")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="Address_id")
    private Long id;
    @Column(name="student_street")
    private String street;
    @Column(name="student_city")
    private String city;
    @Column(name="student_state")
    private String state;
    @Column(name="student_nation")
    private String nation;
    @Column(name="student_pincode")
    private Long pincode;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    @JoinColumn(name = "student_id")
    @JsonIgnore
    private StudentEntity student;
}
