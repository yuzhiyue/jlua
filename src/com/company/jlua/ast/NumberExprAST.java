package com.company.jlua.ast;

/**
 * Created by cosineyu on 2016/9/2.
 */
public class NumberExprAST extends ExprAST {
    private double val;

    public double getVal() {
        return val;
    }

    public void setVal(double val) {
        this.val = val;
    }
}
