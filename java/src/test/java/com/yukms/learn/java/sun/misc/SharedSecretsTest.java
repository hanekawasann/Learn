package com.yukms.learn.java.sun.misc;

import org.junit.Assert;
import org.junit.Test;
import sun.misc.SharedSecrets;

/**
 * @author hudingpeng hudingpeng@souche.com 2020/3/11 13:51
 */
public class SharedSecretsTest {
    @Test
    public void test_getJavaLangAccess() {
        FruitType[] types = SharedSecrets.getJavaLangAccess().getEnumConstantsShared(FruitType.class);
        Assert.assertArrayEquals(new FruitType[] { FruitType.APPLE, FruitType.BANANA }, types);
    }

    private enum FruitType {
        APPLE,
        BANANA;
    }
}
