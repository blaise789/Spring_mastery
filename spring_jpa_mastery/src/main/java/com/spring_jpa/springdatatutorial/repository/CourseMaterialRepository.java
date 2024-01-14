package com.spring_jpa.springdatatutorial.repository;

import com.spring_jpa.springdatatutorial.entity.CourseMaterial;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseMaterialRepository  extends JpaRepository<CourseMaterial,Long> {
}
