package com.yukms.learn.jvm._08;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.reflect.Field;

public class MethodHandlesTest {
    private static class GrandFather {
        void thinking() {
            System.out.println("i am grandfather");
        }
    }

    private static class Father extends GrandFather {
        void thinking() {
            System.out.println("i am father");
        }
    }

    private static class Son extends Father {
        void thinking() {
            try {
                MethodType methodType = MethodType.methodType(void.class);
                Field implLookup = MethodHandles.Lookup.class.getDeclaredField("IMPL_LOOKUP");
                implLookup.setAccessible(true);
                MethodHandles.Lookup lookup = (MethodHandles.Lookup) implLookup.get(null);
                MethodHandle methodHandle = lookup
                    .findSpecial(GrandFather.class, "thinking", methodType, GrandFather.class);
                methodHandle.invoke(this);
            } catch (Throwable ignored) { }
        }
    }

    public static void main(String[] args) {
        // expect i am grandfather
        new Son().thinking();
        // actual i am father
        // ??????????????????
    }
}
