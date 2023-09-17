package org.example;

import java.util.*;

public class GroupAnagrams {

    /**
     *  M  string length
     *  N  strings counts
     *  Time complexity O(M*Log(M)*N)
     *  Space complexity O(M+N)
     *  my coding style
     * */
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> hashMap = new HashMap<>();
        int i = 0;
        while (i < strs.length) {
            char[] charArray = strs[i].toCharArray();
            Arrays.sort(charArray);
            if (hashMap.containsKey(Arrays.toString(charArray))) {
                List<String> strings = hashMap.get(Arrays.toString(charArray));
                strings.add(strs[i]);
                hashMap.put(Arrays.toString(charArray), strings);
            } else {
                List<String> strings = new ArrayList<>();
                strings.add(strs[i]);
                hashMap.put(Arrays.toString(charArray), strings);
            }
            i++;
        }

        List<List<String>> lists = new ArrayList<>();
        for (Map.Entry<String, List<String>> entry : hashMap.entrySet()) {
            lists.add(entry.getValue());
        }

        return lists;
    }

    /**
     *  M  string length
     *  N  strings counts
     *  Time complexity O(M*Log(M)*N)
     *  Space complexity O(M+N)
     *  Answer from Leetcode website
     * */
    public List<List<String>> groupAnagrams2(String[] strs) {
        HashMap<String, List<String>> hashMap = new HashMap<>();
        for (String str : strs) {
            char[] charArray = str.toCharArray();
            Arrays.sort(charArray);
            String sortingWord = new String(charArray);
            if (!hashMap.containsKey(sortingWord)) {
                hashMap.put(sortingWord, new ArrayList<>());
            }
            hashMap.get(sortingWord).add(str);
        }

        return new ArrayList<>(hashMap.values());
    }


    /**
     *  M  string length
     *  N  strings counts
     *  Time complexity O(M*N)
     *  Space complexity O(M+N)
     *  No need Sorting way
     * */
    public List<List<String>> groupAnagrams3(String[] strs) {
        HashMap<String, List<String>> hashMap = new HashMap<>();
        for (String str : strs) {
            char[] charArray = str.toCharArray();
            char[] charKey = new char[26];
            for (char c : charArray) {
               int index = c - 'a';
               charKey[index]++;
            }

            String sortingWord = new String(charKey);
            if (!hashMap.containsKey(sortingWord)) {
                hashMap.put(sortingWord, new ArrayList<>());
            }
            hashMap.get(sortingWord).add(str);
        }

        return new ArrayList<>(hashMap.values());
    }




}
