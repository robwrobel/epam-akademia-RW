/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.robert;

import java.util.Scanner;

/**
 *
 * @author Robert
 */
class Terminal {
    private boolean nextCommand=true;
    private String prompt="$>";
    
    Command currentCommand;
    Scanner scanner = new Scanner(System.in); 
    CommandParser parser = new CommandParser();
    void start() {
        do {
            displayPrompt();
            setCurrentCommand();
            executeCommand();
            displayResults();
            updateStatistics();
        } while (nextCommand);
    }

    private void displayPrompt() {
        System.out.print(prompt); 
    }

    private void setCurrentCommand() {
        String line = scanner.nextLine();
        currentCommand = parser.parseCommand(line);    }

    private void executeCommand() {
        currentCommand.execute();
    }

    private void displayResults() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void updateStatistics() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
