package pl.duhc.springstart.domain;

import org.springframework.stereotype.Component;

@Component
public class Knight {

    private String name;
    private int age;

    private Quest quest;

    public Knight() {
        this.name = "Lancelot";
        this.age = 29;    }

    public Knight(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public void setQuest(Quest quest) {
        this.quest = quest;
    }

    @Override
    public String toString() {
        return "Rycerz o Imieniu " + name.toUpperCase() + "( " + age + " ). Zadanie rycerza to: " + quest;
    }
}
