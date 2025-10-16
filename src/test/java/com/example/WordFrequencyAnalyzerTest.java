package com.example;

import com.example.app.WordFrequencyAnalyzer;
import com.example.app.WordFrequency;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import java.util.List;

public class WordFrequencyAnalyzerTest {

    private final WordFrequencyAnalyzer analyzer = new WordFrequencyAnalyzer();

    @Test
    public void testCalculateHighestFrequency() {
        String text = "I would like to work at Sopra Steria, and I would like to learn and grow.";
        int highest = analyzer.calculateHighestFrequency(text);
        assertEquals(2, highest);
    }

    @Test
    public void testCalculateHighestFrequencyEmpty() {
        String text = "           ";
        int highest = analyzer.calculateHighestFrequency(text);
        assertEquals(0, highest);
    }

    @Test
    public void testCalculateFrequencyForWord() {
        String text = "The sun shines over the lake";
        int freq = analyzer.calculateFrequencyForWord(text, "The");
        assertEquals(2, freq);

        freq = analyzer.calculateFrequencyForWord(text, "the");
        assertEquals(2, freq);

        freq = analyzer.calculateFrequencyForWord(text, "sun");
        assertEquals(1, freq);

        freq = analyzer.calculateFrequencyForWord(text, "meer");
        assertEquals(0, freq);
    }

    @Test
    public void testCalculateMostFrequentNWords() {
        String text = "The sun shines over the lake";
        List<WordFrequency> result = analyzer.calculateMostFrequentNWords(text, 3);

        assertEquals(3, result.size());
        assertEquals("the", result.get(0).getWord());
        assertEquals(2, result.get(0).getFrequency());
        assertEquals("lake", result.get(1).getWord());
        assertEquals(1, result.get(1).getFrequency());
        assertEquals("over", result.get(2).getWord());
        assertEquals(1, result.get(2).getFrequency());
    }

    @Test
    public void testEmptyText() {
        String text = "";
        assertEquals(0, analyzer.calculateHighestFrequency(text));
        assertEquals(0, analyzer.calculateFrequencyForWord(text, "any"));
        assertTrue(analyzer.calculateMostFrequentNWords(text, 5).isEmpty());
    }

    @Test
    public void testCaseInsensitive() {
        String text = "Lorem loreM LoReM LOREM";
        assertEquals(4, analyzer.calculateFrequencyForWord(text, "lorem"));
    }
}