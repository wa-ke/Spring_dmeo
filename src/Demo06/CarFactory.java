package Demo06;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

@Aspect    //开启增强类
public class CarFactory {

    @Before(value = "execution(* Demo06.*.*(..))")  //注解配置AOP
    public void before(){
        System.out.println("before.....");
    }

    @After(value = "execution(* Demo06.*.*(..))")
    public void after(){
        System.out.println("after.....");
    }


    //环绕通知
    @Around(value = "execution(* Demo06.*.*(..))")
    public void around(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        //方法之前
        System.out.println("环绕前.....");
        proceedingJoinPoint.proceed();

        //方法之后
        System.out.println("环绕后.....");
    }
}
