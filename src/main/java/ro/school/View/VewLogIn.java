package ro.school.View;

import ro.school.model.Student;
import ro.school.repository.CourseRepo;
import ro.school.repository.EnrolmentsRepo;
import ro.school.repository.StudentIdCardRepo;
import ro.school.repository.StudentRepo;

import java.util.Scanner;

public class VewLogIn {

    private StudentRepo studentRepo;
    private CourseRepo courseRepo;
    private EnrolmentsRepo enrolmentsRepo;
    private StudentIdCardRepo studentIdCardRepo;
    private Scanner scanner;


    public VewLogIn() {
        this.studentRepo = new StudentRepo();
        this.courseRepo = new CourseRepo();
        this.enrolmentsRepo = new EnrolmentsRepo();
        this.studentIdCardRepo = new StudentIdCardRepo();
        this.scanner = new Scanner(System.in);
    }

    public void menu(){
        System.out.println("Apasati tasta 1 pentru a va loga");
        System.out.println("Apasati tasta 2 petru a iesi");
    }

    public void go(){
        boolean running = true;

        while (running){
            menu();

            int alegere = Integer.parseInt(scanner.nextLine());

            switch (alegere) {
                case 1:
                login();
                break;
            }
        }

    }

    public void login(){
        System.out.println("Introduceti emailul ");
        String email = scanner.nextLine();

        System.out.println("Introduceti parola");
        String parola = scanner.nextLine();

        Student student = studentRepo.login(email, parola);

        if (student != null){
            ViewUser viewUser = new ViewUser();
            viewUser.play();
        }
    }
}
