package ro.school.repository;

import ro.school.model.Enrolments;

import java.sql.ResultSet;
import java.util.ArrayList;

public class EnrolmentsRepo<List> extends Connection {

    public void insertEnrolment(Enrolments enrolment){
        String insertInto = "";
        insertInto += "INSERT INTO enrolment";
        insertInto += "( student_id, course_id, created_at) ";
        insertInto += "VALUES(";
        insertInto += String.format(" %d, %d, '%s'", enrolment.getStudentID(),enrolment.getCourseID(),enrolment.getData());
        insertInto += ")";
        exacuteStatement(insertInto);

    }

    public String updateDate(int id, String date){
        String update = "";
        update += String.format("UPDATE enrolment SET created_at = '%s'", date);
        update += String.format("WHERE id = %d",id);
        exacuteStatement(update);

        return date;
    }

    public void delete(int id){

            String delete = "";
            delete += "DELETE FROM enrolment ";
            delete += String.format("WHERE id = %d", id);
            exacuteStatement(delete);

    }

    private ResultSet selectAll(){
        exacuteStatement("SELECT * FROM enrolment");
        try {
            return statement.getResultSet();
        }catch (Exception e){
            System.out.println("Nu s-a conectat la schita");
            return null;
        }
    }
    private ResultSet findEnrolmentById(int id){
        String curs = "";
        curs += "SELECT * FROM enrolment ";
        curs += String.format("WHERE id = %d", id);
        exacuteStatement(curs);

        try {
            return statement.getResultSet();
        }catch (Exception e){
            System.out.println("Nu s-a conectat la schita");
            return null;
        }
    }

    public Enrolments enrolmnentById(int id){

        ResultSet set = findEnrolmentById(id);

        java.util.List<Enrolments> enrolmentList = new ArrayList<>();

        try {
            while (set.next()){
                enrolmentList.add(new Enrolments(set.getInt(1),set.getInt(2),set.getInt(3),set.getString(4)));
            }

        }catch (Exception e){
            System.out.println("Lista nu s-a creat");
        }
        return enrolmentList.get(0);
    }


    public java.util.List<Enrolments> allEnrolments(){
        ResultSet set = selectAll() ;

      java.util.List<Enrolments> enrolmentsList = new ArrayList<>();

      try {
          while (set.next()){
              enrolmentsList.add(new Enrolments(set.getInt(1),set.getInt(2),set.getInt(3),set.getString(4)));
          }

      }catch (Exception e){
          System.out.println("Nu s-a conectat la schita.");
      }
      return enrolmentsList;
  }

    public ResultSet locateCurs(int studId,int cursId,String data){

        String locate = "";
        locate += "INSERT INTO enrolment";
        locate += " (student_id, course_id, created_at)";
        locate += String.format(" VALUES( %d, %d, '%s'",studId,cursId,data);
        locate += ")";

        exacuteStatement(locate);

        try {
            return statement.getResultSet();

        }catch (Exception e){
            System.out.println("Nu s-a conectat la schita");
            return null;
        }

    }

    public java.util.List<Enrolments> cursInscris( int studId,int cursId, String data){
        ResultSet set = locateCurs(cursId,studId,data);

        java.util.List<Enrolments> enrolmentsList = new ArrayList<>();
        try {
            while (set.next()){
                enrolmentsList.add(new Enrolments(set.getInt(1),set.getInt(2),set.getInt(3),set.getString(4)));
            }
        }catch (Exception e){
            System.out.println("Nu s-a creat lista");
        }
        return enrolmentsList;
    }

    //functie ce primeste ca parametru id unui student si returneaza toate enrolmenturile unde se gaseste

    private ResultSet returnEnrolments(int id){
        String enrolments = "";
        enrolments += "select  * from enrolment ";
        enrolments += String.format("where student_id= %d", id);

        exacuteStatement(enrolments);

        try {
            return statement.getResultSet();
        }catch (Exception e){
            System.out.println("Error");
            return null;
        }

    }

    public java.util.List<Enrolments> enrolmentsInscris(int id){

        ResultSet set = returnEnrolments(id);

        java.util.List<Enrolments> enrolmentsList = new ArrayList<>();

        try {

            while (set.next()){
                enrolmentsList.add(new Enrolments(set.getInt(1),set.getInt(2),set.getInt(3),set.getString(4)));
            }

        }catch (Exception e){
            System.out.println("Error");

        }
        return enrolmentsList;
    }


}
