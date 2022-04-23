package ro.school.repository;

import ro.school.model.Book;
import ro.school.model.Enrolments;
import ro.school.model.Student;

import javax.print.attribute.standard.JobName;
import java.awt.event.TextEvent;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.sql.ResultSet;

public class BookRepo extends Connection{

    public void insertBook(Book book){
        String insertTo = "";
        insertTo += "INSERT INTO book";
        insertTo += "(book_name, created_at, student_id)";
        insertTo += "VALUES(";
        insertTo += String.format("'%s','%s',%d", book.getBookName(),book.getDateCreated(),book.getStudentId());
        insertTo += ")";
        exacuteStatement(insertTo);
    }

  public String updateDate(String bookName, String date){
        String update ="";
        update += String.format("UPDATE book SET created_at = '%s'", date);
        update += String.format("where book_name = '%s'",bookName);
        exacuteStatement(update);
        return date;
  }

  public void delete(String bookName){

            String delete = "";
            delete += "DELETE FROM book ";
            delete += String.format("WHERE book_name = '%s'", bookName);
            exacuteStatement(delete);

  }

  private ResultSet selectAll(){
        exacuteStatement("select * from book");
        try {
            return statement.getResultSet();
        }catch (Exception e){
            System.out.println("nu s-a conectat schita");
            return null;
        }
  }

  public List<Book> allBooks(){
        ResultSet set = selectAll();

        List<Book> bookList = new ArrayList<>();

        try {

            while (set.next()){
                bookList.add(new Book(set.getInt(1),set.getString(2),set.getString(3),set.getInt(4)));

            }
        }catch (Exception e){
            System.out.println("Nu s-a creat lista");
        }
        return bookList;
  }

  //todo :primeste ca parametru titlu cartii si returneaza cartea

    private ResultSet returnByName(String bName){

        exacuteStatement(String.format("select * from book where book_name = '%s' ",bName));
        try {
            return statement.getResultSet();
        }catch (Exception e){
            System.out.println("nu s-a conectat la schita");
            return null;
        }
    }

  public Book returnByName2(String bName){


        ResultSet resultSet=returnByName(bName);

        List<Book>bookList= new ArrayList<>();

        try {

            while (resultSet.next()) {
                bookList.add(new Book(resultSet.getInt(1), resultSet.getString(2), resultSet.getString(3), resultSet.getInt(4)));
            }

        }catch (Exception e){
            System.out.println("Error");
        }

        return bookList.get(0);
  }




}
