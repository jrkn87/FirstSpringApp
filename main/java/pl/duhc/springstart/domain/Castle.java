package pl.duhc.springstart.domain;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Component
public class Castle {

    private String name = "EAST WATCH";

    public Castle() {

    }

    @Override
    public String toString() {
        return "Zamek " + name + " Wita!";
    }

    @PostConstruct
    public void init() {
        System.out.println("Create object >> " + name);
    }

    @PreDestroy
    public void tearDown() {
        System.out.println("Destroy object >> " + name);
    }
}
