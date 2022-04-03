package ro.school.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

@Data
@ToString
@AllArgsConstructor
public class StudentIDCard {
    private int id;
    private int studentID;
    private int cardNumber;

    public StudentIDCard(int studentID, int cardNumber){
        this.studentID = studentID;
        this.cardNumber = cardNumber;

    }
}
