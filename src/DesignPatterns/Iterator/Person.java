package DesignPatterns.Iterator;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Person {
    private String firstName;
    private Title title;

    public enum Title {
        STUDENT,
        PROFESSOR;
    }
}
