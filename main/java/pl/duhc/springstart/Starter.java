package pl.duhc.springstart;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import pl.duhc.springstart.domain.Castle;
import pl.duhc.springstart.domain.Knight;

@Component
public class Starter implements CommandLineRunner {

    @Autowired
    Castle castle;

    @Autowired
    Knight knight;

    @Override
    public void run(String... args) throws Exception {
        System.out.println(castle);
    }
}
