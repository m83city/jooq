package com.example.basejook.service;

import com.example.basejook.repository.StudentRepository;
import com.example.basejook.service.domain.Student;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class StudentService {
    private final StudentRepository repo;

    public ResponseEntity<Student> getById(Long id) {
        return repo.getById(id).isPresent() ?
                new ResponseEntity<>(repo.getById(id).get(), HttpStatus.OK) :
                new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    public ResponseEntity<Student> create(Student student) {
        return repo.create(student).isPresent()?
                new ResponseEntity<>(repo.create(student).get(), HttpStatus.CREATED):
                new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    public ResponseEntity<Student> update(Long id, Student student) {
        return repo.update(id, student).isPresent()?
                new ResponseEntity<>(repo.update(id, student).get(), HttpStatus.OK):
                new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    public Long delete(Long id) {
        return repo.delete(id);
    }
}
