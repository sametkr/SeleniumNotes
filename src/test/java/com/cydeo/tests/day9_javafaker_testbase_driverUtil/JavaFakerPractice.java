package com.cydeo.tests.day9_javafaker_testbase_driverUtil;

import com.github.javafaker.Faker;
import org.testng.annotations.Test;

public class JavaFakerPractice {

    @Test
    public void test1(){
        Faker faker = new Faker();

        System.out.println(faker.name().firstName());
        System.out.println(faker.name().lastName());
        System.out.println(faker.name().fullName());
        System.out.println(faker.address().fullAddress());

        //numerify method will generate random numbers in the format we want "#"
        System.out.println(faker.numerify("###-###-#####"));
        System.out.println(faker.numerify("312-###-#####"));

        //letterify method will generate random letters in the format we want "?"
        System.out.println(faker.letterify("???-????"));

        //bothify "##?#-#??#-??##-?#?#"
        System.out.println(faker.bothify("##?#-#??#-??##-?#?#"));

        //System.out.println(faker.finance().creditCard());

        System.out.println(faker.number().numberBetween(1,12));




    }
}
