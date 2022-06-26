package com.alhata.leetcode.company.indeed;

import java.util.ArrayList;
import java.util.List;

/**
 * given a string list and max length, link all the words with '-' to form a line but do bot exceed the maxLength,
 * output the lines
 * Time: O(n) - n is the word count of the sentence
 * Space: O(n) - n is the word count of the sentence
 */
public class KaratWordWrap {
    public static void main(String[] args) {
        String sentence = "We are building a word processor and we would like to implement a reflow functionality that also " +
                "applies full justification to the text Given an array containing lines of text and a new maximum width " +
                "re-flow the text to fit the new width";
        for (String line : wrapWordsToLines(sentence, 20)) {
            System.out.println(line);
        }
    }

    private static List<String> wrapWordsToLines(String sentence, int maxLength) {
        if (sentence == null || sentence.length() == 0 || maxLength <= 0) {
            return null;
        }

        List<String> lines = new ArrayList<>();
        String[] words = sentence.split(" ");
        StringBuilder stringBuilder = new StringBuilder();
        for (String word : words) {
            if (stringBuilder.length() == 0) {
                if (word.length() < maxLength) stringBuilder.append(word);
            }else if(word.length() + 1 + stringBuilder.length() <= maxLength){
                stringBuilder.append("-").append(word);
            } else {
                lines.add(stringBuilder.toString());
                stringBuilder.setLength(0);
                if (word.length() < maxLength) stringBuilder.append(word);
            }
        }

        //last line if exists
        if(stringBuilder.length() != 0) {
            lines.add(stringBuilder.toString());
        }
        return lines;
    }
}
