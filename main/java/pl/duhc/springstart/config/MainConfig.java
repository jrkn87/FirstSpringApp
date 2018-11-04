package pl.duhc.springstart.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.annotation.PropertySource;
import pl.duhc.springstart.domain.Castle;
import pl.duhc.springstart.domain.Knight;
import pl.duhc.springstart.domain.Quest;

@Configuration
//@ImportResource("classpath:config/castle-config.xml")
@PropertySource("classpath:castle.properties")
public class MainConfig {

    @Bean
    public Quest createQuest() {
        return new Quest();
    }

    @Bean
    public Knight createKnight() {
        Knight knight = new Knight("Lucek", 35);
        knight.setQuest(createQuest());
        return knight;
    }

    @Bean(name = "castle", initMethod = "init", destroyMethod = "tearDown")
    @Value("${castle.name:BUAHAHAH}")
    public Castle castle(String name) {
        Castle castle = new Castle(createKnight());
        castle.setName(name);
        return castle;
    }
}
