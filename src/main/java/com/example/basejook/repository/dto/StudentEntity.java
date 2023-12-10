package com.example.basejook.repository.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class StudentEntity {
    private Long id;
    private String name;
    private String surname;
}
