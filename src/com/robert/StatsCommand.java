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
public class StatsCommand extends Command {

    public StatsCommand(String command,String parameter) {
        super(command,parameter);
    }

    @Override
    void execute(Terminal t) {
        StringBuilder out=new StringBuilder();
        for(String commandName:t.getStatistics().getExecutedCommandNames()) {
            out.append(commandName).append(":");
            out.append(t.getStatistics().getNoOfSuccess(commandName).toString()).append(":");
            out.append(t.getStatistics().getNoOfFailed(commandName).toString()).append("\n");
        }
        setResult(out.toString());
        setSuccess(true);
    }
    
}
