package com.example.basejook.api;

import com.example.basejook.api.dto.StudentDTO;
import com.example.basejook.service.StudentService;
import com.example.basejook.service.domain.Student;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import static com.example.basejook.api.mapper.StudentAPIMapper.*;
@RestController
@RequiredArgsConstructor
@RequestMapping("/student")
public class StudentController {

    private final StudentService service;

    @GetMapping("/{id}")
    public ResponseEntity<StudentDTO> getById (@PathVariable Long id){
        return service.getById(id).isPresent() ?
                new ResponseEntity<>(asStudentDTO(service.getById(id).get()), HttpStatus.OK) :
                new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    @PostMapping
    public ResponseEntity<StudentDTO> create (@RequestBody StudentDTO student){
        return service.create(asStudent(student)).isPresent()?
                new ResponseEntity<>(asStudentDTO(service.create(asStudent(student)).get()), HttpStatus.CREATED):
                new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
    @PutMapping("/{id}")
    public ResponseEntity<Student> update (@PathVariable Long id, @RequestBody StudentDTO student){
        return service.update(id, asStudent(student)).isPresent()?
                new ResponseEntity<>(service.update(id, asStudent(student)).get(), HttpStatus.OK):
                new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
    @DeleteMapping("/{id}")
    public Long delete (@PathVariable Long id){
        return service.delete(id);
    }
}