package com.example.basejook.api.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class StudentDTO {
    private Long id;
    private String name;
    private String surname;
}
