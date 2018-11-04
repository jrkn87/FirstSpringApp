package pl.duhc.springstart.domain;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Knight {

    @Value("${knight.name}")
    private String name;
    @Value("${knight.age}")
    private int age;

    private Quest quest;

    public Knight() {

    }

    public Knight(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Autowired
    public void setQuest(Quest quest) {
        this.quest = quest;
    }

    @Override
    public String toString() {
        return "rycerz o imieniu " + name.toUpperCase() + "( " + age + " ). Aktualne zadanie: " + quest;
    }
}
