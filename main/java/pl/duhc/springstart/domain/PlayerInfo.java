package pl.duhc.springstart.domain;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;

import java.util.Random;

@Component
//@Scope(value = "session", proxyMode = ScopedProxyMode.TARGET_CLASS)
public class PlayerInfo {

    private int goldValue = 0;

    public int getGoldValue() {
        return goldValue;
    }

    public void setGoldValue(int goldValue) {
        this.goldValue = goldValue;
    }
}
