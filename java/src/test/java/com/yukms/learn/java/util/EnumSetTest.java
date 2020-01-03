package com.yukms.learn.java.util;

import org.junit.Assert;
import org.junit.Test;
import sun.misc.SharedSecrets;

/**
 * @author hudingpeng hudingpeng@souche.com 2020/1/3 15:12
 */
public class EnumSetTest {

    private enum AnyEnum {
        ELEMENT1,
        ELEMENT2
    }

    @Test
    public void test_getUniverse() {
        Assert.assertArrayEquals(new Enum[] { AnyEnum.ELEMENT1, AnyEnum.ELEMENT2 }, getUniverse(AnyEnum.class));
    }

    private static <E extends Enum<E>> E[] getUniverse(Class<E> elementType) {
        return SharedSecrets.getJavaLangAccess().getEnumConstantsShared(elementType);
    }
}
