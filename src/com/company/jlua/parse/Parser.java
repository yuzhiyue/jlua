package com.company.jlua.parse;

import com.company.jlua.ast.NumberExprAST;
import com.company.jlua.ast.PrototypeAst;
import com.company.jlua.ast.VariableExprAST;
import com.company.jlua.lex.Lex;
import com.company.jlua.lex.Token;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by cosineyu on 2016/9/2.
 */
public class Parser {
    private Lex lex;
    public void Parser(Lex lex) {
        this.lex = lex;
    }

    public void parse() {
        while(true) {
            if (lex.getTok() == Token.EOF) {
                return;
            }
            parseStatement();
        }
    }

    private void parseStatement() {
        switch (lex.getCurrTok()) {
            case Token.EOF: {
                return;
            }
            case Token.FUNCTION: {
                break;
            }
            case ';': {
                break;
            }
            default: {

            }
        }
    }

    public NumberExprAST parseNumberExprAST() {
        NumberExprAST ast = new NumberExprAST();
        ast.setVal(lex.getNumber());
        lex.nextTok();
        return ast;
    }

    public VariableExprAST parseNameExprAST() {
        VariableExprAST ast = new VariableExprAST();
        ast.setName(lex.getIdentifier());
        lex.nextTok();
        return ast;
    }

    public PrototypeAst parseProtoAST() {
        if(lex.getCurrTok() != Token.IDENTIFIER) {
            return null;
        }
        String functionName = lex.getIdentifier();
        lex.nextTok();
        if (lex.getCurrTok() != '(') {
            return null;
        }
        List<String> args = new ArrayList<String>();
        return null;
    }
}
