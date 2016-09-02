package com.company.jlua.ast;

import com.company.jlua.lex.Lex;

/**
 * Created by cosineyu on 2016/9/2.
 */
public class VariableExprAST extends ExprAST {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
