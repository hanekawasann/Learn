package com.yukms.learn.java.lang.annotation;

import java.lang.annotation.Annotation;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import org.junit.Assert;

/**
 * @author hudingpeng hudingpeng@souche.com 2019/9/20 15:14
 */
public class InheritedTest {
    @Retention(RetentionPolicy.RUNTIME)
    @Target(ElementType.TYPE)
    @Inherited
    private @interface InheritedAnnotation { }

    @Retention(RetentionPolicy.RUNTIME)
    @Target(ElementType.TYPE)
    private @interface NoInheritedAnnotation { }

    @InheritedAnnotation
    @NoInheritedAnnotation
    private static class People { }

    private static class Student extends People { }

    public static void main(String[] args) {
        Annotation[] annotations = Student.class.getAnnotations();
        Assert.assertEquals(1, annotations.length);
        Assert.assertEquals(InheritedAnnotation.class, annotations[0].annotationType());
    }
}
