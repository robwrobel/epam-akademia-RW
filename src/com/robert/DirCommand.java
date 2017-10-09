/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.robert;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Map;

import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 *
 * @author Robert
 */
public class DirCommand extends Command {
    

    public DirCommand() {
    }

    @Override
    void execute(Terminal t) {
        StringBuilder sb = new StringBuilder();
        sb.append("Content of:");
        sb.append(getCurrentPath(t.getCurrentPath()));
        sb.append("\n");
        sb.append(getFileList(t.getCurrentPath()));
        result=sb.toString();
    }

    private String getCurrentPath(Path currentPath) {
        return currentPath.toAbsolutePath().normalize().toString();//To change body of generated methods, choose Tools | Templates.
    }

    private String getFileList(Path currentPath) {
        try {
            Stream<Path> stream = Files.walk(currentPath,1);
            Map<Path,Boolean> map=stream.collect(Collectors.toMap(Path::getFileName,Files::isDirectory));
            StringBuilder output=new StringBuilder();
            map.keySet().forEach((p) -> {
                String prefix=map.get(p)?"DIR":"FILE";
                output.append(prefix);
                output.append("    ");
                output.append(p.getFileName());
                output.append("\n");
            });
            return output.toString();
        } catch (IOException ex) {
            return "";
        }
    }
    
}
