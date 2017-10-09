/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.robert;

/**
 *
 * @author Robert
 */
public class CommandFactory {
    public Command getCommand(String command,String parameterString) {
        if (command.equals("dir")) 
            return new DirCommand();
        else if (command.equals("cd"))
            return new CdCommand(parameterString);
        else if (command.equals("exit"))
            return new ExitCommand();
        else if (command.equals("prompt"))
            return new PromptCommand(parameterString);
        else if (command.equals("tree"))  
            return new TreeCommand(parameterString);
        else                  
            return new WrongCommand(command);
    }
}