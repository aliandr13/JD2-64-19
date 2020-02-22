package by.it.academy.offer.aspects;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@Slf4j
public class App {

    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("beans-annotation.xml");
        TaskService bean = (TaskService) applicationContext.getBean("taskService");
        bean.performJob("Spring");
        bean.performJob();
        bean.performJobAround();
        try {
            bean.performExceptionJob();
        } catch (Exception e) {
            log.error(String.valueOf(e));
        }
        ((ClassPathXmlApplicationContext) applicationContext).close();
    }
}

