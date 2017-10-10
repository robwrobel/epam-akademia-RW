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
    

    public WrongCommand(String command,String parameter) {
        super(command,parameter);
    }

    @Override
    void execute(Terminal t) {
        setResult(getName()+": Unknown command");
        setSuccess(false);
    }
    
}
