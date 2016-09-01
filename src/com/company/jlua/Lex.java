package com.company.jlua;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Cosine on 2016/9/1.
 */

enum Token {
    EOF,
    FUNCTION,
    NUMBER,
    NAME
}

public class Lex {
    private static Map<String, Token> reservedWords = new HashMap<String, Token>(){{
        put("function", Token.FUNCTION);
    }};
    private String text;
    private char currChar;
    private int pos = 0;
    public Token getTok() {

        while(true) {
            switch (currChar) {
                case ' ':
                case '\t': {
                    nextChar();
                    break;
                }
                case 0: {
                    return Token.EOF;
                }
                default: {
                    if(Character.isDigit(currChar)) {
                        double number = readNumber();
                        return Token.NUMBER;
                    }
                    if(Character.isAlphabetic(currChar)) {
                        String word = readWord();
                        Token reservedWord = reservedWords.get(word);
                        if (reservedWord != null) {
                            return  reservedWord;
                        } else {
                            return Token.NAME;
                        }
                    }
                }
            }
        }
    }

    private double readNumber() {
        String numStr = "";
        do{
            numStr += currChar;
        }while(Character.isDigit(currChar) || currChar == '.');
        return Double.parseDouble(numStr);
    }

    private String readWord() {
        String word = "";
        do {
            word += currChar;
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
