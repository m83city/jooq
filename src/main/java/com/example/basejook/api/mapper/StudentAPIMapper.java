package com.example.basejook.api.mapper;

import com.example.basejook.api.dto.StudentDTO;
import com.example.basejook.service.domain.Student;

public class StudentAPIMapper {
    public static StudentDTO asStudentDTO (Student student){
        return StudentDTO
                .builder()
                .id(student.getId())
                .firstName(student.getFirstName())
                .secondName(student.getSecondName())
                .age(student.getAge())
                .course(student.getCourse())
                .lastName(student.getLastName())
                .build();
    }
    public  static Student asStudent (StudentDTO student) {
        return Student
                .builder()
                .id(student.getId())
                .firstName(student.getFirstName())
                .secondName(student.getSecondName())
                .age(student.getAge())
                .course(student.getCourse())
                .lastName(student.getLastName())
                .build();
    }
}
