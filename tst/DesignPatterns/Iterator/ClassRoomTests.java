package DesignPatterns.Iterator;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@Slf4j
public class ClassRoomTests {

    private List<Person> people;
    private ClassRoom classRoom;

    @BeforeEach
    public void setup() {
        people = List.of(new Person("Rene", Person.Title.PROFESSOR),
                new Person("Stephen", Person.Title.STUDENT),
                new Person("Joely", Person.Title.STUDENT));

        this.classRoom = new ClassRoom();

        classRoom.assignProfessor(people.getFirst());
        for (int i = 1; i < people.size(); i++) {
            classRoom.addStudent(people.get(i));
        }
    }


    @Test
    public void testWhenIterating_expectEveryStudentToBeSeen() {
        int totalPeople = classRoom.getStudents().size() + 1;
        int currentCount = 0;
        List<String> namesSeen = new ArrayList<>();

        ClassRoomIterator iterator = classRoom.iterator();
        while(iterator.hasNext()) {
            Person person = iterator.next();
            namesSeen.add(person.getFirstName());
            currentCount++;
        }

        assertEquals(totalPeople, currentCount);
        assertEquals(people.stream().map(Person::getFirstName).toList(), namesSeen);
    }

    @Test
    public void testWhenGivenNoPeople_expectNoIterations() {
        ClassRoom emptyClass = new ClassRoom();
        int currentCount = 0;
        int totalPeople = 0;

        ClassRoomIterator iterator = emptyClass.iterator();
        while(iterator.hasNext()) {
            Person person = iterator.next();
            log.info(person.getFirstName());
            currentCount++;
        }

        assertEquals(totalPeople, currentCount);

    }

}
