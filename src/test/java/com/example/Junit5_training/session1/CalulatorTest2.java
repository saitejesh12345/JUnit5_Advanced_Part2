package com.example.Junit5_training.session1;


import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;


//The Regular @test methods when we executed they run one time only.
//Test Methods which are annotated with @ParameterizedTest annotation
//they accept method arguments and they can execute multiple  times depending on how many sets of arguments we provide.


@DisplayName("Test Math Operations in Calculator class")
public class CalulatorTest2 {
    //Now here testIntegerDivisionTest_WhenFourIsDividedByTwo_ShouldReturnTwo() &integerSubtractionTest()
    //Both methods create a new Object of Calculator Class so,we can use
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



    //Advanced Concept-1[@ParameterizedTest with @MethodSource]
    //We use @ParameterizedTest it is still going to be a test method ,but it now can accept
    //paramters and to provide multiple differnt input parameters we need to
    //add another annotation called @MethodSource()
    @DisplayName("Test Integer Subtraction[minuend,subtrahend,expectedResult")
    @ParameterizedTest
    @MethodSource()
    void integerSubtractionTest1(int minuend,int subtrahed,int expectedResult){

        System.out.println("Test" + minuend + "-"+ subtrahed +"=" +expectedResult);
        //Structure pattern 1. Arrange
        //create Instance of Calculator class

        // Calculator calculator = new Calculator();//we used @ BeforeEach class
        //Invoking the class using Object calling method and storing result in res variable


        int actualResult = calculator.integerSubtraction(minuend ,subtrahed);
        //verify check if two values are equal
        assertEquals(expectedResult,actualResult,
                () -> minuend + "-" + subtrahed+" "+"didn't produce output:"+expectedResult);
        //in assertion method each method we have dynamically computed message,this might
        // slow down your test methods a little bit in a small application,you will not even notice the difference but in much
        // larger application. with Many test methods,an assertion message is used .
        // Developers like to optimze it,and the reason it might slow down your tests alittle bit
        // is because this message will computed every time you test methods,grants whether it passes or fails.
        // this message will always be computed.It gets executed even though it might never be used.
        //So to optimize performance of unit Test,Developers like to convert this test Message into
        //Lambda and it can be converted to Lambda this way.
        //Now this message is lambda function that will be executed when this assertion fails the testMethod.
        //otheriwse ,if the test is passing ,this lambda function will never get executed and no Resourses will be spent
        //to compute this error message.

    }

    //This method to be static it need to return stream of arguments this method is related to above method coz we have inserted two annotations
    //@ParameterizedTest and @MethodSource and we are inserted parameters inside  void integerSubtractionTest1(int minuend,int subtrahed,int expectedResult)
    //so now we pass those parameters in this Argument Method,when we run thism method it runs with three
    //set of arguments this method is dependent on above method ie @MethodSource
    private static Stream<Arguments> integerSubtractionTest1(){

        return Stream.of(
                Arguments.of(33,23,10),
                Arguments.of(25,1,24),
                Arguments.of(33,1,32)
        );
    }



    //Advanced Concept-2[@ParameterizedTest with @CsvSource]
    //@CsvSourse annotation it allows us to supply a list of arguments as Comma Seperated Values,we can add many entries inside
    // //@csvSource({"32,1,31", "42,1,41","33,1,32"}),before we used @MethodSource right instead of that we are using @csvSource
    //So now here stream Arguments Method no need here we can remove it
    //Lets say we need to test with String Parameters we have to do like
    //@csvSource({"apple,orange",
    //"apple,''",
    //  "apple,"})
    @DisplayName("Test Integer Subtraction[minuend,subtrahend,expectedResult")
    //@MethodSource
    @CsvSource({"33,32,1",
            "42,1,41","33,1,32"})
    @ParameterizedTest
    void integerSubtractionTest2(int minuend,int subtrahed,int expectedResult){

        System.out.println("Test" + minuend + "-"+ subtrahed +"=" +expectedResult);
        //Structure pattern 1. Arrange
        //create Instance of Calculator class

        // Calculator calculator = new Calculator();//we used @ BeforeEach class
        //Invoking the class using Object calling method and storing result in res variable


        int actualResult = calculator.integerSubtraction(minuend ,subtrahed);
        //verify check if two values are equal
        assertEquals(expectedResult,actualResult,
                () -> minuend + "-" + subtrahed+" "+"didn't produce output:"+expectedResult);
        //in assertion method each method we have dynamically computed message,this might
        // slow down your test methods a little bit in a small application,you will not even notice the difference but in much
        // larger application. with Many test methods,an assertion message is used .
        // Developers like to optimze it,and the reason it might slow down your tests alittle bit
        // is because this message will computed every time you test methods,grants whether it passes or fails.
        // this message will always be computed.It gets executed even though it might never be used.
        //So to optimize performance of unit Test,Developers like to convert this test Message into
        //Lambda and it can be converted to Lambda this way.
        //Now this message is lambda function that will be executed when this assertion fails the testMethod.
        //otheriwse ,if the test is passing ,this lambda function will never get executed and no Resourses will be spent
        //to compute this error message.

    }

    //This method to be static it need to return stream of arguments this method is related to above method coz we have inserted two annotations
    //@ParameterizedTest and @MethodSource and we are inserted parameters inside  void integerSubtractionTest1(int minuend,int subtrahed,int expectedResult)
    //so now we pass those parameters in this Argument Method,when we run thism method it runs with three
    //set of arguments this method is dependent on above method ie @MethodSource

//    private static Stream<Arguments> integerSubtractionTest1(){
//
//        return Stream.of(
//                Arguments.of(33,23,10),
//                Arguments.of(25,1,24),
//                Arguments.of(33,1,32)
//        );
//    }





    //Advanced Concept-3[@ParameterizedTest + @CsvSource]
    //You can also store these parameters values in  seperate file in a resourse Folder,
    //So instead of providing very long list of parameters values in @CsvSource we can comment @Csv annotation
    //we can use different annoatation we use different annotation called @CsvFileSource(<path to Source file>),in this
    //i will provide path to source file call it integerSubtraction.csv,This is because  we are working with integerSubtraction() method
    // [(resource = "/integerSubtraction.csv")] we do not have file we need to create.
    //Storing Parameters values in seperate file can be helpful when you need to test method with long list of values.
    //For Examples if you have a method which validates name and Email and address then you can Create seperate <FileName.csv> name
    //with very very long list of different name and Email and address,and then you can test your method with all sorts of
    //different kind of values.
    // 1.I will create this file or package in test as  "resources" folder.
    //2.Go to Project name RightClick Go to "Open Module Settings"
    //3.select "Modules" on left side and select "Calculator" class
    //4. In project Structure select under test select "resources"
    //5.Select TestResources ["Mark this directory as testResources root folder"] after clicking the icon will
    //slightly changes
    //6.create file by clicking on resources package
    @DisplayName("Test Integer Subtraction[minuend,subtrahend,expectedResult")
    //@MethodSource


//    @CsvSource({"33,32,1",
//            "42,1,41","33,1,32"})
    @ParameterizedTest
    @CsvFileSource(resources ="/integerSubtraction.csv")
    void integerSubtractionTest3(String data) {
        String[] dataArray = data.split(",");
        int minuend = Integer.parseInt(dataArray[0]);
        int subtrahed = Integer.parseInt(dataArray[1]);
        int expectedResult = Integer.parseInt(dataArray[2]);
        System.out.println("RunningTest" + minuend+ "-" + subtrahed + "=" + expectedResult);

        //Structure pattern 1. Arrange
        //create Instance of Calculator class

        // Calculator calculator = new Calculator();//we used @ BeforeEach class
        //Invoking the class using Object calling method and storing result in res variable


        int actualResult = calculator.integerSubtraction(minuend, subtrahed);
        //verify check if two values are equal
        assertEquals(expectedResult, actualResult,
                () -> minuend + "-" + subtrahed + " " + "didn't produce output:" + expectedResult);

    }






    //Advanced Concept-4[@ParameterizedTest with @ValueSource Annotation]
//@ValueSource annotation is used to supply one single array of values and our method value Source Demonstartion can
    //accept only single parameter

    @ParameterizedTest
    @ValueSource(strings = {"John","kate","Alice"})
    void valueSourceDemonstration(String firstName){
System.out.println(firstName);

//i will also assert this value is NotNull i will provide assertNotNull() and provide firstName as aparameter
        //if the value of firstName is Null,then this method will fail and we know there is
        //something wrong,now lets provide parameters to this method and will use values for annotation   @ValueSource(strings = {"John","kate","Alice"})
        //Each time it will accept one parameter as a firstName,so first  value will be John and secon time when we run  it will be kate and
        // third time when we run it will Alice
assertNotNull(firstName);
    }




}
