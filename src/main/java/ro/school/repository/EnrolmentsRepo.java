package ro.school.repository;

import ro.school.model.Enrolments;

import javax.lang.model.type.ArrayType;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class EnrolmentsRepo<List> extends Connection {


    public void insertEnrolment(Enrolments enrolment){
        String insertInto = "";
        insertInto += "INSERT INTO enrolment";
        insertInto += "(id, student_id, course_id, created_at) ";
        insertInto += "VALUES(";
        insertInto += String.format("%d, %d, %d, '%s'", enrolment.getId(), enrolment.getStudentID(),enrolment.getCourseID(),enrolment.getData());
        insertInto += ")";
        exacuteStatement(insertInto);

    }

    public void updateDate(int id, String date){
        String update = "";
        update += String.format("UPDATE enrolment SET created_at = '%s'", date);
        update += String.format("WHERE id = %d",id);
        exacuteStatement(update);
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

  public java.util.List<Enrolments> allEnrolments(){
        ResultSet set = selectAll();

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
}
