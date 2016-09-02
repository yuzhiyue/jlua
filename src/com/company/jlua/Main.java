package com.company.jlua;

import com.company.jlua.lex.Lex;
import com.company.jlua.lex.Token;

public class Main {

    public static void main(String[] args) {
        String text = "function(a, b)\n" +
                "return a+b+123.161";
        Lex lex = new Lex();
        lex.setText(text);
        Token tok;
        do {
            tok = lex.getTok();
            if (tok == Token.IDENTIFIER) {
                System.out.println(tok + ":"+lex.getIdentifier());
            } else if (tok == Token.NUMBER) {
                System.out.println(tok + ":"+lex.getNumber());
            } else if (tok == Token.SINGLE_CHAR) {
                System.out.println(tok + ":"+lex.getC());
            } else {
                System.out.println(tok);
            }
        } while(tok != Token.EOF);
    }
}
