package com.hangman.game;

import com.hangman.Words;
import com.hangman.user.Commands;

import java.util.Arrays;


public class Game {
    private int lives = 8;

    private String word; // sausage

    private char[] answer; // _______
    private final Commands commands = new Commands();

    private final Logger logger = new Logger();

    public void init() {
        Words words = new Words();

        word = words.getWord();
    }

    public void startGame() {
        logger.printMessage("Game started");

        String blockedAnswer = "_".repeat(word.length());

        answer = blockedAnswer.toCharArray();

        commands.namePrompt();

        logger.printMessage("Welcome: " + commands.getName());

        nextMove();
    }

    public void takeTurn(Character letter) {
        int count = 0;

        for (int i = 0; i < word.length(); i++) {
            if (word.charAt(i) == letter) {
                answer[i] = letter;
                count++;
            }
        }

        if (count == 0) {
            lives--;
            logger.printMessage("Sorry there are no '" + letter + "'s'. You have " + lives + " lives remaining.");
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
        System.exit(0);
    }

    private void nextMove() {
        if (isSolved()) {
            logger.printMessage("Winner");
            logger.printMessage(Arrays.toString(answer));
            System.exit(0);
        } else {
            logger.printMessage(Arrays.toString(answer));
            Character guess = commands.takeGuess();

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
}
