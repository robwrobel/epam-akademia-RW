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

    public CdCommand(String name,String parameter) {
        super(name,parameter);
    }

    @Override
    void execute(Terminal t) {
        if (isValidParameter(t.getCurrentPath())) {
            Path targetPath=Paths.get(getParameter());
            Path currentPath=t.getCurrentPath().resolve(targetPath).normalize().toAbsolutePath();
            t.setCurrentPath(currentPath);      
            setSuccess(true);
        } else {
            setResult("Unknown dir:"+getParameter());
            setSuccess(false);
        }
    }

    private boolean isValidParameter(Path currentPath) {
        Path tmpCurrentPath=currentPath.resolve(getParameter());

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
