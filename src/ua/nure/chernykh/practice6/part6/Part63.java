package ua.nure.chernykh.practice6.part6;

import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class Part63 {

    private Part63() {
    }

    public static void duplicate(String input) {
        List<String> words = new LinkedList<>();
        Pattern p = Pattern.compile("(?s)\\b([a-zA-Z]+)\\b(?:.*\\1\\b)+");
        Matcher m = p.matcher(input);
        while (m.find() && words.size() < 3) {
            words.add(m.group(1));
            input = input.replaceAll(m.group(1), "");
            m = p.matcher(input);
        }
        for (int i = 0; i < 3 || i < words.size(); i++) {
            System.out.println(new StringBuilder(words.get(i).toUpperCase(Locale.ENGLISH)).reverse());
        }
    }

}
