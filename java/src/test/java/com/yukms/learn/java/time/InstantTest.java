package com.yukms.learn.java.time;

import java.sql.Timestamp;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.OffsetDateTime;

import org.junit.Assert;
import org.junit.Test;

public class InstantTest {
    @Test
    public void test_() {
        LocalDateTime date = LocalDateTime.of(2019, 10, 11, 0, 0, 0);
        Instant instant = date.toInstant(OffsetDateTime.now().getOffset());
        long epochSecond = Timestamp.valueOf(date).toInstant().getEpochSecond();
        Assert.assertEquals(instant.getEpochSecond(), epochSecond);
    }
}
