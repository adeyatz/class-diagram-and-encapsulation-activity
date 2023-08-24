package org.example;

import java.io.InvalidObjectException;

public class Student {
    private String name;
    private char grade;
    private int group;
    private static final String secretNickName = "MySecretNickName";
    private static final char HIGHEST_GRADE = 'A';
    private static final char LOWEST_GRADE = 'F';
    private static final int GROUP_LOW = 1;

    private static final int GROUP_HIGH = 5;

    public Student(String name, char grade, int group ) throws InvalidObjectException {
        this.name = name;
        if (this.name.length() == 0)
            throw new InvalidObjectException("name cannot be an empty String");

        this.grade = Character.toUpperCase(grade);
        if ((this.grade < HIGHEST_GRADE) || (this.grade > LOWEST_GRADE))
            throw new InvalidObjectException( "grade must be between 'A' and 'F'");

        this.group = group;
        if ((this.group < GROUP_LOW) || (this.group > GROUP_HIGH))
            throw new InvalidObjectException( "group must be between 1 and 6");
    }


    public String getName() {
        return name;
    }

    public char getGrade() {
        return grade;
    }


    public boolean upGrade() {
        if (grade == HIGHEST_GRADE)
            return false;
        else {
            grade--;
            return true;
        }
    }

    public boolean downGrade() {
        if (grade == LOWEST_GRADE)
            return false;
        else {
            grade++;
            return true;
        }

    }

}
