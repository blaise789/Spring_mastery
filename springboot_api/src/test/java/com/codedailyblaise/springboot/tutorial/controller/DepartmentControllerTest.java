package com.codedailyblaise.springboot.tutorial.controller;

import com.codedailyblaise.springboot.tutorial.error.DepartmentNotFoundException;
import com.codedailyblaise.springboot.tutorial.model.Department;
import com.codedailyblaise.springboot.tutorial.service.DepartmentService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

@WebMvcTest(DepartmentController.class)
class DepartmentControllerTest {
 @Autowired
 private MockMvc mockMvc;
 @MockBean
 private DepartmentService departmentService;

 private Department department;
    @BeforeEach
    void setUp() {
        department=Department.builder()
                .departmentName("SOD")
                .departmentCode("RCA017")
                .departmentAddress("Rwanda Coding Academy")
                .departmentId(1L)
                .build();
//        we don't need repository role

    }
    @Test
    void saveDepartment() throws Exception {

        Department inputDepartment=Department.builder()
                .departmentAddress("Rwanda Coding Academy")
                .departmentCode("RCA017")
                .departmentName("SOD")
                .build();
        Mockito.when(departmentService.saveDepartment(inputDepartment)).thenReturn(department);
    //call endpoint
        mockMvc.perform(post("/departments").contentType(MediaType.APPLICATION_JSON).content("{\n" +
                "  \"departmentName\":\"SOD\",\n" +
                "\t\"departmentAddress\":\"Rwanda Coding Academy\",\n" +
                "\t\"departmentCode\":\"RCA017\"\n" +
                "}")).andExpect(status().isOk());
    }
    @Test
    void fetchDepartmentById() throws Exception {
        Mockito.when(departmentService.fetchDepartmentById(1L)).thenReturn(department);
        mockMvc.perform(get("/departments/1").contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.departmentName").value(department.getDepartmentName()));
        ;


    }
}