package com.alhata.leetcode.string;

import java.util.ArrayList;
import java.util.List;

/**
 * We are building a word processor and we would like to implement a "reflow" functionality that also applies full justification to the text.
 * Given an array containing lines of text and a new maximum width, re-flow the text to fit the new width. Each line should have the exact specified width. If any line is too short, insert '-' (as stand-ins for spaces) between words as equally as possible until it fits.
 * Note: we are using '-' instead of spaces between words to make testing and visual verification of the results easier.
 */
public class KaratWordWrapWithBalance {
    public static void main(String[] args) {
        String sentence = "We are building a word processor and we would like to implement a reflow functionality that also " +
                "applies full justification to the text Given an array containing lines of text and a new maximum width " +
                "re-flow the text to fit the new width";

        for (String line : wrapWordInBalance(sentence, 20)) {
            System.out.println(line);
        }
//        System.out.println(balanceOneLine(new StringBuilder("justification-to-the"), 20));
    }

    private static List<String> wrapWordInBalance(String sentence, int maxLength) {
        if(sentence == null || sentence.length() == 0 || maxLength <= 0) {
            return null;
        }
        List<String> lines = new ArrayList<>();
        String[] words = sentence.split(" ");
        StringBuilder stringBuilder = new StringBuilder();
        for (String word : words) {
            if(stringBuilder.length() == 0) {
                if(word.length() <= maxLength) stringBuilder.append(word);
            } else if(stringBuilder.length() + 1 + word.length() <= maxLength) {
                stringBuilder.append("-").append(word);
            } else {
                lines.add(balanceOneLine(stringBuilder, maxLength));
                stringBuilder.setLength(0);
                if (word.length() <= maxLength) stringBuilder.append(word);
            }
        }

        if(stringBuilder.length() > 0) lines.add(balanceOneLine(stringBuilder, maxLength));
        return lines;
    }

    private static String balanceOneLine(StringBuilder line, int maxLength) {
        if(!line.toString().contains("-")) return line.toString();
        int i = 0;
        while (line.length() < maxLength) {

            if(i+1 < line.length() && line.charAt(i) == '-' && line.charAt(i+1) != '-') {
                line.insert(i, '-');
                i++;
            }
            i++;

            if(i + 1 == line.length()) {
                i = 0;
            }
        }

        return line.toString();
    }
}
