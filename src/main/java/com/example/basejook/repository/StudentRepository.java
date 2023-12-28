package com.example.basejook.repository;

import com.example.basejook.service.domain.Student;
import lombok.RequiredArgsConstructor;
import org.jooq.DSLContext;
import org.springframework.stereotype.Repository;
import org.jooq.your.base.tables.records.StudentRecord;

import java.util.Optional;
import java.util.Random;

import static org.jooq.your.base.Tables.STUDENT;

@Repository
@RequiredArgsConstructor

public class StudentRepository {
    private final DSLContext dsl;

    public Optional<Student> getById(Long id) {
        return dsl
                .selectFrom(STUDENT)
                .where(STUDENT.ID.eq(id.intValue()))
                .fetchOptionalInto(Student.class);
    }

    public Optional<Student> create(Student student) {
        Random random = new Random();
        return dsl.insertInto(STUDENT,
                        STUDENT.ID,
                        STUDENT.FIRSTNAME,
                        STUDENT.SECONDNAME,
                        STUDENT.AGE,
                        STUDENT.COURSE,
                        STUDENT.LASTNAME
                )
                .values(random.nextInt(),
                        student.getFirstName(),
                        student.getSecondName(),
                        student.getAge(),
                        student.getCourse(),
                        student.getLastName()
                ).returning(STUDENT.ID,
                        STUDENT.AGE,
                        STUDENT.COURSE,
                        STUDENT.FIRSTNAME,
                        STUDENT.SECONDNAME,
                        STUDENT.LASTNAME)
                .fetchOptionalInto(Student.class);
    }

    public Optional<Student> update(Long id, Student student) {
       return  dsl.update(STUDENT)
                .set(STUDENT.FIRSTNAME, student.getFirstName())
                .set(STUDENT.SECONDNAME, student.getSecondName())
                .set(STUDENT.LASTNAME, student.getLastName())
                .set(STUDENT.AGE, student.getAge())
                .set(STUDENT.COURSE, student.getCourse())
                .where(STUDENT.ID.eq(id.intValue()))
                .returning(STUDENT.ID,
                        STUDENT.AGE,
                        STUDENT.COURSE,
                        STUDENT.FIRSTNAME,
                        STUDENT.SECONDNAME,
                        STUDENT.LASTNAME)
                .fetchOptionalInto(Student.class);
    }

    public Long delete(Long id) {
        dsl.deleteFrom(STUDENT).where(STUDENT.ID.eq(id.intValue())).execute();
        return id;
    }
}
