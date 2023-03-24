package chapter06;

public class RecCalculator implements Calculator{
    @Override
    public long factorial(long num) {
        //재귀호출


        try {
            if(num == 0) {
                return 1;
            } else {
                return num * factorial(num - 1);
            }
        } finally {

        }

    }
}
