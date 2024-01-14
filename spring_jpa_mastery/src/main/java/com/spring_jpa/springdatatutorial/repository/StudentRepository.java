package com.spring_jpa.springdatatutorial.repository;

import com.spring_jpa.springdatatutorial.entity.Student;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student,Long> {

    public List<Student> findByFirstName(String firstName);
    public List<Student> findByGuardianName(String guardianName);
// findByFirstNameContaining
    //select based on the class
    //jpql
    @Query("select s from Student s where s.emailId=?1")
  Student getStudentByEmailAddress(String emailId);
    //jpql
 @Query("select s.firstName from Student s where s.emailId=?1")
    Student getFirstNameStudentByEmailAddress(String emailId);

 //native
 @Query(value = "SELECT * FROM student_table s WHERE s.email_address=?1 ",nativeQuery = true)
    Student getStudentByEmailAddressNatively(String emailId) throws Exception;
    //native named param
    @Query(value = "SELECT * FROM student_table s WHERE s.email_address=:emailId ",nativeQuery = true)
    Student getStudentByEmailAddressNativelyNamedParam(@Param("emailId") String emailId) ;

@Modifying
@Transactional
//after the methodis performed the data are transacted to the database
@Query(value = "update student_table set first_name=?1 where email_address=?2",nativeQuery = true)
    int updateStudentNameById(String firstName,String emailId);

}



