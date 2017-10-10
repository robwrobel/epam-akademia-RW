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
    
    public TreeCommand(String command,String parameter) {
        super(command,parameter);
    }

    @Override
    void execute(Terminal t) {
        if (isValidParameter(t.getCurrentPath())) {
            setResult(getTree(t.getCurrentPath()));
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
    
    private String getTree(Path currentPath) {
        StringBuilder out=new StringBuilder();
        String tree;
        try {
            
            Stream<Path> stream = Files.walk(currentPath);
            stream.filter(p->Files.isDirectory(p)).map(p->p.relativize(currentPath).resolve(p.getFileName()))
                    .forEach(p-> {out.append(p.toString());out.append("\n");});
            tree=putDashes(out);
            setSuccess(true);

        } catch (IOException ex) {
            setSuccess(false);
            return "";
        }
        return tree;
    }    

    private String putDashes(StringBuilder tree) {
        return tree.toString().replaceAll(".*?\\\\", "-");
    }
    
}
