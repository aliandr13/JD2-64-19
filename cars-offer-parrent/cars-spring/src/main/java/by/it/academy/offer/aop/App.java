package by.it.academy.offer.aop;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@Slf4j
public class App {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring-context.xml");
        TaskService taskService = (TaskService) context.getBean("taskService");
        taskService.performJob();
        taskService.performJobAround();
    }
}

