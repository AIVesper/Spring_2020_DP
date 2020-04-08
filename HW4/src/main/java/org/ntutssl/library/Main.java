package org.ntutssl.library;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String instruction;
        Library library = new Library();
        Scanner sc = new Scanner(System.in);
        InputOutput inputOutput = new InputOutput();
        do {
            inputOutput.printLibraryInstructions();
            instruction = sc.nextLine();
            inputOutput.handleLibraryInstructions(instruction, library);
        } while (!instruction.equals("6"));
        sc.close();
    }

}