package ro.school.repository;

import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ro.school.model.Course;

import static org.junit.jupiter.api.Assertions.*;

class CourseRepoTest {
    Course course;
    CourseRepo courseRepo;

    @BeforeEach
    public void initiere(){
        courseRepo=new CourseRepo();
    }

    @Test
    public void testInsert(){
         course = new Course("test2","test3");

        courseRepo.insertCourse(course);

        assertEquals("test2", course.getName());
        assertEquals("test3",course.getDepartment());
    }

    @Test
    public void testDelete(){

        System.out.println(courseRepo.allCourse());
    courseRepo.delete(8);

        assertNull(courseRepo.courseById(8));

    }

    @Test
    public void testUpdateName(){

        courseRepo.updateName(6,"Computer");

        assertEquals("Computer", courseRepo.updateName(6,"Computer"));

        System.out.println(courseRepo.allCourse());

    }

    @Test
    public void testSelectAll(){

        assertEquals(true,courseRepo.allCourse().size()>0);

    }

    @Test
    public void testLocate(){

        assertEquals(1,courseRepo.courseById(1).getId());

    }

    @Test
    public void returnCourseName(){
        assertEquals("Engleza", courseRepo.returnCursName(2,"Engleza"));
    }

    @Test
    public void testCursById(){

        assertEquals("Computer science", courseRepo.courseById(1).getName());
        assertEquals(1, courseRepo.courseById(1).getId());
        assertEquals("INFO", courseRepo.courseById(1).getDepartment());
    }

}