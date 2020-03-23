package ua.nure.chernykh.practice6.part6;

import ua.nure.chernykh.practice6.part1.Word;
import ua.nure.chernykh.practice6.part1.WordContainer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class Part61 {

    private Part61() {
    }

    public static void frequency(String input) {
        WordContainer wc = new WordContainer();
        Pattern p = Pattern.compile("[a-zA-Z]+");
        Matcher m = p.matcher(input);
        while (m.find()) {
            wc.add(new Word(m.group()));
        }
        ArrayList<String> stringArrayList = new ArrayList<>();
        for (int i = 0; i < wc.size(); i++) {
            Word word = (Word) wc.get(i);
            if (i >= 3 && ((Word) wc.get(i - 1)).getFrequency() > word.getFrequency()) {
                break;
            }
            stringArrayList.add(String.format("%s ==> %s", word, word.getFrequency()));
        }
        Collections.sort(stringArrayList, (String s1, String s2) -> {
            int compare = s1.substring(s1.length() - 1).compareTo(s2.substring(s2.length() - 1));
            if (compare != 0) {
                return -compare;
            } else {
                return input.indexOf(s1.split(" ")[0]) - input.indexOf(s2.split(" ")[0]);
            }
        });
        ArrayList<String> arr = new ArrayList<>(3);
        for (int i = 0; i < 3; i++) {
            arr.add(stringArrayList.get(i));
        }
        Collections.sort(arr, Collections.reverseOrder());
        for (String s : arr) {
            System.out.println(s);
        }
    }

}
