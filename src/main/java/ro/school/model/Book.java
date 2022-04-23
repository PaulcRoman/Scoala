package ro.school.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

@Data
@AllArgsConstructor
@ToString
public class Book {

    private int id;
    private String bookName;
    private String dateCreated;
    private int studentId;

    public Book(String bookName, String dateCreated,int studentId){
        this.bookName = bookName;
        this.dateCreated = dateCreated;
        this.studentId = studentId;
    }

}
