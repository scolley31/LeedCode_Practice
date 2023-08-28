package org.example;

import java.util.HashMap;

public class RomanToInteger {


    /**
     * Time complexity O(n)
     * Space complexity O(n)
     * Brute Force
     */
    public int romanToInt1(String s) {
        char[] chars = s.toCharArray();
        int sums = 0;
        for (int i = 0; i < chars.length; i++) {
            switch (chars[i]) {
                case 'I' -> {
                    if (i + 1 < chars.length) {
                        if (chars[i + 1] == 'V') {
                            sums += 4;
                            i++;
                            break;
                        } else if (chars[i + 1] == 'X') {
                            sums += 9;
                            i++;
                            break;
                        }
                    }
                    sums += 1;
                }
                case 'V' -> sums += 5;
                case 'X' -> {
                    if (i + 1 < chars.length) {
                        if (chars[i + 1] == 'L') {
                            sums += 40;
                            i++;
                            break;
                        } else if (chars[i + 1] == 'C') {
                            sums += 90;
                            i++;
                            break;
                        }
                    }
                    sums += 10;
                }
                case 'L' -> sums += 50;
                case 'C' -> {
                    if (i + 1 < chars.length) {
                        if (chars[i + 1] == 'D') {
                            sums += 400;
                            i++;
                            break;
                        } else if (chars[i + 1] == 'M') {
                            sums += 900;
                            i++;
                            break;
                        }
                    }
                    sums += 100;
                }
                case 'D' -> sums += 500;
                case 'M' -> sums += 1000;

            }
        }
        return sums;
    }


    /**
     * Time complexity O(n)
     * Space complexity O(n)
     * HashTable
     */
    public int romanToInt2(String s) {
        int sum = 0;
        HashMap<Character, Integer> map = new HashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);

        int index = s.length() - 2;
        sum = sum + map.get(s.charAt(index + 1));
        while (index >= 0) {
            if (map.get(s.charAt(index)) < map.get(s.charAt(index + 1))) {
                sum -= map.get(s.charAt(index));
            } else {
                sum += map.get(s.charAt(index));
            }
            index--;
        }

        return sum;
    }

}
