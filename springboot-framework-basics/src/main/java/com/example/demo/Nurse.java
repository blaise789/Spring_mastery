package com.example.demo;

import org.springframework.stereotype.Component;

@Component
public class Nurse implements  Staff {
    public void assisting(){
        System.out.println("nurse is assisting");
    }
}
