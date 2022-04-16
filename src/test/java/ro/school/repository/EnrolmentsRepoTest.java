package ro.school.repository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ro.school.model.Enrolments;

import static org.junit.jupiter.api.Assertions.*;

class EnrolmentsRepoTest {

    Enrolments enrolments;
    EnrolmentsRepo enrolmentsRepo;

    @BeforeEach
    public void initiere(){
        enrolmentsRepo = new EnrolmentsRepo();
    }

    @Test
    public void testInserTo(){
         enrolments = new Enrolments(7,3,3,"2018-05-04");
         enrolmentsRepo = new EnrolmentsRepo();

        enrolmentsRepo.insertEnrolment(enrolments);

        assertEquals(7, enrolments.getId());
    }

    @Test
    public void testUpdate(){

//        enrolmentsRepo.updateDate(1,"2020-01-02");
        assertEquals("2020-01-02",enrolmentsRepo.updateDate(6,"2020-01-02"));
    }

    @Test
    public void testDelete(){

//        enrolmentsRepo.delete(6);

        assertEquals(true, enrolmentsRepo.delete(7));
    }

    @Test
    public void testAfisare(){

//        System.out.println(enrolmentsRepo.allEnrolments());

        assertEquals(null, enrolmentsRepo.allEnrolments());
    }
}