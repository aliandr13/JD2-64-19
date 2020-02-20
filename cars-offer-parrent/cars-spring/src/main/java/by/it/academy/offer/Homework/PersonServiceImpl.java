package by.it.academy.offer.Homework;


import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Slf4j
@Service
public class PersonServiceImpl implements PersonService {

    private final Person person;

    @Autowired
    public PersonServiceImpl(Person person) {
        this.person = person;
    }

    @Override
    public String getPersonName() {
        return person.getName();
    }

    @PostConstruct
    public void init() {
        log.info("Person Service Post construct");
    }

    @PreDestroy
    public void close() {
        log.info("Person Service Per Destroy");
    }

}
