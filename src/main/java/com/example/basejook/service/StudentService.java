package com.example.basejook.service;

import com.example.basejook.repository.StudentRepository;
import com.example.basejook.service.domain.Student;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class StudentService {
    private final StudentRepository repo;

    public Student getById (Long id){
        return repo.getById(id);
    }
    public Student create (Student student){
        return repo.create(student);
    }
    public Student update (Long id, Student student){
        return repo.update(id, student);
    }
    public Long delete (Long id){
        return repo.delete(id);
    }
}
