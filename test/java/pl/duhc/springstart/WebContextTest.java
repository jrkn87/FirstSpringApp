package pl.duhc.springstart;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import pl.duhc.springstart.components.TimeComponent;
import pl.duhc.springstart.controllers.QuestController;
import pl.duhc.springstart.domain.Knight;
import pl.duhc.springstart.domain.PlayerInfo;
import pl.duhc.springstart.domain.Quest;
import pl.duhc.springstart.services.KnightService;
import pl.duhc.springstart.services.QuestService;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

@RunWith(SpringRunner.class)
@SpringBootTest
public class WebContextTest {

    @Mock
    KnightService knightService;

    @Mock
    QuestService questService;

    @Mock
    TimeComponent timeComponent;

    @Mock
    PlayerInfo playerInfo;

    @InjectMocks
    QuestController questController;

    private MockMvc mockMvc;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(questController).build();
    }

    @Test
    public void checkQuestTest() throws Exception {

        mockMvc.perform(get("/check"))
        .andExpect(status().is3xxRedirection())
        .andExpect(view().name("redirect:/knights"));
    }

    @Test
    public void contextLoads() {
    }


}
