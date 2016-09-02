package com.company.jlua.ast;

import java.util.List;

/**
 * Created by cosineyu on 2016/9/2.
 */
public class PrototypeAst {
    private String functionName;
    private List<String> args;

    public String getFunctionName() {
        return functionName;
    }

    public void setFunctionName(String functionName) {
        this.functionName = functionName;
    }

    public List<String> getArgs() {
        return args;
    }

    public void setArgs(List<String> args) {
        this.args = args;
    }
}
