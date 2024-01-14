package com.spring_jpa.springdatatutorial.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString(exclude = "course")
@Builder
public class CourseMaterial {
    @Id
    @SequenceGenerator(
    name = "courseMaterial_sequence",
    sequenceName = "courseMaterial_sequence",
    allocationSize = 1
            )
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
            generator = "courseMaterial_sequence"
    )
    private  Long courseMaterialId;
    private String url;
    @OneToOne(
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY
    )
  @JoinColumn(
          name = "course_id",
          referencedColumnName = "courseId"
  )
    private  Course course;

}
