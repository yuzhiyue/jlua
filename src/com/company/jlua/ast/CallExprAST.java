package com.company.jlua.ast;

import java.util.List;

/**
 * Created by cosineyu on 2016/9/2.
 */
public class CallExprAST extends ExprAST {
    private String functionName;
    private List<ExprAST> args;
}
