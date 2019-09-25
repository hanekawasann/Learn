package com.yukms.learn.apt;

import java.util.Set;

import javax.annotation.processing.AbstractProcessor;
import javax.annotation.processing.Messager;
import javax.annotation.processing.ProcessingEnvironment;
import javax.annotation.processing.Processor;
import javax.annotation.processing.RoundEnvironment;
import javax.annotation.processing.SupportedAnnotationTypes;
import javax.annotation.processing.SupportedSourceVersion;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.Element;
import javax.lang.model.element.ElementKind;
import javax.lang.model.element.TypeElement;
import javax.tools.Diagnostic;

import com.google.auto.service.AutoService;
import com.sun.source.util.Trees;
import com.sun.tools.javac.processing.JavacProcessingEnvironment;
import com.sun.tools.javac.tree.JCTree;
import com.sun.tools.javac.tree.TreeMaker;
import com.sun.tools.javac.util.Context;
import com.sun.tools.javac.util.Names;

/**
 * @author hudingpeng hudingpeng@souche.com 2019/9/25 11:01
 */
@SupportedAnnotationTypes("com.yukms.learn.apt.Name")
@SupportedSourceVersion(SourceVersion.RELEASE_8)
@AutoService(Processor.class)
public class LogProcessor extends AbstractProcessor {
    private LogTranslator translator;
    private TreeMaker treeMaker;
    private Names names;
    private Trees trees;
    private Messager messager;

    @Override
    public synchronized void init(ProcessingEnvironment processingEnv) {
        super.init(processingEnv);
        messager = processingEnv.getMessager();
        trees = Trees.instance(processingEnv);
        Context context = ((JavacProcessingEnvironment) processingEnv).getContext();
        treeMaker = TreeMaker.instance(context);
        names = Names.instance(context);
        translator = new LogTranslator(treeMaker, names, messager);
    }

    @Override
    public boolean process(Set<? extends TypeElement> annotations, RoundEnvironment roundEnv) {
        if (!roundEnv.processingOver() && trees != null) {
            roundEnv.getRootElements().stream()//
                .filter((Element element) -> ElementKind.CLASS == element.getKind())//
                .forEach((Element element) -> ((JCTree) trees.getTree(element)).accept(translator));
        }
        return false;
    }

    private void printMessage(String method, String message) {
        messager.printMessage(Diagnostic.Kind.WARNING, method + "-->" + message);
    }
}
