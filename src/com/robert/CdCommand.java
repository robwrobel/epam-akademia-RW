/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.robert;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 *
 * @author Robert
 */
public class CdCommand extends Command {

    private String parameterString="";
    public CdCommand(String parameterString) {
        this.parameterString=parameterString.trim();
    }

    @Override
    void execute(Terminal t) {
        if (isValidParameter(t.getCurrentPath())) {
            Path targetPath=Paths.get(parameterString);
            Path currentPath=t.getCurrentPath().resolve(targetPath).normalize().toAbsolutePath();
            t.setCurrentPath(currentPath);               
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
    
}
