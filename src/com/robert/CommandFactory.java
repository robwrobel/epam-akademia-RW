/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.robert;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Robert
 */
public class CommandFactory {
    private interface Factory {
        Command create(String command,String parameterString);
    }
    private static final Map<String,Factory> factoryMap = new HashMap<>();
    static {
        factoryMap.put("dir", (c,p)->new DirCommand(c,p));
        factoryMap.put("cd", (c,p)->new CdCommand(c,p));
        factoryMap.put("exit", (c,p)->new ExitCommand(c,p));
        factoryMap.put("prompt", (c,p)->new PromptCommand(c,p));
        factoryMap.put("tree", (c,p)->new TreeCommand(c,p));
        factoryMap.put("statistics", (c,p)->new StatsCommand(c,p));
    }
 

    public Command getCommand(String command,String parameterString) {
        Factory creator=factoryMap.getOrDefault(command, (c,p)->new WrongCommand(c,p));
        return creator.create(command, parameterString);
   }
}