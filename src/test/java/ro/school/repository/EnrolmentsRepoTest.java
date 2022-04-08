package ro.school.repository;

import org.junit.jupiter.api.Test;
import ro.school.model.Enrolments;

import static org.junit.jupiter.api.Assertions.*;

class EnrolmentsRepoTest {

    @Test
    public void testInserTo(){
        Enrolments enrolments = new Enrolments(4,3,3,"2018-05-04");
        EnrolmentsRepo enrolmentsRepo = new EnrolmentsRepo();

        enrolmentsRepo.insertEnrolment(enrolments);
    }

    @Test
    public void testUpdate(){
        EnrolmentsRepo enrolmentsRepo = new EnrolmentsRepo();
        enrolmentsRepo.updateDate(1,"2020-01-01");
    }

    @Test
    public void testDelete(){
        EnrolmentsRepo enrolmentsRepo = new EnrolmentsRepo();
        enrolmentsRepo.delete(4);
    }

    @Test
    public void testAfisare(){
        EnrolmentsRepo enrolmentsRepo = new EnrolmentsRepo();
        System.out.println(enrolmentsRepo.allEnrolments());
    }
}