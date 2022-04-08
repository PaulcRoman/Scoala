package ro.school.repository;

import ro.school.model.Student;

import java.net.ConnectException;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class StudentRepo<Lista> extends Connection {

    public void insertInto(Student student){
        String insertInto = "";
        insertInto += "INSERT INTO student";
        insertInto += "(first_name, last_name, email, age, password)";
        insertInto += "VALUES(";
        insertInto += String.format("'%s','%s', '%s', %d, '%s'", student.getFirstName(),student.getLastName(),student.getEmail(),
                student.getAge(),student.getPassword());
        insertInto += ")";
        exacuteStatement(insertInto);
    }

    public void updateAge(String email, int age){
        String update = "";
        update += String.format("UPDATE student SET age = $d", age);
        update += String.format("WHERE email = '%s'", email);
        exacuteStatement(update);
    }

    public void delete(String email){
        String delete = "";
        delete += "DELETE FROM student ";
        delete += String.format("WHERE email = '%s'", email);
        exacuteStatement(delete);
    }

    private ResultSet selectAll(){
        exacuteStatement("SELECT * FROM student");

        try {

            return statement.getResultSet();
        }catch (Exception e){
            System.out.println("Nu sa conectat la schita");
            return null;
        }
    }

    public List<Student> allStudents(){
        ResultSet set = selectAll();

        List<Student> studentList = new ArrayList<>();

        try {

            while (set.next()){
                studentList.add(new Student(set.getInt(1),set.getString(2),set.getString(3),set.getString(4),
                        set.getInt(5),set.getString(6)));
            }

        }catch (Exception e){
            System.out.println("Nu s-a creat lista");
        }
        return studentList;
    }

}
