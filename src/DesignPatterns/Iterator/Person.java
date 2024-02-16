package DesignPatterns.Iterator;

import lombok.Getter;

@Getter
public class Person {
    private String firstName;
    private Title title;

    public enum Title {
        STUDENT,
        PROFESSOR;
    }
}
