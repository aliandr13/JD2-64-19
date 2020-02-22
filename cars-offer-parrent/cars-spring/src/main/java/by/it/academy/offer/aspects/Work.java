package by.it.academy.offer.aspects;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;

@Slf4j
@Aspect
public class Work {

    @Pointcut("execution( * by.it.academy.offer.aspects.TaskService.performJob())")
    public void performance() {
    }

    @Pointcut("execution( * by.it.academy.offer.aspects.TaskService.performJob(String)) && args(name)")
    public void intercept() {
    }

    @Before("performance()")
    public void beforeWork() {
        log.info("Execute before work");
    }

    @AfterReturning("performance()")
    public void afterWork() {
        log.info("Execution after work");
    }

    @AfterThrowing("performance()")
    public void afterWorkProblems() {
        log.info("Execution after work problems");
    }

    @Around("performance()")
    public void aroundWork(ProceedingJoinPoint
                                   joinPoint) {
        try {
            log.info("Start");
            log.info("Begin Time: " + System.currentTimeMillis());
            String result = (String) joinPoint.proceed();
            log.info("Finish Time: " + System.currentTimeMillis());
            log.info("Status: " + result);
        } catch (Throwable throwable) {
            log.error(String.valueOf(throwable));
        }
    }

    @Before(value = "intercept(name)")
    public void interceptWorkName(String name) {
        log.info("Intercepted work is: " + name);
    }

}