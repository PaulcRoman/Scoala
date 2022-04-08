package ro.school.repository;

import org.junit.jupiter.api.Test;
import ro.school.model.Student;

import static org.junit.jupiter.api.Assertions.*;

class StudentRepoTest {

    @Test
    public void testInsert(){
        Student student = new Student("test","test2","test@email.com",25,"parola1");
        StudentRepo studentRepo = new StudentRepo();
        studentRepo.insertInto(student);
    }

    @Test
    public void testDelete(){
        StudentRepo studentRepo = new StudentRepo();
        studentRepo.delete("test@email.com");
    }

    @Test
    public void testSelectAll(){
        StudentRepo studentRepo = new StudentRepo();
        System.out.println(studentRepo.allStudents());
    }

}