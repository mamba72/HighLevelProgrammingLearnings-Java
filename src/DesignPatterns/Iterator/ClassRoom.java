package DesignPatterns.Iterator;

import lombok.AllArgsConstructor;

import java.util.Iterator;
import java.util.List;

public class ClassRoom implements Iterator<Person> {

    private List<Person> students;
    private Person professor;

    private IterationState state;


    @Override
    public boolean hasNext() {
        return !state.hasIteratedOverProfessor || state.currentStudent < students.size();
    }

    @Override
    public Person next() {
        Person nextPerson = null;
        if (!state.hasIteratedOverProfessor) {
            nextPerson = professor;
        } else {
            // get current student and then increment the current student index;
            nextPerson = students.get(state.currentStudent++);
        }
        return nextPerson;
    }

    public void addStudent(Person newStudent) {
        students.add(newStudent);
    }


    @AllArgsConstructor
    private class IterationState {
        public int currentStudent;
        public boolean hasIteratedOverProfessor;
    }
}
