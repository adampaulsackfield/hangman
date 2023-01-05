package com.hangman.user;

import java.util.Scanner;

public class Commands {
    private String name;

    private final Scanner sc = new Scanner(System.in);

    public void namePrompt() {
        System.out.println("Nombre?");
        name = sc.next();
    }

    public String getName() {
        return name;
    }

    public char takeGuess() {
        System.out.println("Choose a letter?");

        char guess = sc.next().charAt(0);

//        return Character.toLowerCase(guess);
        return Character.toLowerCase(guess);
    }
}
