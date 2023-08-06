package com.demo.microservice.limitsservice;

import com.demo.microservice.limitsservice.configuration.LimitsConfiguration;
import com.demo.microservice.limitsservice.controller.LimitsController;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.TestConstructor;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@ExtendWith(SpringExtension.class)
@WebMvcTest(LimitsController.class)
@TestConstructor(autowireMode = TestConstructor.AutowireMode.ALL)
public class LimitControllerTest {

    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private LimitsConfiguration configuration;

    @Test
    public void call_api_get_limits_success() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders
                .get("/api/v1/limits")
                .accept(MediaType.APPLICATION_JSON)
        ).andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().json("""
                        {"minimum":0,"maximum":0}
                """.trim()
                ))
        ;
    }
}
