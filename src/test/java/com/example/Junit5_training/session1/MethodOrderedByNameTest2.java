package com.example.Junit5_training.session1;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;


@TestMethodOrder(MethodOrderer.MethodName.class)
public class MethodOrderedByNameTest2 {

//All methods will be runned by sorting their Names once run and check it
    // B->A->D->C initial methods
    //Ans: A->B->C->D //test cases execution


    @Test
    void TestB(){
        System.out.println("Running test B");
    }
    @Test
    void TestA(){
        System.out.println("Running test A");
    }
    @Test
    void TestD(){
        System.out.println("Running test D");
    }

    @Test
    void TestC(){
        System.out.println("Running test C");
    }

}
