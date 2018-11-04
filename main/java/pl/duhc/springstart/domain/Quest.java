package pl.duhc.springstart.domain;

import org.springframework.stereotype.Component;

//@Component
public class Quest {

    private String description;

    public Quest() {
        this.description = "Uratuj Księżniczkę!";
    }

    @Override
    public String toString() {
        return description;
    }
}
