package org.example;

public class MaximumScoreFromRemovingSubstrings {
    public int maximumGain(String s, int x, int y) {
        String top;
        int topScore;
        String bot;
        int botScore;
        int score = 0;

        if (x > y) {
            top = "ab";
            topScore = x;
            bot = "ba";
            botScore = y;
        } else {
            top = "ba";
            topScore = y;
            bot = "ab";
            botScore = x;
        }

        StringBuilder sb1 = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == top.charAt(1) && !sb1.isEmpty() && sb1.charAt(sb1.length() - 1) == top.charAt(0)) {
                score += topScore;
                sb1.setLength(sb1.length() - 1);
            } else {
                sb1.append(s.charAt(i));
            }
        }

        StringBuilder sb2 = new StringBuilder();
        for (int i = 0; i < sb1.length(); i++) {
            if (sb1.charAt(i) == bot.charAt(1) && !sb2.isEmpty() && sb2.charAt(sb2.length() - 1) == bot.charAt(0)) {
                score += botScore;
                sb2.setLength(sb2.length() - 1);
            } else {
                sb2.append(sb1.charAt(i));
            }
        }

        return score;
    }
}
