package com.yukms.learn.jvm._09;

public class HotSwapClassLoader extends ClassLoader {
    public HotSwapClassLoader(ClassLoader parent) {
        super(HotSwapClassLoader.class.getClassLoader());
    }

    public Class loadByte(byte[] classByte) {
        return defineClass(null, classByte, 0, classByte.length);
    }
}
