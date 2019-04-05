package Demo06;

import org.aspectj.lang.ProceedingJoinPoint;

public class CarFactory {

    public void before(){
        System.out.println("before.....");
    }
    public void after(){
        System.out.println("after.....");
    }
    //环绕通知
    public void around(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        //方法之前
        System.out.println("环绕前.....");
        proceedingJoinPoint.proceed();

        //方法之后
        System.out.println("环绕后.....");
    }
}
