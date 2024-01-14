package com.codedailyblaise.springboot.tutorial.controller;

import com.codedailyblaise.springboot.tutorial.error.DepartmentNotFoundException;
import com.codedailyblaise.springboot.tutorial.model.Department;
import com.codedailyblaise.springboot.tutorial.service.DepartmentService;
import jakarta.validation.Valid;
import lombok.Getter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.swing.*;
import java.util.List;

@RestController
public class DepartmentController {
    @Autowired
    private DepartmentService departmentService;
    private final Logger LOGGER= LoggerFactory.getLogger(DepartmentController.class);
//    Auto wire the object that you have In your spring container to this reference
    //using inversion of control and dependency injection instead of using new keyword to create an object
    @PostMapping("/departments")
    public Department saveDepartment(@Valid @RequestBody Department department) {
        LOGGER.info("request sent");
 return departmentService.saveDepartment(department);
    }
    @GetMapping("/departments")
    public List<Department> fetchDepartmentList(){
        return departmentService.fetchDepartmentList();
    }
    @GetMapping("/departments/{id}")
    public Department fetchDepartmentById( @PathVariable("id")  Long departmentId) throws DepartmentNotFoundException {
        return  departmentService.fetchDepartmentById(departmentId);
    }
    @DeleteMapping("/departments/{id}")
    public String deleteDepartmentById(@PathVariable("id") Long departmentId){
         departmentService.deleteDepartmentById(departmentId);
        return "Department deleted successfully";
    }
    @PutMapping("/departments/{id}")
public Department updateDepartment(@PathVariable("id") Long departmentId,@RequestBody Department department){
        return departmentService.updateDepartment(departmentId,department);
    }
    @GetMapping("/departments/name/{name}")
    public  Department fetchDepartmentByName(@PathVariable("name") String departmentName){
        return departmentService.fetchDepartmentByName(departmentName);
    }
}
