package ro.school.repository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ro.school.model.Student;

import static org.junit.jupiter.api.Assertions.*;

class StudentRepoTest {

    Student student;
    StudentRepo studentRepo;

    @BeforeEach
    public void initial(){
        studentRepo = new StudentRepo();
    }

    @Test
    public void testInsert(){
        Student student = new Student("test2","test1","test@email.com",25,"parola1");

        studentRepo.insertInto(student);

        assertEquals("test2", student.getFirstName());
    }

    @Test
    public void testUpdateAge(){

        studentRepo.updateAge("sstocky0@irs.gov",23);
        assertEquals(23,studentRepo.updateAge("sstocky0@irs.gov",23));

    }

    @Test
    public void testDelete(){


        studentRepo.delete("test@email.com");

//        assertEquals(true, studentRepo.delete("test@email.com"));
        assertNull(studentRepo.studByEmail("test@email.com"));
    }

    @Test
    public void testSelectAll(){

        assertEquals(true,studentRepo.allStudents().size()>0);

    }

    @Test
    public void testAllEnrolments(){
//        StudentRepo studentRepo = new StudentRepo();
//        System.out.println(studentRepo.allEnrolments(1));

        assertEquals(true,studentRepo.allEnrolments(1).size()>0);


    }

}