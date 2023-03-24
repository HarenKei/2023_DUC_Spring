package chapter06;

public class ImpleCalculator implements Calculator{

    @Override
    public long factorial(long num) {
        //num을 가지고 계산을 하여 result를 return
        long result = 1;

        for(long i = 1; i <= num; i++) {
            result *= i;
        }
        return result;
    }
}
