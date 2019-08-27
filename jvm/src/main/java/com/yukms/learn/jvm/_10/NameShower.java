package com.yukms.learn.jvm._10;

import java.util.EnumSet;

import static javax.lang.model.element.ElementKind.ENUM_CONSTANT;
import static javax.lang.model.element.ElementKind.FIELD;
import static javax.lang.model.element.ElementKind.INTERFACE;
import static javax.lang.model.element.ElementKind.METHOD;
import static javax.lang.model.element.Modifier.FINAL;
import static javax.lang.model.element.Modifier.PUBLIC;
import static javax.lang.model.element.Modifier.STATIC;
import static javax.tools.Diagnostic.Kind.NOTE;
import javax.annotation.processing.Messager;
import javax.annotation.processing.ProcessingEnvironment;
import javax.lang.model.element.Element;
import javax.lang.model.element.ExecutableElement;
import javax.lang.model.element.Name;
import javax.lang.model.element.TypeElement;
import javax.lang.model.element.VariableElement;
import javax.lang.model.util.ElementScanner8;

class NameShower {
    private final Messager messager;

    private NameShowScanner nameShowScanner = new NameShowScanner();

    NameShower(ProcessingEnvironment processingEnv) {
        this.messager = processingEnv.getMessager();
    }

    void checkNames(Element element) {
        nameShowScanner.scan(element);
    }

    private class NameShowScanner extends ElementScanner8<Void, Void> {
        /**
         * 检查类
         */
        @Override
        public Void visitType(TypeElement e, Void p) {
            scan(e.getTypeParameters(), p);
            messager.printMessage(NOTE, "类名 " + e.getSimpleName(), e);
            super.visitType(e, p);
            return null;
        }

        /**
         * 方法名
         */
        @Override
        public Void visitExecutable(ExecutableElement e, Void aVoid) {
            if (e.getKind() == METHOD) {
                messager.printMessage(NOTE, "方法名 " + e.getSimpleName(), e);
            }
            super.visitExecutable(e, aVoid);
            return null;
        }

        /**
         * 变量
         */
        @Override
        public Void visitVariable(VariableElement e, Void p) {
            Name name = e.getSimpleName();
            if (e.getKind() == ENUM_CONSTANT || e.getConstantValue() != null || heuristicallyConstant(e)) {
                messager.printMessage(NOTE, "类属性 " + name, e);
            } else {
                messager.printMessage(NOTE, "实例属性 " + name, e);
            }
            return null;
        }

        private boolean heuristicallyConstant(VariableElement e) {
            return e.getEnclosingElement().getKind() == INTERFACE //
                || e.getKind() == FIELD && e.getModifiers().containsAll(EnumSet.of(PUBLIC, STATIC, FINAL));
        }
    }
}
