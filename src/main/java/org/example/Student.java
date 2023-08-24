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

        char upperCaseGrade = Character.toUpperCase(grade);

        if ((name == null) || (name.length() == 0))
            throw new InvalidObjectException("name cannot be an empty or null String");

        if ((upperCaseGrade < HIGHEST_GRADE) || (upperCaseGrade > LOWEST_GRADE))
            throw new InvalidObjectException( "grade must be between 'A' and 'F'");

        if ((group < GROUP_LOW) || (group > GROUP_HIGH))
            throw new InvalidObjectException( "group must be between 1 and 6");

        this.group = group;
        this.name = name;
        this.grade = upperCaseGrade;
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
