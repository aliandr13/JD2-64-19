package by.it.academy.offer.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.springframework.stereotype.Component;

@Slf4j
@Component("work")
public class Work {

    public void beforeWork() {
        log.info("Execute before work");
    }

    public void afterWork() {
        log.info("Execute after work");
    }

    public void afterWorkProblems() {
        log.info("Execution problems");
    }

    public void aroundWork(ProceedingJoinPoint
                                   joinPoint) {
        try {
            log.info("Start");
            long start = System.nanoTime();
            String result =
                    (String) joinPoint.proceed();
            long finish = System.nanoTime();
            log.info("Finish time: {}",
                    finish - start);
            log.info("Status: {}", result);
        } catch (Throwable t) {
            log.error("ERROR", t);
        }
    }
}