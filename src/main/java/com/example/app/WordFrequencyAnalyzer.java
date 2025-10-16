package com.example.app;

import java.util.*;

public class WordFrequencyAnalyzer implements IWordFrequencyAnalyzer {

    @Override
    public int calculateHighestFrequency(String text) {
        Map<String, Integer> histogram = getHistogram(text);
        return histogram.values().stream().max(Integer::compareTo).orElse(0);
    }

    @Override
    public int calculateFrequencyForWord(String text, String word) {
        Map<String, Integer> histogram = getHistogram(text);

        return histogram.getOrDefault(word.toLowerCase(), 0);
    }

    @Override
    public List<WordFrequency> calculateMostFrequentNWords(String text, int n) {
        Map<String, Integer> histogram = getHistogram(text);

        List<WordFrequency> result = new ArrayList<>();
        histogram.forEach((word, freq) -> result.add(new WordFrequency(word, freq)));

        // Sort the result by frequency desc, then by word asc
        return result.stream()
                .sorted(Comparator.comparing(WordFrequency::getFrequency).reversed()
                        .thenComparing(WordFrequency::getWord))
                .limit(n)
                .toList();
    }

    private Map<String, Integer> getHistogram(String text) {
        HashMap<String, Integer> histogram = new HashMap<>();
        String[] split = text.split("\\W+");
        for (String word : split) {
            if (word.isEmpty()) continue;
            histogram.put(word.toLowerCase(), histogram.getOrDefault(word.toLowerCase(), 0) + 1);
        }
 
        return histogram;
    }
}