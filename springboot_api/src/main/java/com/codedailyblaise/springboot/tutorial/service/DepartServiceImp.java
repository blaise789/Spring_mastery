package com.codedailyblaise.springboot.tutorial.service;

import com.codedailyblaise.springboot.tutorial.error.DepartmentNotFoundException;
import com.codedailyblaise.springboot.tutorial.model.Department;
import com.codedailyblaise.springboot.tutorial.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class DepartServiceImp  implements  DepartmentService{
    @Autowired
    private DepartmentRepository departmentRepository;
    @Override
    public Department saveDepartment(Department department) {
     return departmentRepository.save(department);
    }

    @Override
    public List<Department> fetchDepartmentList() {
        return departmentRepository.findAll();
    }

    @Override
    public Department fetchDepartmentById(long departmentId) throws DepartmentNotFoundException {
        Optional<Department> department= departmentRepository.findById(departmentId);
                                  if(!department.isPresent()){
                                      throw new DepartmentNotFoundException("the department does not exist");
                                  }
                return department.get();
                 
  
    }

    @Override
    public void deleteDepartmentById(long departmentId) {
departmentRepository.deleteById(departmentId);
    }

    @Override
    public Department updateDepartment(long departmentId, Department department) {
        Department depDb=departmentRepository.findById(departmentId).get();

if(Objects.nonNull(department.getDepartmentName())&& !" ".equalsIgnoreCase(department.getDepartmentName())){
    depDb.setDepartmentName(department.getDepartmentName());
}
if(Objects.nonNull(department.getDepartmentAddress()) && !" ".equalsIgnoreCase(department.getDepartmentAddress())){
            depDb.setDepartmentAddress(department.getDepartmentAddress());
        }
if(Objects.nonNull(department.getDepartmentCode())&& !" ".equalsIgnoreCase(department.getDepartmentCode())){
            depDb.setDepartmentCode(department.getDepartmentCode());
        }
        return departmentRepository.save(depDb);
    }





    @Override
    public Department fetchDepartmentByName(String departmentName) {

        return departmentRepository.findByDepartmentNameIgnoreCase(departmentName);
    }
}
