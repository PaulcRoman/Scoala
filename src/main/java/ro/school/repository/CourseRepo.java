package ro.school.repository;

import ro.school.model.Course;
import ro.school.model.Enrolments;

import javax.swing.*;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class CourseRepo<Lista> extends Connection {

    public void insertCourse(Course course){
        String insertTo = "";
        insertTo += "INSERT INTO course";
        insertTo += "(name, department)";
        insertTo += "VALUES(";
        insertTo += String.format("'%s','%s'", course.getName(),course.getDepartment());
        insertTo += ")";
        exacuteStatement(insertTo);
    }

    public String updateName(int id, String courseName){
        String update ="";
        update += String.format("UPDATE course SET name = '%s'", courseName);
        update += String.format("where id = %d", id);
        exacuteStatement(update);
        return courseName;
    }

    public void delete(int id){

            String delete = "";
            delete += "DELETE FROM course ";
            delete += String.format("WHERE id = %d ", id);
            exacuteStatement(delete);

    }

    private ResultSet selectAll(){
        exacuteStatement("SELECT * FROM course");
        try {
            return statement.getResultSet();
        }catch (Exception e){
            System.out.println("Nu s-a conectat schita");
            return null;
        }
    }

    public List<Course> allCourse(){
        ResultSet set = selectAll();

        List<Course> courseList = new ArrayList<>();

        try {

            while (set.next()){
                courseList.add(new Course(set.getInt(1),set.getString(2),set.getString(3)));
            }
        }catch (Exception e){
            System.out.println("Nu s-a creat lista");
        }
        return courseList;
    }

    public String returnCursName(int id, String cursName){
        String curs = "";
        curs += "SELECT name FROM course ";
        curs += String.format("WHERE id = %d", id);
        exacuteStatement(curs);
        return cursName;
    }

//    private ResultSet join(int courseId){
//
//        String text= "";
//        text += String.format("select course_id from enrolment" +
//                " join student s on enrolment.student_id = s.id " +
//                "where student_id=%d ",courseId );
//        text += "union\n" +
//                "select name from course\n" +
//                "join enrolment e on course.id = e.course_id";
//
//        exacuteStatement(text);
//
//        try {
//
//            return statement.getResultSet();
//        }catch (Exception e){
//            System.out.println("Nu s-a conectat la schita");
//            return null;
//        }
//
//    }

//    public List<Enrolments> allEnrolments(int id){
//
//        ResultSet set = join(id);
//
//        List<Enrolments> enrolmentsList = new ArrayList<>();
//
//        try {
//            while (set.next()){
//                enrolmentsList.add(new Enrolments(set.getInt(2), set.getInt(3),set.getString(4)));
//
//            }
//
//        }catch (Exception e){
//            System.out.println("Nu s-a creat lista");
//        }
//        return enrolmentsList;
//
//    }

//    public List<Enrolments> cursuriActive(int id){
//
//        ResultSet set = join(id);
//
//        List<Enrolments> enrolmentsList = new ArrayList<>();
//
//        try {
//            while (set.next()){
//                enrolmentsList.add(new Enrolments(set.getInt(1)));
//
//            }
//
//        }catch (Exception e){
//            System.out.println("Nu s-a creat lista");
//        }
//        return enrolmentsList;
//
//    }

    private ResultSet findCourseById(int id){
        String curs = "";
        curs += "SELECT * FROM course ";
        curs += String.format("WHERE id = %d", id);
        exacuteStatement(curs);

        try {
            return statement.getResultSet();
        }catch (Exception e){
            System.out.println("Nu s-a conectat la schita");
            return null;
        }
    }

    public Course courseById(int id){

        ResultSet set = findCourseById(id);

        List<Course> courseList = new ArrayList<>();

        try {
            while (set.next()){
                courseList.add(new Course(set.getInt(1),set.getString(2),set.getString(3)));
            }

        }catch (Exception e){
            System.out.println("Lista nu s-a creat");
        }
        return courseList.get(0);
    }

}
