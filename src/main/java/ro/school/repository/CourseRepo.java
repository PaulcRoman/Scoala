package ro.school.repository;

import ro.school.model.Course;

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

    public void updateName(int id, String courseName){
        String update ="";
        update += String.format("UPDATE course SET name = '%s'", courseName);
        update += String.format("where id = %d", id);
        exacuteStatement(update);
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

}
