package com.company.jlua.ast;

/**
 * Created by cosineyu on 2016/9/2.
 */
public class FunctionAST {
    private PrototypeAst proto;
    private ExprAST body;

    public PrototypeAst getProto() {
        return proto;
    }

    public void setProto(PrototypeAst proto) {
        this.proto = proto;
    }

    public ExprAST getBody() {
        return body;
    }

    public void setBody(ExprAST body) {
        this.body = body;
    }
}
