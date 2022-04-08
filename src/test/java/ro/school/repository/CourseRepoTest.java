package ro.school.repository;

import org.junit.jupiter.api.Test;
import ro.school.model.Book;
import ro.school.model.Course;

import static org.junit.jupiter.api.Assertions.*;

class CourseRepoTest {

    @Test
    public void testInsert(){
        Course course = new Course("test","test1");
        CourseRepo courseRepo = new CourseRepo();

        courseRepo.insertCourse(course);
    }

    @Test
    public void testSelectAll(){
        CourseRepo courseRepo = new CourseRepo();

        courseRepo.updateName(1,"Computer Science");

//        courseRepo.delete(4);

        System.out.println(courseRepo.allCourse());


    }

}