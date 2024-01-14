package com.spring_jpa.springdatatutorial.repository;

import com.spring_jpa.springdatatutorial.entity.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;

interface TeacherRespository extends JpaRepository<Teacher,Long> {
}
