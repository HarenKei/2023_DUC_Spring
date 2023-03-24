package aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

import java.util.Arrays;

@Aspect
public class ExeTimeAspect {

    @Pointcut("execution(public * chapter06..*(..))")
    public void publicTarget() {

    }

    @Around("publicTarget()")
    public Object main(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        long start = System.nanoTime();

        try {
            Object result = proceedingJoinPoint.proceed();
            return result;
        } finally {
            long end = System.nanoTime();
            Signature sig = proceedingJoinPoint.getSignature();
            System.out.printf("%s.%s(%s) 실행시간 : %d\n",
                    proceedingJoinPoint.getTarget().getClass().getSimpleName(),
                    sig.getName(),
                    Arrays.toString(proceedingJoinPoint.getArgs()),
                    (end - start));
        }

    }
}
