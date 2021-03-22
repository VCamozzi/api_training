package fr.esiea.ex4A.Controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import fr.esiea.ex4A.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.mockito.Mockito.any;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK)
@AutoConfigureMockMvc
class UserControllerIT {

    private final MockMvc mockMvc;

    UserControllerIT(@Autowired MockMvc mockMvc) {
        this.mockMvc = mockMvc;
    }

    @Test
    void addUser() throws Exception {
        User user = new User("matteo", "matteo@et.esiea.fr", "allomsquintero", "FR", "M", "F");
        ObjectMapper mapper = new ObjectMapper();
        String result = mapper.writeValueAsString(user);
        mockMvc
            .perform(MockMvcRequestBuilders.post("/api/inscription").contentType(MediaType.APPLICATION_JSON_VALUE).content(result))
            .andExpect(status().isOk())
            .andExpect(content().string("OK"));
    }

    @Test
    void matchSearch() {
        
    }
}
