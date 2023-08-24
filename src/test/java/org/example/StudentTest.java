package org.example;

import org.example.Student;
import org.junit.jupiter.api.Test;

import java.io.InvalidObjectException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;


class StudentTest {

    @Test
    void checkGetNameTitleCase() throws InvalidObjectException {

        String name = "John Doe";

        Student student = new Student(name, 'A', 1);
        assertEquals(name, student.getName());
    }

    @Test
    void checkGetNameUpperCase() throws InvalidObjectException {

        String name = "JOHN DOE";

        Student student = new Student(name, 'A', 1);
        assertEquals(name, student.getName());
    }

    @Test
    void checkGradeLowerCase() throws InvalidObjectException {
        char grade = 'a';

        Student student = new Student("john Doe", grade, 1);
        assertEquals(Character.toUpperCase(grade), student.getGrade());
    }



    @Test
    void checkConstructorEmptyString() {

        String name = "";

        Student student = null;
        try {
            student = new Student(name, 'A', 1);
            fail("Test should cause InvalidObjectException");

        } catch (InvalidObjectException e) {
            System.out.println(e.getMessage());
        }
    }


    @Test
    void checkConstructorInvalidGrade() {

        char invalidGrade = 'G';

        Student student = null;
        try {
            student = new Student("John Doe", invalidGrade, 1);
            fail("Test should cause InvalidObjectException");

        } catch (InvalidObjectException e) {
            System.out.println(e.getMessage());
        }
    }

    @Test
    void checkConstructorInvalidGroup() {

        int invalidGroup = 7;

        Student student = null;
        try {
            student = new Student("John Doe", 'A', invalidGroup);
            fail("Test should cause InvalidObjectException");

        } catch (InvalidObjectException e) {
            System.out.println(e.getMessage());
        }
    }


    @Test
    void checkGetGradeLimits() throws InvalidObjectException {
        char validGrade = 'A';

        Student student = null;
        student = new Student("John Doe", validGrade, 1);
        assertEquals(validGrade, student.getGrade());

        validGrade = 'F';
        student = new Student("John Doe", validGrade, 1);
        assertEquals(validGrade, student.getGrade());
    }



    @Test
    void checkUpGrade() throws InvalidObjectException {
        char validGrade = 'F';

        Student student = new Student("John Doe", validGrade, 1);
        assertEquals( student.upGrade(), true);
        assertEquals(student.getGrade(),'E');
        assertEquals( student.upGrade(), true);
        assertEquals(student.getGrade(),'D');
        assertEquals( student.upGrade(), true);
        assertEquals(student.getGrade(),'C');
        assertEquals( student.upGrade(), true);
        assertEquals(student.getGrade(),'B');
        assertEquals( student.upGrade(), true);
        assertEquals(student.getGrade(),'A');
        assertEquals( student.upGrade(), false);
        assertEquals(student.getGrade(),'A');
    }



    @Test
    void checkDownGrade() throws InvalidObjectException {
        char validGrade = 'A';

        Student student = new Student("John Doe", validGrade, 1);
        assertEquals( student.downGrade(), true);
        assertEquals(student.getGrade(),'B');
        assertEquals( student.downGrade(), true);
        assertEquals(student.getGrade(),'C');
        assertEquals( student.downGrade(), true);
        assertEquals(student.getGrade(),'D');
        assertEquals( student.downGrade(), true);
        assertEquals(student.getGrade(),'E');
        assertEquals( student.downGrade(), true);
        assertEquals(student.getGrade(),'F');
        assertEquals( student.downGrade(), false);
        assertEquals(student.getGrade(),'F');
    }


}