package com.yukms.learn.java.io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PipedReader;
import java.io.PipedWriter;
import java.io.StreamTokenizer;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author hudingpeng hudingpeng@souche.com 2019/11/22 11:05
 */
public class StreamTokenizerTest {
    @Test
    public void test_001() throws IOException {
        PipedReader reader = new PipedReader();
        PipedWriter writer = new PipedWriter(reader);
        writer.write("Stream Tokenizer 111");
        writer.close();

        StreamTokenizer tokenizer = new StreamTokenizer(reader);
        StringBuilder sb = new StringBuilder();
        while (tokenizer.nextToken() != StreamTokenizer.TT_EOF) {
            switch (tokenizer.ttype) {
                case StreamTokenizer.TT_NUMBER:
                    sb.append(tokenizer.nval);
                case StreamTokenizer.TT_WORD:
                    sb.append(tokenizer.sval);
                case StreamTokenizer.TT_EOL:
                default:
            }
        }
        Assert.assertEquals("StreamTokenizer111.0null", sb.toString());
    }

    @Test
    public void test_002() {
        StreamTokenizer in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
    }
}
