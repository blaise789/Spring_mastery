package com.codedailyblaise.springboot.tutorial.service;

import com.codedailyblaise.springboot.tutorial.model.Department;
import com.codedailyblaise.springboot.tutorial.repository.DepartmentRepository;
import org.junit.jupiter.api.*;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class DepartmentServiceTest {
@Autowired

private DepartmentService departmentService;
@MockBean
private DepartmentRepository departmentRepository;

    @BeforeEach
    void setUp() {

        Department department = Department.builder()
                .departmentName("IT")
                .departmentAddress("Kigali")
                .departmentCode("IT-06")
                .departmentId(1L)
                .build();
//        mocking
        Mockito.when(departmentRepository.findByDepartmentNameIgnoreCase("IT")).thenReturn(department);
//    whenever you call this method I need you to give me the department only without testing how they repository layer works
    }
    @Test
    @DisplayName("Get Data based on valid Department Name")
    @Disabled
    public void whenValidName_thenDepartmentShouldFound(){
        String departmentName="IT";
        Department found=departmentService.fetchDepartmentByName(departmentName);
        assertEquals(departmentName,found.getDepartmentName());
    }
//    @Test
//    testing repository layer


}