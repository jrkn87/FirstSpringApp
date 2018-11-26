package pl.duhc.springstart.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Entity
public class Quest {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String description;
    private int reward = 100;
    private int questLenght = 30;
    boolean started = false;
    boolean complited = false;
    protected LocalDateTime startQuest;
    protected LocalDateTime questDateEnd;
    private Long date;

    public Quest() {

    }

    public Quest(int id, String description) {
        this.id = id;
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getReward() {
        return reward;
    }

    public void setReward(int reward) {
        this.reward = reward;
    }

    public int getQuestLenght() {
        return questLenght;
    }

    public void setQuestLenght(int questLenght) {
        this.questLenght = questLenght;
    }

    public boolean isStarted() {
        return started;
    }

    public void setStarted(boolean started) {
        if (started) {
            this.startQuest = LocalDateTime.now();
        }
        this.started = started;
    }

    public boolean isComplited() {
        if (this.complited) {
            return this.complited;
        } else {
            LocalDateTime now = LocalDateTime.now();
            LocalDateTime questTime = this.startQuest.plusSeconds(this.questLenght);
            boolean isAfter = now.isAfter(questTime);
            if (isAfter)
                this.complited = true;
            else
                this.complited = false;
        }
        return complited;
    }

    public LocalDateTime getQuestDateEnd() {
        return startQuest.plusSeconds(questLenght);
    }

    public Long getDate() {
        return date + 30000;
    }

    public void setDate(Long date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return description;
    }
}
