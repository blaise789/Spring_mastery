package com.example.demo;

//import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		ApplicationContext context=new AnnotationConfigApplicationContext(BeanConfig.class);
//		ApplicationContext context=new ClassPathXmlApplicationContext();
//		SpringApplication.run(DemoApplication.class, args);
Doctor doctor= context.getBean(Doctor.class);
doctor.assisting();
doctor.setQualification("MBBS");
		System.out.println(doctor);
		Doctor doctor1=context.getBean(Doctor.class);
		System.out.println(doctor1);

//Nurse nurse=(Nurse) context.getBean("nurse");
//		System.out.println(doctor.getQualification());
//nurse.assisting();
//	Doctor doctor1=context.getBean(Doctor.class);
//		System.out.println(doctor1);
////		doctor.assisting();


	}

}
