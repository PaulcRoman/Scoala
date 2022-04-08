package ro.school.repository;

import org.junit.jupiter.api.Test;
import ro.school.model.StudentIDCard;

import static org.junit.jupiter.api.Assertions.*;

class StudentIdCardRepoTest {

    @Test
    public void testInsert(){
        StudentIDCard studentIDCard = new StudentIDCard(4,4);
        StudentIdCardRepo studentIdCardRepo = new StudentIdCardRepo();
        studentIdCardRepo.insertInto(studentIDCard);
    }

    @Test
    public void testUpdate(){
      StudentIdCardRepo studentIdCardRepo = new StudentIdCardRepo();
      studentIdCardRepo.updateCardNumber(4,7);
    }

    @Test
    public void testDelete(){
        StudentIdCardRepo studentIdCardRepo = new StudentIdCardRepo();
        studentIdCardRepo.delete(4);
    }

    @Test
    public void testAllStudentId(){
        StudentIdCardRepo studentIdCardRepo = new StudentIdCardRepo();
        System.out.println(studentIdCardRepo.allStudentCards());
    }

}