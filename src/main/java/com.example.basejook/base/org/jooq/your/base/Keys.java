/*
 * This file is generated by jOOQ.
 */
package org.jooq.your.base;


import org.jooq.TableField;
import org.jooq.UniqueKey;
import org.jooq.impl.DSL;
import org.jooq.impl.Internal;
import org.jooq.your.base.tables.Student;
import org.jooq.your.base.tables.records.StudentRecord;


/**
 * A class modelling foreign key relationships and constraints of tables in
 * public.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Keys {

    // -------------------------------------------------------------------------
    // UNIQUE and PRIMARY KEY definitions
    // -------------------------------------------------------------------------

    public static final UniqueKey<StudentRecord> STUDENT_PKEY = Internal.createUniqueKey(Student.STUDENT, DSL.name("student_pkey"), new TableField[] { Student.STUDENT.ID }, true);
}