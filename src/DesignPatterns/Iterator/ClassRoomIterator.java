package DesignPatterns.Iterator;

import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
public class ClassRoomIterator {
    private int currentStudent = 0;
    private boolean hasIteratedOverProfessor = false;
    private List<Person> students;
    private Person professor;

    public ClassRoomIterator(ClassRoom room) {
        students = room.getStudents();
        professor = room.getProfessor();
    }

    public boolean hasNext() {
        return professor != null && (!hasIteratedOverProfessor || currentStudent < students.size());
    }

    public Person next() {
        Person nextPerson;
        if (!hasIteratedOverProfessor) {
            nextPerson = professor;
            hasIteratedOverProfessor = true;
        } else {
            nextPerson = students.get(currentStudent);
            currentStudent++;
        }
        return nextPerson;
    }
}
