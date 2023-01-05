package com.hangman;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Words {
    private static final ArrayList<String> words = new ArrayList<>();

    private static final Random RANDOM = new Random();

    private void readFile() {
        String filePath = System.getProperty("user.dir") + "/words.txt";

        Scanner inputStream = null;

        try {
            inputStream = new Scanner(new File(filePath));
        } catch (FileNotFoundException e) {
            System.out.println("Error opening file: " + filePath);
            System.exit(0);
        }

        System.out.println("Importing words started...");

        while (inputStream.hasNextLine()) {
            String word = inputStream.nextLine();

            words.add(word);

        }

        System.out.println("Imported words complete.");
        inputStream.close();
    }

    public String getWord() {
        readFile();

        return words.get(RANDOM.nextInt(words.size()));
    }

}
