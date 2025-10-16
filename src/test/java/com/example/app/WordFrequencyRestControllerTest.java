package com.example.app;

import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import org.junit.jupiter.api.Test;

@SpringBootTest
@AutoConfigureMockMvc
public class WordFrequencyRestControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testCalculateHighestFrequency() throws Exception {
        this.mockMvc.perform(get("/api/word-frequency/highest")
                .param("text", "The sun shines over the lake"))
                .andExpect(status().isOk())
                .andExpect(content().string("2"));
    }

    @Test
    public void testCalculateFrequencyForWord() throws Exception {
        mockMvc.perform(get("/api/word-frequency/frequency")
                .param("text", "The sun shines over the lake")
                .param("word", "the"))
                .andExpect(status().isOk())
                .andExpect(content().string("2"));
    }

    @Test
    public void testCalculateMostFrequentNWords() throws Exception {
        mockMvc.perform(get("/api/word-frequency/most-frequent")
                .param("text", "The sun shines over the lake")
                .param("n", "3"))
                .andExpect(status().isOk())
                .andExpect(content().string("[{\"word\":\"the\",\"frequency\":2},{\"word\":\"lake\",\"frequency\":1},{\"word\":\"over\",\"frequency\":1}]"));
    }
}