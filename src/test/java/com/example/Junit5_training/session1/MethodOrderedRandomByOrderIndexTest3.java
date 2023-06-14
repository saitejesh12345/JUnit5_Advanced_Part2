package com.example.Junit5_training.session1;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;


@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class MethodOrderedRandomByOrderIndexTest3 {

//In this you can being able to control which method need
    //to be executed first and which method needs to be executed second.
    //It is very helpful when your are working with integration testing,especially
    //with those test that need to save somthing in the database and then find the same record
    //update the same record and then delete the same record.
    //In this case is being able to control which this method runs first and which this method runs second.

    @Order(1)
    @Test
    void TestB(){
        System.out.println("Running test B");
    }

    @Order(2)
    @Test
    void TestA(){
        System.out.println("Running test A");
    }

    @Order(3)
    @Test
    void TestD(){
        System.out.println("Running test D");
    }


    @Order(4)
    @Test
    void TestC(){
        System.out.println("Running test C");
    }



}
