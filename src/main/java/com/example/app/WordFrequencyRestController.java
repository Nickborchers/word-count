package com.example.app;

import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api")
public class WordFrequencyRestController {

    private final WordFrequencyAnalyzer analyzer = new WordFrequencyAnalyzer();

    @GetMapping("/highest")
    public int calculateHighestFrequency(@RequestParam String text) {
        return analyzer.calculateHighestFrequency(text);
    }

    @GetMapping("/frequency")
    public int calculateFrequencyForWord(@RequestParam String text, @RequestParam String word) {
        return analyzer.calculateFrequencyForWord(text, word);
    }

    @GetMapping("/most-frequent")
    public List<WordFrequency> calculateMostFrequentNWords(@RequestParam String text, @RequestParam int n) {
        return analyzer.calculateMostFrequentNWords(text, n);
    }
}