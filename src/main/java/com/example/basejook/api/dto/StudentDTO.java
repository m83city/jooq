package com.example.basejook.api.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class StudentDTO {
    private Long id;
    private Integer age;
    private Integer course;
    private String lastName;
    private String firstName;
    private String secondName;
}