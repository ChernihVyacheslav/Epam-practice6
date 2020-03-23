package ua.nure.chernykh.practice6.part1;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;

public class Part1 {

    private static final InputStream STD_IN = System.in;
    private static final String ENCODING = "Cp1251";

    public static void main(String[] args) {
        String input = "asd 43 asdf asd 43\n" +
                "434 asdf\n" +
                "kasdf asdf stop asdf\n" +
                "stop";
        try {
            System.setIn(new ByteArrayInputStream(input.getBytes(ENCODING)));
        } catch (UnsupportedEncodingException e) {
            System.out.println(e.getMessage());
        }
        WordContainer.main(null);
        System.setIn(STD_IN);
    }
}
