package ro.school.repository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ro.school.model.StudentIDCard;

import static org.junit.jupiter.api.Assertions.*;

class StudentIdCardRepoTest {

    StudentIdCardRepo studentIdCardRepo;
    StudentIDCard studentIDCard;

    @BeforeEach
    public void initiere(){
        studentIdCardRepo = new StudentIdCardRepo();
    }

    @Test
    public void testInsert(){
         studentIDCard = new StudentIDCard(5,5);
        studentIdCardRepo.insertInto(studentIDCard);

        assertEquals(5, studentIDCard.getStudentID());
    }

    @Test
    public void testUpdate(){

      studentIdCardRepo.updateCardNumber(4,7);
      assertEquals(7,studentIdCardRepo.updateCardNumber(4,7));
    }

    @Test
    public void testDelete(){

        studentIdCardRepo.delete(4);
        System.out.println(studentIdCardRepo.allStudentCards());
//        assertNull(studentIdCardRepo.delete(4));


    }

    @Test
    public void testAllStudentId(){


        assertEquals(true,studentIdCardRepo.allStudentCards().size()>0);

    }

}