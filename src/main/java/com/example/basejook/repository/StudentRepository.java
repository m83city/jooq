package com.example.basejook.repository;

import com.example.basejook.service.domain.Student;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor

public class StudentRepository {
    public Student getById (Long id){
        return null;
    }
    public Student create (Student student){
        return null;
    }
    public Student update (Long id, Student student){
        return null;
    }

    public Long delete (Long id){
        return null;
    }
}
