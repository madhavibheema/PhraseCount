/**
 *
 */
package com.newrelic.phrase;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class PhraseCount {

    //hyphen and apostrophe are allowed Eg- whale's and whale-ship
    public static final String WORD_PATTERN = "((\\w+'\\w+)|(\\w+-?\\w+)|(\\w+))";



    public static void main(String[] args) {
        if (args == null || args.length == 0) {
            readStdInFile();
        } else if (args != null && args.length > 0) {
            for (final String fileName : args) {
                readFile(fileName);

            }
        } else {
            System.out.println("No Arguments.");
        }
    }



    private static void printTopHundredPhrases(Map<String, Integer> phrases, String inputSource) {
        if (phrases.size() > 0) {
            System.out.println("Printing TOP 100 Phrases for :" + inputSource);
            System.out.println("Phrase #################################  " + "Frequency");

            phrases.entrySet()
                    .stream()
                    .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                    .limit(100)
                    .forEach(entry -> {
                        System.out.println(String.format("%-40s | %d",entry.getKey(), entry.getValue()));
                    });

        } else {
            System.out.println("None");
        }
    }


    private static void addPhrase(Map<String, Integer> phrases, String phrase) {
        Integer occurences = phrases.get(phrase);
        if( occurences == null) {
            phrases.put(phrase, 1);
        } else {
            phrases.put(phrase, phrases.get(phrase) + 1);
        }
    }


    private static String getPhrase(String word1, String word2, String word3) {
        StringBuilder phrase = new StringBuilder();
        return phrase.append(word1).append(" ").append(word2).append(" ").append(word3).toString();
    }


    public static List<String> getMatchesAsList(String line) {
        List<String> matches = new ArrayList<String>();
        Pattern p = Pattern.compile(WORD_PATTERN);
        Matcher m = p.matcher(line);
        while (m.find()) {
            matches.add(m.group().toLowerCase());
        }
        return matches;
    }


    public static void readStdInFile() {
        InputStreamReader isReader = new InputStreamReader(System.in);
        try (BufferedReader br = new BufferedReader(isReader)) {
            Map<String, Integer> phrases = processAllContent(br);

            // Output
            printTopHundredPhrases(phrases, "StdIn");
        } catch (IOException e) {
            System.err.println("No such file.");
            e.printStackTrace();
        }
    }


    public static void readFile(String fileName) {
        try (BufferedReader br = Files.newBufferedReader(Paths.get(fileName))) {
            Map<String, Integer> phrases = processAllContent(br);

            // Output
            printTopHundredPhrases(phrases, fileName);
        } catch (IOException e) {
            System.err.println("No such file.");
            e.printStackTrace();
        }
    }


    private static Map<String, Integer> processAllContent(BufferedReader br) throws IOException {
        Map<String, Integer> phrases = new HashMap<String, Integer>();

        String line = "";
        StringBuilder sb = new StringBuilder();
        while ((line = br.readLine()) != null) {
            sb.append(line).append("\n");
        }
        String contents = sb.toString().trim();

        List<String> matches = getMatchesAsList(contents);

        for (int i = 0; i < matches.size() - 2; i++) {
            addPhrase(phrases, getPhrase(matches.get(i), matches.get(i + 1), matches.get(i + 2)));
        }
        return phrases;
    }
}