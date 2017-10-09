/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.robert;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.stream.Stream;

/**
 *
 * @author Robert
 */
public class TreeCommand extends Command {
    String parameterString="";

    public TreeCommand(String parameterString) {
        this.parameterString=parameterString.trim();
    }

    @Override
    void execute(Terminal t) {
        if (isValidParameter(t.getCurrentPath())) {
            result=getTree(t.getCurrentPath());
        } else {
            result="Unknown dir:"+parameterString;
        }

    }

    private boolean isValidParameter(Path currentPath) {
        Path tmpCurrentPath=currentPath.resolve(parameterString);

        File currentFile=tmpCurrentPath.toFile();
        if (currentFile.exists()) {
            if (currentFile.isDirectory()) {
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }     
    }
    
    private String getTree(Path currentPath) {
        StringBuilder out=new StringBuilder();
        try {
            
            Stream<Path> stream = Files.walk(currentPath);
            stream.filter(p->Files.isDirectory(p))
                    .forEach(p-> {out.append(p.toString());out.append("\n");});

        } catch (IOException ex) {
            return "";
        }
        return out.toString();
    }    
    
}
