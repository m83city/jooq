package com.example.basejook.repository.mapper;

import com.example.basejook.repository.dto.StudentEntity;
import com.example.basejook.service.domain.Student;

public class StudentRepoMapper {
    public static StudentEntity asStudentEntity (Student student){
        return StudentEntity
                .builder()
                .id(student.getId())
                .name(student.getName())
                .surname(student.getSurname())
                .build();
    }
    public  static Student asStudent (StudentEntity student) {
        return Student
                .builder()
                .id(student.getId())
                .name(student.getName())
                .surname(student.getSurname())
                .build();
    }
}
