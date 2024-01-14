package com.spring_jpa.springdatatutorial.repository;

import com.spring_jpa.springdatatutorial.entity.Guardian;
import com.spring_jpa.springdatatutorial.entity.Student;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


//@DataJpaTest
//after the test is completed the data will be flushed
   @SpringBootTest
class StudentRepositoryTest {
       @Autowired
       private  StudentRepository studentRepository;

    @BeforeEach
    void setUp() {
    }
    @Test
    public void saveStudent(){
        Student student=Student.builder()
                .emailId("blaise@gmail.com")
                .firstName("bigirabagabo")
                .lastName("blaise")
                .build();
 studentRepository.save(student) ;
    }
    @Test

    public void saveStudentWithGuardian(){
        Guardian guardian=Guardian.builder()
                .name("nhghg")
                .email("nghgh@gmail.com")
                .mobile("0781881")
                .build();
        Student student=Student.builder()
                        .firstName("baggy")
                .lastName("hirwa")
                .emailId("hirwa@gmail.com")
                .guardian(guardian)
                .build();
studentRepository.save(student);
    }
    @Test
    public void printAllStudent(){
        List<Student> studentList=studentRepository.findAll();
        System.out.println(studentList);
    }
    @Test
    public void findByStudentFirstName(){
        List<Student> studentList=studentRepository.findByFirstName("bigirabagabo");
        System.out.println(studentList);
    }
    @Test
    public void findBasedOnGuardian(){
        List<Student> studentList=studentRepository.findByGuardianName("nhghg");
        System.out.println(studentList);
    }
    @Test
    public void printGetStudentByEmailAddress(){
        Student student=studentRepository.getStudentByEmailAddress("blaise@gmail.com");
        System.out.println(student);
    }
    @Test
    public void printGetStudentByEmailAddressNatively( )throws  Exception{
        Student student=studentRepository.getStudentByEmailAddressNatively("blaise@gmail.com");
        System.out.println(student);
    }
    @Test
    public void updateStudentNameByEmailId(){
        studentRepository.updateStudentNameById("Medusa","blaise@gmail.com");
    }

}