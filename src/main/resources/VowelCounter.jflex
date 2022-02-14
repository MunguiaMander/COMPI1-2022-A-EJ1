package com.mycompany.ejercicio02;
import java.util.ArrayList;
%%

%class VowelCounter
%unicode
%line
%column
%int
%public

%{
    private int oneVowelCounter = 0;
    private int twoVowelCounter = 0;
    private int treeVowelCounter = 0;
    private int forVowelCounter = 0;
    private int fiveVowelCounter = 0;
    private int noVowelCounter = 0;
    private int vowelCount = 0;
    public ArrayList <Number> numberInfo = new ArrayList<>();

    private void increaseVowelCount() {
       vowelCount++;
    }
    
    private void assignCounter(){
    	switch (vowelCount) {
            case 1:
                oneVowelCounter++;
                vowelCount = 0;
                break;
            case 2:
                twoVowelCounter++;
                vowelCount = 0;
                break;
            case 3:
                treeVowelCounter++;
                vowelCount = 0;
                break;
            case 4:
                forVowelCounter++;
                vowelCount = 0;
                break;
            case 5:
                fiveVowelCounter++;
                vowelCount = 0;
                break;
            default:
                noVowelCounter++;
                break;
        }
    }
    
   private void saveNumber(int value, int line, int column){
        this.numberInfo.add(new Number(value, line, column));
    }
    
    public int getOneVowelCounter() {
        return oneVowelCounter;
    }

    public int getTwoVowelCounter() {
        return twoVowelCounter;
    }

    public int getTreeVowelCounter() {
        return treeVowelCounter;
    }

    public int getForVowelCounter() {
        return forVowelCounter;
    }

    public int getFiveVowelCounter() {
        return fiveVowelCounter;
    }

    public int getNoVowelCounter() {
        return noVowelCounter;
    }

    public int getVowelCount() {
        return vowelCount;
    }
    
    public ArrayList<Number> getInfoNumer(){
	return numberInfo;    
    }
    
    
%}

%%

[a,e,i,o,u,A,E,I,O,U]	{increaseVowelCount();}
[ ,\n,\r,\t]		{assignCounter();}
[0-9]+		{saveNumber(Integer.valueOf(yytext()), yyline, yycolumn);}
[^] {}
