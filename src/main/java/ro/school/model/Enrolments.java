package ro.school.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

@Data
@AllArgsConstructor
@ToString
public class Enrolments {
    private int id;
    private  int courseID;
    private int studentID;
    private String data;

    public Enrolments(int courseID, int studentID, String data){
        this.courseID = courseID;
        this.studentID = studentID;
        this.data = data;
    }

    public Enrolments(int courseID){
        this.courseID = courseID;
    }

}
