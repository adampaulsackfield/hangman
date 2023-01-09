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

    // Credit: Constantin and Walter for assisting with validation of inputs.
    public char guessPrompt() {
        logger.printMessage("Choose a letter?");

        if(sc.hasNext()){
            String guess = sc.next();
            if(guess.length()==1 && guess.matches("^[A-Za-z]$")){
                return Character.toLowerCase(guess.charAt(0));
            } else{
                logger.printMessage("We only accept single chars around here.");

                return guessPrompt();
            }

        } else {
            logger.printMessage("We only accept single chars around here.");
            sc.next();

            return guessPrompt();
        }
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
