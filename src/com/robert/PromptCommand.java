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
    private final String parameterString;
    public PromptCommand(String parameterString) {
        this.parameterString=parameterString.trim();
    }

    @Override
    void execute(Terminal t) {
        if (isReset()) {
            t.setDefaultPrompt();
        } else {
            t.setPrompt(parameterString);
        }
    }

    private boolean isReset() {
        return parameterString.equals("reset"); //To change body of generated methods, choose Tools | Templates.
    }
    
}
