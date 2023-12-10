package com.example.basejook.api.mapper;

import com.example.basejook.api.dto.StudentDTO;
import com.example.basejook.service.domain.Student;

public class StudentAPIMapper {
    public static StudentDTO asStudentDTO (Student student){
        return StudentDTO
                .builder()
                .id(student.getId())
                .name(student.getName())
                .surname(student.getSurname())
                .build();
    }
    public  static Student asStudent (StudentDTO student) {
        return Student
                .builder()
                .id(student.getId())
                .name(student.getName())
                .surname(student.getSurname())
                .build();
    }
}
