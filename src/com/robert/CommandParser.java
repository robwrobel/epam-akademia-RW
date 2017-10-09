/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.robert;

import java.util.NoSuchElementException;
import java.util.Scanner;

/**
 *
 * @author Robert
 */
class CommandParser {

    Command parseCommand(String line) {
        Command command;
        Scanner s = new Scanner(line);
        String commandString="";
        String parameterString="";
        try {
            commandString=s.next();
            parameterString=s.nextLine();
        } catch (NoSuchElementException e) {
            
        }
        
        switch (commandString) {
            case "dir" : 
                command=new DirCommand();
                break;
            case "cd" :
                command=new CdCommand(parameterString);
                break;
            case "exit" :
                command=new ExitCommand();
                break;                
            default:
                command=new WrongCommand();
                break;
        }
        return command;
    }
    
}
