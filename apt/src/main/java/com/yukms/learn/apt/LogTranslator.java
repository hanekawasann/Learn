package com.yukms.learn.apt;

import javax.annotation.processing.Messager;
import javax.tools.Diagnostic;

import com.sun.tools.javac.tree.JCTree;
import com.sun.tools.javac.tree.TreeMaker;
import com.sun.tools.javac.tree.TreeTranslator;
import com.sun.tools.javac.util.List;
import com.sun.tools.javac.util.Names;

/**
 * @author hudingpeng hudingpeng@souche.com 2019/9/25 15:00
 */
public class LogTranslator extends TreeTranslator {
    private TreeMaker treeMaker;
    private Names names;
    private Messager messager;

    public LogTranslator(TreeMaker treeMaker, Names names, Messager messager) {
        this.treeMaker = treeMaker;
        this.names = names;
        this.messager = messager;
    }

    @Override
    public void visitMethodDef(JCTree.JCMethodDecl jcMethodDecl) {
        JCTree.JCBlock jcBlock = jcMethodDecl.getBody();
        JCTree.JCExpressionStatement logStatement = treeMaker.Exec(//
            treeMaker.Apply(//
                List.of(memberAccess("java.lang.String")),//
                memberAccess("java.lang.System.out.println"),//
                List.of(treeMaker.Ident(names.fromString("我是日志")))//
            )//
        );
        jcBlock.stats = jcBlock.getStatements().append(logStatement);
        super.visitMethodDef(jcMethodDecl);
    }

    private JCTree.JCExpression memberAccess(String components) {
        String[] componentArray = components.split("\\.");
        JCTree.JCExpression expr = treeMaker.Ident(names.fromString(componentArray[0]));
        for (int i = 1; i < componentArray.length; i++) {
            expr = treeMaker.Select(expr, names.fromString(componentArray[i]));
        }
        return expr;
    }

    private void printMessage(String method, String message) {
        messager.printMessage(Diagnostic.Kind.WARNING, method + "-->" + message);
    }
}
