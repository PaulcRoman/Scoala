package ro.school.View;

import ro.school.model.Course;
import ro.school.model.Enrolments;
import ro.school.model.Student;
import ro.school.model.StudentIDCard;
import ro.school.repository.*;

import java.util.List;
import java.util.Scanner;

public class ViewUser {

    private BookRepo bookRepo;
    private CourseRepo courseRepo ;
    private EnrolmentsRepo enrolmentsRepo;
    private StudentIdCardRepo studentIdCardRepo;
    private Scanner scanner;
    private Student student;

    public ViewUser() {
        this.bookRepo = new BookRepo();
        this.courseRepo = new CourseRepo();
        this.enrolmentsRepo = new EnrolmentsRepo();
        this.studentIdCardRepo = new StudentIdCardRepo();
        this.scanner = new Scanner(System.in);
        this.student = new Student(1,"Stefania","Stocky","sstocky0@irs.gov",1,"35ki3B50TR");

    }

    public void menu(){

        System.out.println("----Menu User----");
        System.out.println("Apasa tasta 1 pentru a vizualiza cursurile");
        System.out.println("Apasa tasta 2 pentru a vedea cursurile la care sunteti inscris");
        System.out.println("Apasati tasta 3 petru a va inscrie la un nou curs");
        System.out.println("Apasati tasta 4 pentru a va crea un card");
        System.out.println("Apasati tasta 5 petru a iesi din menu");


    }

    public void play(){
        menu();

        int alegere = Integer.parseInt(scanner.nextLine());

        switch (alegere){
            case 1:
                afisareCurs();
                menu();
                break;
            case 2:
                cursuriInscris();
                break;
            case 3:
                inscriereCursNou();
                break;
            case 4:
                newCard();
                break;
            case 5:
                menu();
                break;

        }
    }

    public void afisareCurs(){

        List<Course> courses = courseRepo.allCourse();

        for (Course c : courses){
            System.out.println(c);

        }

    }

    public void cursuriInscris() {

       List<Enrolments> enrolments = enrolmentsRepo.enrolmentsInscris(student.getId());

        System.out.println(enrolments);
       for (Enrolments e : enrolments){

            Course course= courseRepo.courseById(e.getCourseID());

           System.out.println(course);

       }

    }

    public void inscriereCursNou() {

            afisareCurs();

//            System.out.println("Introduceti ID-ul dvs");
//
//            int id = scanner.nextInt();
//
//
            System.out.println("Introduceti ID-ul cursului la care doriti sa va inscrieti");

            int alegere = Integer.parseInt(scanner.nextLine());

            if (alegere > 0 && alegere < 4) {

                enrolmentsRepo.enrolmentsInscris(alegere);

            }else {
                System.out.println("Te rugam sa introduci in ID de curs valid");
            }

        cursuriInscris();
//
//            afisareCurs();
//            System.out.println("Introduceti data in format yyyy-mm-dd de cand doriti sa incepeti");
//
//
//            String data = scanner.nextLine();
//
//        List<Enrolments> enrolmentCurs = enrolmentsRepo.cursInscris(id,idCurs,data);
//
//        for (Enrolments e : enrolmentCurs){
//            System.out.println(e);
//        }

        }

    public void newCard(){

        System.out.println("Introduceti ID-ul");

        int id = Integer.parseInt(scanner.nextLine());

        System.out.println("Introduceti nr de card dorit");

        int nrCard = Integer.parseInt(scanner.nextLine());

        studentIdCardRepo.insertInto(new StudentIDCard(id,nrCard));

        System.out.println("Cardul a fost creat cu success.");


    }


}


