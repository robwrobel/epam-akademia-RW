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
public class ExitCommand extends Command {

    public ExitCommand(String command,String parameter) {
        super(command,parameter);
    }

    @Override
    void execute(Terminal t) {
        setResult("Bye");
        setSuccess(true);
        t.setNextCommand(false);
    }
    
}
