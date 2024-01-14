package com.codedailyblaise.springboot.tutorial.service;

import com.codedailyblaise.springboot.tutorial.error.DepartmentNotFoundException;
import com.codedailyblaise.springboot.tutorial.model.Department;

import java.util.List;

public interface DepartmentService {

 public    Department saveDepartment(Department department);
 public List<Department> fetchDepartmentList();
 public  Department fetchDepartmentById(long departmentId) throws DepartmentNotFoundException;
 public void deleteDepartmentById(long departmentId);
 public  Department updateDepartment(long departmentId,Department department);
 public Department fetchDepartmentByName(String departmentName);
}
