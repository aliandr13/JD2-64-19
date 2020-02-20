package by.it.academy.offer.Homework;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@Slf4j
public class App {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.register(NoXMLConfiguration.class);
        context.refresh();
        context.start();

        PersonService service = context.getBean(PersonService.class);

        log.info("Person service getName: {}", service.getPersonName());

        context.close();
    }


}
