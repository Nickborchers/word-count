package com.example.app;

import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/word-frequency")
public class WordFrequencyRestController {

    private final WordFrequencyAnalyzer analyzer = new WordFrequencyAnalyzer();

    @GetMapping("/highest")
    public int calculateHighestFrequency(@RequestParam("text") String text) {
        return analyzer.calculateHighestFrequency(text);
    }

    @GetMapping("/frequency")
    public int calculateFrequencyForWord(@RequestParam("text") String text, @RequestParam("word") String word) {
        return analyzer.calculateFrequencyForWord(text, word);
    }

    @GetMapping("/most-frequent")
    public List<WordFrequency> calculateMostFrequentNWords(@RequestParam("text") String text, @RequestParam("n") int n) {
        return analyzer.calculateMostFrequentNWords(text, n);
    }
}