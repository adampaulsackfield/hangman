package com.hangman.game;

import com.hangman.Words;
import com.hangman.user.Commands;

import java.util.ArrayList;
import java.util.Arrays;

public class Game {
    private final Commands commands = new Commands();
    private final Logger logger = new Logger();
    private final Words words = new Words();
    private int lives = 8;
    private String word; // hello
    private char[] answer; // Current state of the guessed word. // _____

    private final ArrayList<Character> guesses = new ArrayList<>(); // ArrayList for tracking guesses
    

    // Initialise the word list, logger class, and start the game.
    public void init() {
        word = words.getWord();

        logger.init();

        startGame();
    }

    // Method for starting a new game, gets a new word and resets all state.
    private void newGame() {
        guesses.clear();

        lives = 8;

        word = words.getWord();

        logger.printMessage("New game started");

        answer = "_".repeat(word.length()).toCharArray();

        nextMove();
    }

    // Starts the game, by prompting the user for a name.
    private void startGame() {
        logger.printMessage("Game started");

        answer = "_".repeat(word.length()).toCharArray();

        commands.namePrompt();

        logger.printMessage("Welcome: " + commands.getName() + " let's play hangman");

        nextMove();
    }

    // The main logic for the Game lives here.
    private void takeTurn(Character letter) {

        // Check if the letter given has already been tried. If it has then we log a message and call nextMove()
        for (char c : guesses) {
            if (letter == c) {
                logger.printMessage("You have already said the letter: " + letter);
                nextMove();
            }
        }

        // Add the current guess to the guesses list
        guesses.add(letter);

        // Check for any matches
        boolean foundMatches = checkMatches(letter); // If this is still 0 after comparing against the word, then the user never found a letter

        // If not matches, decrement the lives, print message with new lives count. Else, nextMove()
        if (!foundMatches) {
            lives--;
            logger.printMessage("Sorry there are no '" + letter + "'s'. You have " + lives + " lives remaining.");
            logger.printMessage(logger.draw(lives));
            if (lives == 0) {
                gameOver();
            } else {
                nextMove();
            }

        } else {
            nextMove();
        }

    }

    private void gameOver() {
        logger.printMessage("Game Over!");
        logger.printMessage("The word was " + word);

        if (commands.playAgain()) {
            newGame();
        } else {
            logger.printMessage("Thanks for playing " + commands.getName());
            System.exit(0);
        }
    }

    private void nextMove() {
        String solution = Arrays.toString(answer).replaceAll("\\[", "").replaceAll("]", "").replaceAll(",", "").replaceAll(" ", "");

        if (isSolved()) {
            logger.printMessage("Winner, well done " + commands.getName() + "! You found the word " + "'" + solution + "'" + " with " + lives + " lives remaining.");

            if (commands.playAgain()) {
                newGame();
            } else {
                logger.printMessage("Thanks for playing " + commands.getName());
                System.exit(0);
            }
        } else {
            logger.printMessage("Word: " + solution);
            logger.printMessage("Previous guesses: " + guesses);
            Character guess = commands.guessPrompt();

            takeTurn(guess);
        }
    }

    private boolean isSolved() {
        int count = 0;

        for (char c : answer) {
            if (c == '_') {
                count++;
            }
        }

        return count == 0;
    }

    private boolean checkMatches(char letter) {
        int count = 0;

        for (int i = 0; i < word.length(); i++) {
            if (word.charAt(i) == letter) {
                answer[i] = letter;
                count++;
            }
        }

        return count != 0;
    }
}
