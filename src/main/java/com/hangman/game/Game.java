package com.hangman.game;

import com.hangman.Words;
import com.hangman.user.Commands;


public class Game {
    private int lives = 8;

    private String word;

    private char[] answer;
    private final Commands commands = new Commands();


    public void init() {
        Words words = new Words();

        word = words.getWord();
    }

    public void startGame() {
        System.out.println("Game started!");

        System.out.println("Random Word is: " + word);

        System.out.println("Word: ");
        String blockedAnswer = "_".repeat(word.length());

        answer = blockedAnswer.toCharArray();

        System.out.println(answer);

        commands.namePrompt();
        System.out.println("Welcome: " + commands.getName());
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
            System.out.println("Sorry there are no '" + letter + "'s'. You have " + lives + " lives remaining.");
            lives--;
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
        System.out.println("Game Over!");
        System.exit(0);
    }

    private void nextMove() {
        System.out.println(answer);

        Character guess = commands.takeGuess();

        takeTurn(guess);
    }
}
