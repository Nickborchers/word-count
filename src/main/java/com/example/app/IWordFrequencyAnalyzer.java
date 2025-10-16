package com.example.app;

import java.util.List;

public interface IWordFrequencyAnalyzer {
    int calculateHighestFrequency(String text);
    int calculateFrequencyForWord (String text, String word);
    List<WordFrequency> calculateMostFrequentNWords (String text, int n);
}