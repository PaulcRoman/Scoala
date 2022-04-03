package ro.school.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

@Data
@ToString
@AllArgsConstructor
public class Course {

    private int id;
    private String name;
    private String department;

    public Course(String name, String department){
        this.name = name;
        this.department = department;
    }

}
