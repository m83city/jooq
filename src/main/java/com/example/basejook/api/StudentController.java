package com.example.basejook.api;

import com.example.basejook.api.dto.StudentDTO;
import com.example.basejook.service.StudentService;
import com.example.basejook.service.domain.Student;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import static com.example.basejook.api.mapper.StudentAPIMapper.*;

@RestController
@RequiredArgsConstructor

public class StudentController {

    private final StudentService service;
    @GetMapping("/student/{id}")
    public ResponseEntity<Student> getById (@PathVariable Long id){
        return service.getById(id);
    }
    @PostMapping("/student")
    public StudentDTO create (@RequestBody StudentDTO student){
        return asStudentDTO(service.create(asStudent(student)).getBody());
    }
    @PutMapping("/student/{id}")
    public ResponseEntity<Student> update (@PathVariable Long id, @RequestBody StudentDTO student){
        return service.update(id, asStudent(student));
    }
    @DeleteMapping("/student/{id}")
    public Long delete (@PathVariable Long id){
        return service.delete(id);
    }
}
