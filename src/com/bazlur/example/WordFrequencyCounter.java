package com.bazlur.example;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class WordFrequencyCounter {

    public static void main(String[] args) {

        List<String> words = Arrays.asList("Hello",
                "World",
                "Bangladesh",
                "Dhaka", "Hello", "Java", "Lambda");

        Map<String, Long> map = countFrequency(words);

        System.out.println(map);
    }

    static Map<String, Long> countFrequency(List<String> words) {
        Map<String, Long> frequencyMap = new HashMap<>();

        for (String word : words) {
            if (!frequencyMap.containsKey(word)) {
                frequencyMap.put(word, 0L);
            }
            Long odlCount = frequencyMap.get(word);
            frequencyMap.put(word, odlCount + 1);
        }

        return frequencyMap;
    }

    static Map<String, Long> countFrequencyWithFunctionalApproach(List<String> words) {

        return words.stream()
               .collect(Collectors.groupingBy(s -> s, Collectors.counting()));
    }
}
