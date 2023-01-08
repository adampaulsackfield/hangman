package com.hangman;

import com.hangman.game.Game;


public class Main {
    public static void main(String[] args) {
        System.out.println("Welcome to Hangman");

        Game game = new Game();

        game.init();
    }
}