package com.spring_jpa.springdatatutorial.repository;

import com.spring_jpa.springdatatutorial.entity.Course;
import com.spring_jpa.springdatatutorial.entity.CourseMaterial;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class CourseMaterialRepositoryTest {

    @Autowired
    private CourseMaterialRepository repository;
    @BeforeEach
    void setUp() {
    }
    @Test
    public  void SaveCourseMaterial(){
        Course course= Course.builder()
                .title("DSA")
                .credit(6)
                .build();

        CourseMaterial courseMaterial=CourseMaterial.builder()
                        .url("www.course.org")
                        .course(course)
                        .build();
         repository.save(courseMaterial);
    }
    @Test
    public void printAllCourseMaterials(){
        List<CourseMaterial> courseMaterialList=repository.findAll();
        System.out.println(courseMaterialList);
    }
}