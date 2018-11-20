package pl.duhc.springstart.domain;

import org.hibernate.validator.constraints.Range;
import org.springframework.beans.factory.annotation.Autowired;
import pl.duhc.springstart.domain.repository.QuestRepository;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class Knight {

    @Autowired
    QuestRepository questRepository;

    private Integer id;

    @NotNull
    @Size(min = 3, max = 25)
    private String name;

    @NotNull
    @Range(min = 16, max = 39)
    private int age;

    private int level;

    private Quest quest;

    public Knight() {
        this.level = 1;
    }

    public Knight(String name, int age) {
        this.name = name;
        this.age = age;
        this.level = 1;
    }

    public void setQuest(Quest quest) {
        if (quest != null)
            quest.setStarted(true);
        this.quest = quest;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public Quest getQuest() {
        return quest;
    }

    @Override
    public String toString() {
        return "rycerz o imieniu " + name.toUpperCase() + "( " + age + " ). Aktualne zadanie: " + quest;
    }
}
