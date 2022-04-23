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

        enrolmentsRepo.updateDate(6,"2020-01-10");
        assertEquals("2020-01-10",enrolmentsRepo.updateDate(6,"2020-01-10"));
    }

    @Test
    public void testDelete(){

        enrolmentsRepo.delete(6);

//        assertEquals(true, enrolmentsRepo.delete(7));

        assertNull(enrolmentsRepo.enrolmnentById(6));
    }

    @Test
    public void testAfisare(){

        assertEquals(null, enrolmentsRepo.allEnrolments());
    }

    @Test
    public void enrolmentsInscris(){

//        assertEquals(2,enrolmentsRepo.enrolmentsInscris(1).contains(new Enrolments()));
        assertEquals(true,enrolmentsRepo.enrolmentsInscris(2).size()<2);



    }
}