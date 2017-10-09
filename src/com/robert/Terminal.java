/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.robert;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

/**
 *
 * @author Robert
 */
class Terminal {
    private boolean nextCommand=true;
    private static final String DEFAULT_PROMPT="$";
    private String prompt="$";
    private Path currentPath = Paths.get(".");
    CommandFactory commandFactory = new CommandFactory();
    Command currentCommand;
    Scanner scanner = new Scanner(System.in); 
    CommandParser parser = new CommandParser();
    void start() {
        do {
            displayPrompt();
            setCurrentCommand();
            executeCommand();
            displayResults();
           // updateStatistics();
        } while (nextCommand);
    }

    private void displayPrompt() {
        String actualPrompt=parsePrompt();
        System.out.print(actualPrompt+">"); 
    }

    private void setCurrentCommand() {
        String line = scanner.nextLine();
        parser.parseCommand(line); 
        currentCommand=commandFactory.getCommand(parser.getCommandString(), parser.getParameterString());
    }

    private void executeCommand() {
        currentCommand.execute(this);
    }

    private void displayResults() {
        System.out.println(currentCommand.getResult()); //To change body of generated methods, choose Tools | Templates.
    }

    private void updateStatistics() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    Path getCurrentPath() {
        return currentPath;
    }
    
    void setNextCommand(boolean nextCommand) {
        this.nextCommand = nextCommand;
    }

    void setCurrentPath(Path currentPath) {
        this.currentPath=currentPath;
    }
    
    void setPrompt(String prompt) {
        this.prompt=prompt;
    }

    private String parsePrompt() {
        String tmpPrompt;
        tmpPrompt=prompt.replace("$cwd", getCurrentPath().normalize().toAbsolutePath().toString());
        
        return tmpPrompt;
    }

    void setDefaultPrompt() {
        setPrompt(DEFAULT_PROMPT); //To change body of generated methods, choose Tools | Templates.
    }
    
}
