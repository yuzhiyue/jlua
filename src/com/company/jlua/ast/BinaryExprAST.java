package com.company.jlua.ast;

/**
 * Created by cosineyu on 2016/9/2.
 */
public class BinaryExprAST extends ExprAST {
    private char op;
    private ExprAST lhs;
    private ExprAST rhs;
}
