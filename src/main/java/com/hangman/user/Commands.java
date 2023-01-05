package com.hangman.user;

import com.hangman.game.Logger;

import java.util.ArrayList;
import java.util.Scanner;

public class Commands {
    private String name;

    private ArrayList<Character> guesses = new ArrayList<>();

    private Logger logger = new Logger();

    private final Scanner sc = new Scanner(System.in);

    public void namePrompt() {
        logger.printMessage("Nombre?");
        name = sc.next();
    }

    public String getName() {
        return name;
    }

    public char takeGuess() {
        logger.printMessage("Choose a letter?");

        char guess = sc.next().charAt(0);

        for (char c : guesses) {

            System.out.println(guess);
            System.out.println(c);

            if (c == guess) {
                logger.printMessage("You have already tried the letter " + guess);
                takeGuess();
                return 'c';
            }
            System.out.println(guesses);
        }
        return Character.toLowerCase(guess);

    }
}
