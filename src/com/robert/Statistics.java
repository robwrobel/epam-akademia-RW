/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.robert;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 *
 * @author Robert
 */
public class Statistics {
    Map<String,Integer> failedStats= new HashMap<>();
    Map<String,Integer> successStats= new HashMap<>();
    
    void updateStats(Command command){
        String commandName=command.getName();
        boolean isSuccess=command.isSuccess();
        if (isSuccess) {
            updateStatsMap(successStats,commandName);
        } else {
            updateStatsMap(failedStats,commandName);
        }
    }
    private void updateStatsMap(Map<String,Integer> map,String commandName) {
        map.merge(commandName, 1, (a,b)->a+1);
    }
    
    Integer getNoOfSuccess(String commandName) {
        return successStats.getOrDefault(commandName, 0);
    }
    Integer getNoOfFailed(String commandName) {
        return failedStats.getOrDefault(commandName, 0);
    }    
    Set<String> getExecutedCommandNames() {
        Set<String> set=new HashSet<>(failedStats.keySet());
        set.addAll(successStats.keySet());
        return set;
    }
}
