package com.example.basejook.service.domain;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Student {
    private Long id;
    private Integer age;
    private Integer course;
    private String lastName;
    private String firstName;
    private String secondName;
}
