package ro.school.repository;

import ro.school.model.StudentIDCard;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class StudentIdCardRepo extends Connection{

    public void insertInto(StudentIDCard studentIDCard){
        String insertInto = "";
        insertInto += "INSERT INTO  student_id_card";
        insertInto += "(student_id,card_number)";
        insertInto += "VALUES (";
        insertInto += String.format("%d,%d",studentIDCard.getStudentID(),studentIDCard.getCardNumber());
        insertInto +=")";
        exacuteStatement(insertInto);
    }

    public void updateCardNumber(int id, int cardNumber){
        String update = "";
        update += String.format("UPDATE student_id_card SET card_number = %d ",cardNumber);
        update += String.format("WHERE id = %d", id);
        exacuteStatement(update);
    }

    public void delete(int id){
        String delete = "";
        delete += "DELETE FROM student_id_card ";
        delete += String.format("WHERE id = %d ", id);
        exacuteStatement(delete);
    }

    private ResultSet selectAll(){
        exacuteStatement("SELECT * FROM student_id_card");
        try {
            return statement.getResultSet();
        }catch (Exception e){
            System.out.println("Nu s-a conectat la schita");
            return null;
        }
    }

    public List<StudentIDCard> allStudentCards(){
        ResultSet set = selectAll();

        List<StudentIDCard> studentIDCardList = new ArrayList<>();

        try {

            while (set.next()){
                studentIDCardList.add(new StudentIDCard(set.getInt(1),set.getInt(2),set.getInt(3)));
            }

        }catch (Exception e){
            System.out.println("Nu s-a creat lista");
        }
        return studentIDCardList;
    }
}
