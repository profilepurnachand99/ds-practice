package com.practice.javacode.strings;

import java.util.*;
import java.util.stream.Collectors;

public class GroupAnagrams {
    public static void main(String[] args) {
        String[] words = {"eat", "tea", "tan", "ate", "nat", "bat"};
        System.out.println(groupAnagrams_NoSorting(words));
    }

    public static List<List<String>> groupAnagrams_Sorting(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for (String s : strs) {
            char[] chars = s.toCharArray();
            Arrays.sort(chars);
            String key = new String(chars); // sorted string
            map.computeIfAbsent(key, k -> new ArrayList<>()).add(s);
        }
        return new ArrayList<>(map.values());
    }

    public static List<List<String>> groupAnagrams_NoSorting(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for (String s : strs) {
            int[] count = new int[26];
            for (char c : s.toCharArray()) {
                count[c - 'a']++;
            }
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < 26; i++) {
                if (count[i] > 0) {
                    sb.append((char) (i + 'a')).append(count[i]);
                }
            }
            String key = sb.toString();
            map.computeIfAbsent(key, k -> new ArrayList<>()).add(s);
        }
        return new ArrayList<>(map.values());
    }

    public static List<List<String>> groupAnagrams_Streams(String[] strs) {
        return Arrays.stream(strs)
                .collect(Collectors.groupingBy(
                        s -> {
                            char[] chars = s.toCharArray();
                            Arrays.sort(chars);
                            return new String(chars);
                        }
                ))
                .values()
                .stream()
                .collect(Collectors.toList());
    }

}
