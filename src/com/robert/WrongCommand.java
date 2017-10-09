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
public class WrongCommand extends Command {
    private String commandString="";

    public WrongCommand(String commandString) {
        this.commandString=commandString;
    }

    @Override
    void execute(Terminal t) {
        result=commandString+": Unknown command";
    }
    
}
