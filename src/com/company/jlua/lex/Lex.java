package com.company.jlua.lex;

import java.util.HashMap;
import java.util.Map;

public class Lex {
    private static Map<String, Token> reservedWords = new HashMap<String, Token>(){{
        put("function", Token.FUNCTION);
    }};
    private String text;
    private char currChar = ' ';
    private int pos = 0;

    private double number;
    private String identifier;
    private char c;

    public double getNumber() {
        return number;
    }

    public String getIdentifier() {
        return identifier;
    }

    public char getC() {
        return c;
    }

    public void setText(String val) { this.text = val;}

    public Token getTok() {

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
                        Token reservedWord = reservedWords.get(word);
                        if (reservedWord != null) {
                            return  reservedWord;
                        } else {
                            identifier = word;
                            return Token.IDENTIFIER;
                        }
                    } else {
                        c = currChar;
                        nextChar();
                        return Token.SINGLE_CHAR;
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
