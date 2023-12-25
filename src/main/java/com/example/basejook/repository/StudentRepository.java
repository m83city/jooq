package com.example.basejook.repository;

import com.example.basejook.service.domain.Student;
import lombok.RequiredArgsConstructor;
import org.jooq.DSLContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.jooq.your.base.tables.records.StudentRecord;

import static org.jooq.your.base.Tables.STUDENT;

@Repository
@RequiredArgsConstructor

public class StudentRepository {
    private  final DSLContext dsl;

    public Student getById (Long id){
        StudentRecord student = dsl
                .selectFrom(STUDENT)
                .where(STUDENT.ID.eq(id.intValue()))
                .fetchOne();
        return  Student.builder()
                .id(Long.valueOf(student.getId()))
                .name(student.getFirstname())
                .surname(student.getSecondname())
                .build();

    }
    public Student create (Student student){
        return null;
    }
    public Student update (Long id, Student student){
        return null;
    }
    public Long delete (Long id){
        dsl.deleteFrom(STUDENT).where(STUDENT.ID.eq(id.intValue())).execute();
        return id;
    }
}
