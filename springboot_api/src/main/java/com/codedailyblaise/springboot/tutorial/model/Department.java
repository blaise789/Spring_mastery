package com.codedailyblaise.springboot.tutorial.model;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Department {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private  long departmentId;
    @NotBlank(message = "please add you department name")
    private String departmentName;
    private String departmentAddress;
    private String departmentCode;

}
