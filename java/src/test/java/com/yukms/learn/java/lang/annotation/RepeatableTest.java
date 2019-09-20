package com.yukms.learn.java.lang.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Repeatable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import org.junit.Assert;

/**
 * @author hudingpeng hudingpeng@souche.com 2019/9/20 15:33
 */
@RepeatableTest.RepeatableAnnotation
@RepeatableTest.RepeatableAnnotation
public class RepeatableTest {
    @Retention(RetentionPolicy.RUNTIME)
    @Target(ElementType.TYPE)
    @Repeatable(value = RepeatableAnnotations.class)
    @interface RepeatableAnnotation { }

    @Retention(RetentionPolicy.RUNTIME)
    @Target(ElementType.TYPE)
    @interface RepeatableAnnotations {
        RepeatableAnnotation[] value();
    }

    public static void main(String[] args) {
        RepeatableAnnotation[] annotations = RepeatableTest.class.getAnnotationsByType(RepeatableAnnotation.class);
        Assert.assertEquals(2, annotations.length);
        Assert.assertEquals(RepeatableAnnotation.class, annotations[0].annotationType());
        Assert.assertEquals(RepeatableAnnotation.class, annotations[1].annotationType());
    }
}
