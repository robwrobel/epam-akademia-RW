/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.robert;

import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Robert
 */
class CommandParser {
    private String commandString;
    private String parameterString;
    void parseCommand(String line) {
        Scanner s = new Scanner(line);
        commandString="";
        parameterString="";
        try {
            commandString=s.next();
            parameterString=s.nextLine();
        } catch (NoSuchElementException e) {
            Logger.getLogger(CommandParser.class.getName()).log(Level.SEVERE, null, e);
        }
    }
    
    String getCommandString() {
        return commandString;
    }
    
    String getParameterString() {
        return parameterString;
    }
    
}
