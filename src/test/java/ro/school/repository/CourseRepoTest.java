package ro.school.repository;

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
         course = new Course("test","test1");
         courseRepo = new CourseRepo();

        courseRepo.insertCourse(course);

        assertEquals("test", course.getName());
    }

    @Test
    public void testDelete(){

        assertEquals(true,courseRepo.delete(5));

    }

    @Test
    public void testUpdateName(){

        courseRepo.updateName(5,"test");

//        assertEquals("Computer Science", courseRepo.updateName(5,"Computer Science"));

    }

    @Test
    public void testSelectAll(){

//        courseRepo.delete(4);


        assertEquals(true,courseRepo.allCourse().size()>0);

    }

    @Test
    public void testLocate(){

        assertEquals(true,courseRepo.cursuriActive(1).size()>0);

        System.out.println(courseRepo.cursuriActive(2));

    }

}