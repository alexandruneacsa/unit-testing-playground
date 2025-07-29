package com.testing.hamcrest;

import com.testing.hamcrest.model.Student;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class HamcrestMatchersObjectTests {

    @Test
    public void testStudentObject() {

        var student = Student.builder().name("Alex").major("CS").gpa(8.66).build();

        assertThat(student, equalTo(new Student("Alex", "CS", 8.66)));
    }

    @Test
    public void testStudentObjectInstanceOf() {

        var student = Student.builder().name("Alex").major("CS").gpa(8.66).build();

        assertThat(student, instanceOf(Student.class));
    }

    @Test
    public void testStudentObjectNotNullValue() {

        var student = Student.builder().name("Alex").major("CS").gpa(8.66).build();

        assertThat(student, notNullValue());
    }

    @Test
    public void testStudentObjectNullValue() {

        String student = null;

        assertThat(student, nullValue());
    }

    @Test
    public void testStudentSameInstance() {

        var student = Student.builder().name("Alex").major("CS").gpa(8.66).build();
        var copy = student;

        assertThat(student, sameInstance(copy));
    }
}
