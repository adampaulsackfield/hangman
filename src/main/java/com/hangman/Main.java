package com.hangman;

public class Main {
    public static void main(String[] args) {
        System.out.println("Welcome to Hangman");

        Words words = new Words();

        System.out.println(words.getWord());
    }
}