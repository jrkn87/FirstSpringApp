package pl.duhc.springstart.domain;

public class Knight {

    private String name;
    private int age;

    private Quest quest;

    public Knight() {
        this.name = "Lucjan";
        this.age = 52;
    }

    public Knight(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public void setQuest(Quest quest) {
        this.quest = quest;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    @Override
    public String toString() {
        return "rycerz o imieniu " + name.toUpperCase() + "( " + age + " ). Aktualne zadanie: " + quest;
    }
}
