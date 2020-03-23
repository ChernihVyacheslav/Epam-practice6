package ua.nure.chernykh.practice6.part6;

import java.util.LinkedList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class Part62 {

    private Part62() {

    }

    public static void length(String input) {
        List<String> words = new LinkedList<>();
        Pattern p = Pattern.compile("[a-zA-Z]+");
        Matcher m = p.matcher(input);
        while (m.find()) {
            if (!words.contains(m.group())) {
                words.add(m.group());
            }
        }
        words.sort((s1, s2) -> s2.length() - s1.length());
        for (int i = 0; i < 3; i++) {
            String word = words.get(i);
            System.out.printf("%s ==> %s%n", word, word.length());
        }
    }

}
