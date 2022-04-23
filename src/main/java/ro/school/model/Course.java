package ro.school.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class Course {

    private int id;
    private String name;
    private String department;

    public Course(String name, String department){
        this.name = name;
        this.department = department;
    }

    public Course(int id, String name, String department) {
        this.id = id;
        this.name = name;
        this.department = department;
    }
}
