package com.example.Junit5_training.session1;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;


@TestMethodOrder(MethodOrderer.Random.class)
public class MethodOrderedRandomlyTest1 {


    //Now i will add four basic method which doesn't test anything but it print String
             //Advanced Concept-5[@RepeatedTest Annotation]
//To make sure that this test method executes in random order,
//i will annotate this test method class with @TestMethodOrder Annotation
    //This method annotation allows us to use method order interface and
    //we can use this interface to specify which Order we would like to apply
    //to this methods.
    //@TestMethodOrder(MethodOrderer.) if i hit the dot,then using method order, we can order
    // we can make run our testMethods in Random Order /Order By name /so on....
    @Test
    void TestA(){
        System.out.println("Running test A");
    }

    @Test
    void TestB(){
        System.out.println("Running test B");
    }
    @Test
    void TestC(){
        System.out.println("Running test C");
    }
    @Test
    void TestD(){
        System.out.println("Running test D");
    }
}
