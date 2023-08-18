package E10_ExamPreparation_01;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

// https://judge.softuni.org/Contests/Practice/Index/2307#1

public class E02MirrorWords {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String text = scanner.nextLine();

        String regex = "(@|#)(?<first>[A-Za-z]{3,})\\1{2}(?<second>[A-Za-z]{3,})\\1";

        Pattern pattern = Pattern.compile(regex);

        Matcher matcher = pattern.matcher(text);

        List<String> pairs = new ArrayList<>();

        int count = 0;

        while (matcher.find()) {

            count++;

            String firstWord = matcher.group("first");
            String secondWord = matcher.group("second");

            StringBuilder secondWordBiulder = new StringBuilder(secondWord);
            String reversedSecondWord = secondWordBiulder.reverse().toString();

            if (firstWord.equals(reversedSecondWord)) {
                pairs.add(firstWord + " <=> " + secondWord);
            }


        }


        if (count == 0) {
            System.out.println("No word pairs found!");
        } else {
            System.out.printf("%s word pairs found!%n", count);
        }

        if (pairs.isEmpty()) {
            System.out.println("No mirror words!");
        } else {
            System.out.println("The mirror words are:");
            System.out.println(String.join(", ", pairs));
        }


    }
}
