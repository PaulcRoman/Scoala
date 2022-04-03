package ro.school.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

@Data
@AllArgsConstructor
@ToString

public class Student {
    private int id;
    private String firstName;
    private String lastName;
    private String email;
    private int age;
    private String password;


    public Student(String firstName, String lastName, String email, int age, String password){
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.age = age;
        this.password = password;
    }
}
