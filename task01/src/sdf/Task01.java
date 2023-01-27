package sdf;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Collections;
import java.util.List;
import java.util.ArrayList;


public class Task01 {
    public static void main(String[] args) {
        //open road_not_taken file and store in a string
        if (args.length != 1) {
            System.out.println("Usage: javac TASK1.java \n java Task1 sample.txt");
            System.exit(1);
        }

        String fileName = args[0];
        //creating a hashmap to store frequency of each alphabet
        Map<String, Integer> wordfreq = new HashMap<>();
        int totallength = 0;

        try (BufferedReader file_reader = new BufferedReader(new FileReader(fileName))) {
            String data;
            while ((data = file_reader.readLine()) != null) {
                String[] words = data.split(" ");
                for (String word : words) {
                    //remove all non alphabetic characters and convert to lower case
                    word = word.toLowerCase().replaceAll("[^a-zA-Z]", "");
                    if (word.isEmpty()) {
                        continue;
                    }
                    totallength++;
                    //placing the new words and adding the frequencies to already passed words
                    wordfreq.put(word, wordfreq.getOrDefault(word, 0) + 1);
                }
            }
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
            System.exit(1);
        }


        //sort the hashmap based on the frequencies
        List<Map.Entry<String, Integer>> sortedWords = new ArrayList<>(wordfreq.entrySet());
        Collections.sort(sortedWords, (e1, e2) -> e2.getValue() - e1.getValue());

        //print the top 10 words
        System.out.println("Top 10 words with highest frequency:");
        for (int i = 0; i < 10 && i < sortedWords.size(); i++) {
            Map.Entry<String, Integer> entry = sortedWords.get(i);
            String word = entry.getKey();
            int count = entry.getValue();
            double frequency = (double) count / totallength;
            System.out.println(word + ": " + frequency);
        }

    }
    
}
