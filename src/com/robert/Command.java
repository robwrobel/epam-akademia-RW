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
abstract class Command {
    private String result="";
    private final String name;
    private final String parameter;
    private boolean isSuccess;
    abstract void execute(Terminal t);
    Command(String name,String parameter) {
        this.name=name;
        this.parameter=parameter;
    }
    String getResult() {
        return result; //To change body of generated methods, choose Tools | Templates.
    }
    String getName() {
        return name;
    }
    String getParameter() {
        return parameter;
    }
    void setResult(String result) {
        this.result=result;
    }
    void setSuccess(boolean isSuccess) {
        this.isSuccess=isSuccess;
    }
    boolean isSuccess() {
        return isSuccess;
    }
}
