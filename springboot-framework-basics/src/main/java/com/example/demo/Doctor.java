package com.example.demo;

import org.springframework.beans.factory.BeanNameAware;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Scope(scopeName = "prototype")
@Component
//every class is a component to create beans out of it
public class Doctor implements
Staff,BeanNameAware {
    @Override
    public String toString() {
        return "Doctor{" +
                "qualification='" + qualification + '\'' +
                '}';
    }

    private  String qualification;
//
//  private   Nurse nurse;
//
//    public Doctor(String qualification) {
//        this.qualification = qualification;
//    }

    @Override
    public void assisting() {
        System.out.println("Doctor is assisting");
    }
    public String getQualification() {
        return qualification;
    }

    public void setQualification(String qualification) {
        this.qualification = qualification;
    }
//@PostConstruct can also be called to create custom method after creating a bean
    @Override
    public void setBeanName(String name) {
        System.out.println("Set bean name method is called ");
    }
}
