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
    String result="";
    abstract void execute(Terminal t);

    String getResult() {
        return result; //To change body of generated methods, choose Tools | Templates.
    }
}
