package ua.nure.chernykh.practice6.part1;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class WordContainer extends LinkedList {

    private static final long serialVersionUID = 1;
    private static final String ENCODING = "Cp1251";

    private transient List<Word> words;

    public WordContainer() {
        this.words = new LinkedList<>();
    }

    public void add(Word word) {
        if (word != null) {
            Word tempWord = getWordByContent(word.getContent());
            if (tempWord != null) {
                tempWord.incFrequency();
            } else {
                words.add(word);
            }
        }
        Collections.sort(words);
    }

    @Override
    public Object get(int index) {
        return words.get(index);
    }

    private Word getWordByContent(String content) {
        for (Word word : words) {
            if (word.getContent().equals(content)) {
                return word;
            }
        }
        return null;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Word word : words) {
            sb.append(word).append(" : ").append(word.getFrequency()).append(System.lineSeparator());
        }
        sb.delete(sb.length() - 1, sb.length());
        return sb.toString();
    }

    @Override
    public int size() {
        return words.size();
    }

    @Override
    public boolean equals(Object o) {
        return super.equals(o);
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    public static void main(String[] args) {
        WordContainer wc = new WordContainer();
        Scanner sc = new Scanner(System.in, ENCODING);
        String text;
        while (true) {
            text = sc.next();
            if ("stop".equals(text)) {
                break;
            } else {
                wc.add(new Word(text));
            }
        }
        System.out.println(wc);
    }

}
