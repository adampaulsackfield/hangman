package com.hangman.user;

import com.hangman.game.Logger;

import java.util.Scanner;

public class Commands {
    private String name;

    private final Logger logger = new Logger();

    private final Scanner sc = new Scanner(System.in);

    public void namePrompt() {
        logger.printMessage("Nombre?");
        name = sc.next();
    }

    public String getName() {
        return name;
    }

    public char guessPrompt() {
        logger.printMessage("Choose a letter?");

        char guess = sc.next().charAt(0);

        return Character.toLowerCase(guess);
    }

    public boolean playAgain() {
        logger.printMessage("Would you like to play another game?");

        char answer = sc.next().charAt(0);

        if (answer != 'y' && answer != 'n') {
            logger.printMessage("y or n");
            playAgain();
        }

        return answer == 'y';
    }
}
