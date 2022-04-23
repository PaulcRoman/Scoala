package ro.school.repository;

import ro.school.model.Enrolments;
import ro.school.model.Student;

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

    public int updateAge(String email, int age){
        String update = "";
        update += String.format("UPDATE student SET age = %d", age);
        update += String.format(" WHERE email = '%s'", email);
        exacuteStatement(update);
        return age;
    }

    public void delete(String email){

            String delete = "";
            delete += "DELETE FROM student ";
            delete += String.format("WHERE email = '%s'", email);
            exacuteStatement(delete);

    }
    private ResultSet findByEmail(String email){
        String getEmail = "";
        getEmail += "SELECT * FROM student ";
        getEmail += String.format("WHERE email = '%s'", email);
        exacuteStatement(getEmail);

        try {
            return statement.getResultSet();
        }catch (Exception e){
            System.out.println("Nu s-a conectat la schita");
            return null;
        }
    }

    public Student studByEmail(String email){

        ResultSet set = findByEmail(email);

        java.util.List<Student> studentList = new ArrayList<>();

        try {
            while (set.next()){
                studentList.add(new Student(set.getInt(1),set.getString(2),set.getString(3),set.getString(4),
                        set.getInt(5),set.getString(6)));
            }

        }catch (Exception e){
            System.out.println("Lista nu s-a creat");
        }
        return studentList.get(0);
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

    private ResultSet join(int studentId){

        String text= "";
        text += String.format("select  course_id from enrolment" +
                " join student s on enrolment.student_id = s.id " +
                "where student_id=%d ",studentId);

        exacuteStatement(text);

        try {

            return statement.getResultSet();
        }catch (Exception e){
            System.out.println("Nu s-a conectat la schita");
            return null;
        }

    }

    public List<Enrolments> allEnrolments(int id){

        ResultSet set = join(id);

        List<Enrolments> enrolmentsList = new ArrayList<>();

        try {
            while (set.next()){
                enrolmentsList.add(new Enrolments(set.getInt(1)));

            }

        }catch (Exception e){
            System.out.println("Nu s-a creat lista");
        }
        return enrolmentsList;

    }

    public Student login(String email, String parola){

        for (Student s : allStudents()){

            if (s.getEmail().equals(email) && s.getPassword().equals(parola)){
                return s;
            }
        }
        return null;
    }



}
