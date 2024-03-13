package DesignPatterns.Iterator;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class ClassRoom {

    private final List<Person> students;
    private Person professor;

    public ClassRoom() {
        this.students = new ArrayList<>();
    }

    public ClassRoomIterator iterator() {
        return new ClassRoomIterator(this);
    }

    public void addStudent(Person newStudent) {
        students.add(newStudent);
    }

    public void assignProfessor(Person newProfessor) {
        this.professor = newProfessor;
    }
}
