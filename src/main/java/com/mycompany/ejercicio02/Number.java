/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ejercicio02;

/**
 *
 * @author mander
 */
public class Number {

    private int value;
    private int line;
    private int column;

    public Number(int value, int line, int column) {
        this.value = value;
        this.line = line;
        this.column = column;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public void setLine(int line) {
        this.line = line;
    }

    public void setColumn(int column) {
        this.column = column;
    }

    public int getValue() {
        return value;
    }

    public int getLine() {
        return line;
    }

    public int getColumn() {
        return column;
    }
    
    

}
