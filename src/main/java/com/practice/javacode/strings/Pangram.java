package com.practice.javacode.strings;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class Pangram {
    public static void main(String[] args) {
        String sentence = "The quick brown fox jumps over the lazy dog";
        System.out.println(isPangram1(sentence));
        System.out.println(isPangram2(sentence));
    }

    public static boolean isPangram1(String sentence) {
        Set<Character> set = new HashSet<>();
        for (char c : sentence.toLowerCase().toCharArray()) {
            if (c >= 'a' && c <= 'z') {
                set.add(c);
            }
        }
        return set.size() == 26; //all letters present
    }

    public static boolean isPangram2(String sentence) {
        return sentence.toLowerCase()
                .chars() // IntStream of characters
                .filter(Character::isLetter) // keep only letters
                .mapToObj(c -> (char) c) // convert to Character
                .collect(Collectors.toSet()) // unique letters
                .size() == 26; // must have all 26 letters
    }
}
