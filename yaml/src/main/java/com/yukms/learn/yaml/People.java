package com.yukms.learn.yaml;

import java.util.ArrayList;
import java.util.List;

import lombok.Data;

/**
 * @author hudingpeng hudingpeng@souche.com 2019/6/27 18:24
 */
@Data
public class People {
    private String name;
    private int age;
    private List<String> address = new ArrayList<>();
}
