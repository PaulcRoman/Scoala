package ro.school.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.ToString;

@Data
@ToString
@Getter
public class Enrolments {
    private int id;
    private int studentID;
    private  int courseID;
    private String data;

    public Enrolments(int studentID, int courseID, String data){
        this.courseID = courseID;
        this.studentID = studentID;
        this.data = data;
    }

    public Enrolments(int courseID){
        this.courseID = courseID;
    }

    public Enrolments(int id, int studentID, int courseID, String data) {
        this.id = id;
        this.studentID = studentID;
        this.courseID = courseID;
        this.data = data;
    }
}
