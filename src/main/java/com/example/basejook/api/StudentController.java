package com.example.basejook.api;

import com.example.basejook.api.dto.StudentDTO;
import com.example.basejook.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import static com.example.basejook.api.mapper.StudentAPIMapper.*;

@RestController
@RequiredArgsConstructor

public class StudentController {

    private final StudentService service;
    @GetMapping("/student/{id}")
    public StudentDTO getById (@PathVariable Long id){
        return asStudentDTO(service.getById(id)) ;
    }
    @PostMapping("/student")
    public StudentDTO create (@RequestBody StudentDTO student){
        return asStudentDTO(service.create(asStudent(student)));
    }
    @PutMapping("/student/{id}")
    public StudentDTO update (@PathVariable Long id, @RequestBody StudentDTO student){
        return asStudentDTO(service.update(id, asStudent(student)));
    }
    @DeleteMapping("/student/{id}")
    public Long delete (@PathVariable Long id){
        return service.delete(id);
    }
}
