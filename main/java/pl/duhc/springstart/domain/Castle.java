package pl.duhc.springstart.domain;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

//@Component
//@PropertySource("classpath:castle.properties")
public class Castle {

    //@Value("${castle.name}")
    private String name;

    Knight knight;

    //@Autowired
    public Castle(Knight knight) {
        this.knight = knight;
    }

    Castle(Knight knight, String name) {
        this.knight = knight;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Zamek " + name + " Wita!\nZamek obecnie zamieszkuję " + knight;
    }

    public void setName(String name) {
        this.name = name;
    }

    //@PostConstruct
    public void init() {
        System.out.println("Create object >> " + name);
    }

    //@PreDestroy
    public void tearDown() {
        System.out.println("Destroy object >> " + name);
    }
}
