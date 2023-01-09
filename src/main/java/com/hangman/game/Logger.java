package com.hangman.game;

import java.util.HashMap;

public class Logger {
    protected final HashMap<Integer, String> asciiMap = new HashMap<>();
    public void printMessage(String message) {
        System.out.println(message);
    }
    protected void init() {
        asciiMap.put(7, "____________");
        asciiMap.put(6, " |\n |\n |\n |\n |\n |\n |\n |\n____________");
        asciiMap.put(5, "____________\n|/\n|\n|\n|\n|\n|\n|\n|\n____________");
        asciiMap.put(4, "____________\n|          |\n|\n|\n|\n|\n|\n|\n____________");
        asciiMap.put(3, "____________\n|          |\n|         (_)\n|\n|\n|\n|\n|\n____________");
        asciiMap.put(2, "____________\n|          |\n|         (_)\n|          |\n|          |\n|          |\n|\n|\n|\n____________");
        asciiMap.put(1, "____________\n|          |\n|         (_)\n|         \\|/\n|          |\n|          |\n|\n|\n|\n____________");
        asciiMap.put(0, "____________\n|          |\n|         (_)\n|         \\|/\n|          |\n|          |\n|         / \\ \n|\n|\n____________");
    }
    protected String draw(Integer lives) {
        return asciiMap.get(lives);
    }

}
