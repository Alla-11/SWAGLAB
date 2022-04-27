package org.tms.test;

import org.testng.annotations.Test;
import org.tms.model.Student;

public class StudentTest {

    @Test
    public void createTest(){
        Student student = new Student.StudentBuilder("Egor", "Petrov")
                .phone("1222222")
                .age(22)
                .country("RB")
                .city("Minsk")
                .build();

        Student student1 = new Student.StudentBuilder("Ivan","Petrov").build();
        Student student2 = new Student.StudentBuilder("Kiril","Petrov")
                .age(25)
                .build();

    }
}
