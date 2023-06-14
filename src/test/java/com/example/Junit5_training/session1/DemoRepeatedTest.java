package com.example.Junit5_training.session1;






import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class DemoRepeatedTest {

    //@BeforeEach method to create instance of Calculator class.we can remove instance of Calculator class from All TestMethods
    Calculator calculator;

    //They are Four Types of LifeCycleMethods[Concept]
//    @BeforeAll
//    @BeforeEach
//    @AfterAll
//    @AfterEach

    @BeforeAll
    //This annotation makes your method to execute one time only Before allTest Methods executes.It need to be static.Example if you need a database to be created  in setUp method,then you can use CleanUp method to delete the Database
    static void setup(){
        System.out.println("Executing @BeforeAll Method.");
    }

    @AfterAll
// This Annotation make your method execute one time only after all Test methods complete.It need to be static. we will use this for cleanUp purpose
    static void cleanUp(){
        System.out.println("Executing @AfterAll Method.");
    }

    @BeforeEach
        //This Annotation is used for a method you want to run before each test method
    void beforeEachTestMethod(){
        calculator = new Calculator();
        System.out.println("Executing @BeforeEach Method.");
    }

    @AfterEach
        //
    void afterEachTestMethod(){ //If your running Integration test for example and your test method made some changes in database,then you can use this method to delete all those records.
        System.out.println("Executing @AfterEach Method.");
    }

    //Advanced Concept-5[@RepeatedTest Annotation]
    //for this method to repeat multiple times,we will need to remove @Test  annoattion and
    //we will place @RepeatedTest annotation
    // @RepeatedTest(<No of times we want this test to be repated>)
   // [Optional]
    //If needed we can also get access to reputation information inside of our test method.
    //to do that Junit allows us to inject repetition ,information object as a method argument to our test method.
//we will put a RepetitionInjection in a new  method parameters
//    void testIntegerDivision_WhenDividendIsDividedByZero1_ShouldThrowArithemeticException(
//            RepetitionInfo repetitionInfo){
//
//        System.out.println("Repetition #" +repetitionInfo.getCurrentRepetition()
//                + "of" +repetitionInfo.getTotalRepetitions());
//
// Additionally to inject the repetition information to our test method,we can also inject test
    //method testInformation Object and get information about currently running test.
    //to do that we need to insert second parameter Object

    //Here we learn about how to verify the method your testing throws Exception,we use IntegerDivsion method
    //we use assertThrows assertion.
    @DisplayName("Division By Zero")
    //@RepeatedTest(3)
    @RepeatedTest(value = 3,name = "{displayName}.Repetition {currentRepetition} of " +
            "{totalRepetitions}")
    void testIntegerDivision_WhenDividendIsDividedByZero1_ShouldThrowArithemeticException(
            RepetitionInfo repetitionInfo,TestInfo testInfo){
        System.out.println("Running" + testInfo.getTestMethod().get().getName());
       System.out.println("Repetition #" +repetitionInfo.getCurrentRepetition()
               + "of" +repetitionInfo.getTotalRepetitions());

        System.out.println("Running division By zero");
        //Arrange //no need to create Calculator Object already Created in @BeforeEach method
        int dividend = 4;
        int divisor = 0;
        String expectedExceptionMessage = "/ by zero";

        //The First Parameter that assertThrows asssertion  accepts is
        //type or className of Exception we are expecting ,Second Parameter is executable
        //here we will provide lambda function that will invoke my our method under test
//Third Parameter that we can include in this assert after lambda function parameter(Second) is
//OptionalMessage that we can include it in optional Message thatwill be printed if this assertion fails
        //Act & Assert//to invoke method
        ArithmeticException actualException =
                assertThrows(ArithmeticException.class,()->{
                    //Act
                    calculator.integerDivision(dividend,divisor);
                },"Division by Zero should have thrown an Arithemetic Exception");


        //Assert
        //we can check  with exception message that was returned  is whatwe are expecting
        //we will assign the result of assertion to a local Varaiable called
        // actualException and we can verify with assertEquals method.
        assertEquals(expectedExceptionMessage,actualException.getMessage(),"Unexpected Exception Messsage");

    }

}
