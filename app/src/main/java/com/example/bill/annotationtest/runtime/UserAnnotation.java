package com.example.bill.annotationtest.runtime;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Created by Bill on 2018/5/17.
 * 使用注解
 */

@MethodInfo(name = "ywb", gid = UserAnnotation.class) //类成员注解
public class UserAnnotation {

    @MethodInfo(name = "param", id = 1, gid = Integer.class) //类成员注解
    private Integer age;

    @MethodInfo(name = "name", id = 5, gid = String.class) //类成员注解
    private String name;

    private String des;

    @MethodInfo(name = "construct", id = 2, gid = UserAnnotation.class)//构造方法注解
    public UserAnnotation() {

    }

    @MethodInfo(name = "public method", id = 3, gid = Map.class) //类方法注解
    public void a() {
        Map<String, String> m = new HashMap<String, String>(0);
    }

    @MethodInfo(name = "protected method", id = 4, gid = List.class) //类方法注解
    protected void b() {
        List<String> m = new ArrayList<>(0);
    }

    @MethodInfo(name = "private method", id = 5, gid = Set.class) //类方法注解
    private void c() {
        Set<Integer> m = new HashSet<>(0);
    }

    public void b(Integer a) {

    }
}
