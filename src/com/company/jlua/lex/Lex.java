package com.company.jlua.lex;

import java.util.HashMap;
import java.util.Map;

public class Lex {
    private static Map<String, Integer> reservedWords = new HashMap<String, Integer>(){{
        put("function", Token.FUNCTION);
    }};
    private String text;
    private char currChar = ' ';
    private int pos = 0;
    private int currTok;
    private double number;
    private String identifier;

    public double getNumber() {
        return number;
    }

    public String getIdentifier() {
        return identifier;
    }

    public int getCurrTok() {
        return currTok;
    }

    public void setText(String val) { this.text = val;}

    public void nextTok() {
        currTok = getTok();
    }

    public int getTok() {

        while(true) {
            switch (currChar) {
                case ' ':
                case '\t': {
                    nextChar();
                    break;
                }
                case '\n':
                case '\r': {
                    char pre = currChar;
                    nextChar();
                    if((currChar == '\r' || currChar == '\n') && pre != currChar) {
                        nextChar();
                    }
                    break;
                }
                case 0: {
                    return Token.EOF;
                }
                default: {
                    if(Character.isDigit(currChar)) {
                        number = readNumber();
                        return Token.NUMBER;
                    }
                    if(Character.isAlphabetic(currChar)) {
                        String word = readWord();
                        Integer reservedWord = reservedWords.get(word);
                        if (reservedWord != null) {
                            return  reservedWord;
                        } else {
                            identifier = word;
                            return Token.IDENTIFIER;
                        }
                    } else {
                        char c = currChar;
                        nextChar();
                        return c;
                    }
                }
            }
        }
    }

    private double readNumber() {
        String numStr = "";
        do{
            numStr += currChar;
            nextChar();
        }while(Character.isDigit(currChar) || currChar == '.');
        return Double.parseDouble(numStr);
    }

    private String readWord() {
        String word = "";
        do {
            word += currChar;
            nextChar();
        } while (Character.isAlphabetic(currChar) || Character.isDigit(currChar));
        return word;
    }

    private void nextChar() {
        if (pos == text.length()) {
            currChar = 0;
            return;
        }
        currChar = text.charAt(pos);
        pos ++;
        return;
    }
}
