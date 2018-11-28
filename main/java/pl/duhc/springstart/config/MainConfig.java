package pl.duhc.springstart.config;

import org.springframework.context.annotation.*;
import pl.duhc.springstart.domain.repository.KnightRepository;
import pl.duhc.springstart.domain.repository.KnightRepository_DB;
import pl.duhc.springstart.domain.repository.KnightRepository_InMemory;

@Configuration
//@ImportResource("classpath:config/castle-config.xml")
//@PropertySource("classpath:castle.properties")
public class MainConfig {

    @Bean
    @Profile("dev")
    public KnightRepository createInMemory() {
        KnightRepository knightRepository = new KnightRepository_InMemory();
        return knightRepository;
    }

    @Bean
    @Profile("prod")
    public KnightRepository createDB() {
        KnightRepository knightRepository = new KnightRepository_DB();
        return knightRepository;
    }

}
