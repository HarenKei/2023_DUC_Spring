package main;

import chapter06.ExeTimeCalculator;
import chapter06.ImpleCalculator;
import chapter06.RecCalculator;

public class CalculatorExample {
    public static void main(String[] args) {

//        long start = System.currentTimeMillis(); //실행시작시간 체크
//        long num = 4;
//        ImpleCalculator impleCalculator = new ImpleCalculator();
//        long result1 = impleCalculator.factorial(num);
//        long end = System.currentTimeMillis(); //실행완료시간
//
//        System.out.printf("ImpleCalculator.factorial(%d) 실행시간 : %d\n", num, (end-start));
//        System.out.printf("ImpleCalculator.factorial(4) = %d\n", result1);
//
//        System.out.println();
//
//        long start2 = System.currentTimeMillis();
//        RecCalculator recCalculator = new RecCalculator();
//        long result2 = recCalculator.factorial(5);
//        long end2 = System.currentTimeMillis();
//
//        System.out.printf("RecCalculator.factorial(%d) 실행시간 : %d\n", num, (end2-start2));
//        System.out.printf("recCalculator.factorial(5) = %d\n", result2);

        ExeTimeCalculator calculator1 = new ExeTimeCalculator(new ImpleCalculator());
        System.out.println(calculator1.factorial(20));

        ExeTimeCalculator calculator2 = new ExeTimeCalculator(new RecCalculator());
        System.out.println(calculator2.factorial(20));
    }
}
