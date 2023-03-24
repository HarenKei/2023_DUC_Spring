package main;

import chapter06.Calculator;
import chapter06.RecCalculator;
import config.AppConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainAspect {

    public static void main(String[] args) {
//        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);
//
//        RecCalculator calculator = ctx.getBean("calculator", RecCalculator.class);
//        long result = calculator.factorial(5);
//        System.out.println("cal.factorial(5) = "+ result);
//        System.out.println(calculator.getClass().getName());
//        ctx.close();

        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);

        Calculator calculator = ctx.getBean("calculator", Calculator.class);
        calculator.factorial(7);
        calculator.factorial(7);
        calculator.factorial(5);
        calculator.factorial(5);
        ctx.close();
    }



}