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
public class PromptCommand extends Command {
    public PromptCommand(String command,String parameter) {
        super(command,parameter);
    }

    @Override
    void execute(Terminal t) {
        if (isReset()) {
            t.setDefaultPrompt();
        } else {
            t.setPrompt(getParameter());
        }
        setSuccess(true);
    }

    private boolean isReset() {
        return getParameter().equals("reset");
    }
    
}
