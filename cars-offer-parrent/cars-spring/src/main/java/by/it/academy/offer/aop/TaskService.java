package by.it.academy.offer.aop;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service("taskService")
public class TaskService {

    public void performJob() {
        log.info("Perform Job");
    }

    public void performExceptionJob() throws Exception {
        log.info("Throws exception in Job");
        throw new Exception("Exception JOB");
    }

    public String performJobAround() {
        log.info("Job around job");
        return "SUCCESS";
    }

}
