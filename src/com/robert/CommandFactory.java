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
        factoryMap.put("dir", (c,p)->new DirCommand());
        factoryMap.put("cd", (c,p)->new CdCommand(p));
        factoryMap.put("exit", (c,p)->new ExitCommand());
        factoryMap.put("prompt", (c,p)->new PromptCommand(p));
        factoryMap.put("tree", (c,p)->new TreeCommand(p));
    }
 

    public Command getCommand(String command,String parameterString) {
        Factory creator=factoryMap.getOrDefault(command, (c,p)->new WrongCommand(c));
        return creator.create(command, parameterString);
   }
}