package com.codedailyblaise.springboot.tutorial.repository;

import com.codedailyblaise.springboot.tutorial.model.Department;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class DepartmentRepositoryTest {
  @Autowired
    private   DepartmentRepository departmentRepository;
  @Autowired
  private TestEntityManager entityManager;
    @BeforeEach
    void setUp() {
        Department department=Department.builder()
                .departmentName("Mechanical engineering")
                .departmentAddress("Musanze")
                .departmentCode("MU-02")
                .build();
        entityManager.persist(department);
    }
    @Test
    public void whenFindById_returnDepartment(){
        Department department=departmentRepository.findById(1L).get();
        assertEquals(department.getDepartmentName(),"Mechanical engineering");
    }
}