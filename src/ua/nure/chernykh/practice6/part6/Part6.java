package ua.nure.chernykh.practice6.part6;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class Part6 {

    private static final int ARGSNUMBER = 4;
    private static final int ARGSINCR = 2;
    private static final String ENCODING = "Cp1251";

    private static String readFile(String filepath) {
        try (BufferedReader bufferedReader = new BufferedReader(
                new InputStreamReader(new FileInputStream(filepath), ENCODING))) {
            String line;
            StringBuilder sb = new StringBuilder();
            while ((line = bufferedReader.readLine()) != null) {
                sb.append(line);
                sb.append(System.lineSeparator());
            }
            return sb.toString();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
        return null;
    }

    public static void main(String[] args) {
        if(args.length == ARGSNUMBER) {
            String input = "";
            String task = "";
            for(int i = 0; i < args.length; i+=ARGSINCR) {
                switch (args[i]) {
                    case "-i":
                    case "--input":
                        input = readFile(args[i + 1]);
                        break;
                    case "-t":
                    case "--task":
                        task = args[i + 1];
                        break;
                    default:
                        System.out.println("Invalid args");
                }
            }
            switch (task) {
                case "frequency":
                    Part61.frequency(input);
                    break;
                case "length":
                    Part62.length(input);
                    break;
                case "duplicates":
                    Part63.duplicate(input);
                    break;
                default:
                    System.out.println("Invalid task");
            }
        } else {
            System.out.println("Invalid args");
        }
    }
}
