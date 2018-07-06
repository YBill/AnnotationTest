package com.example.bill.annotationtest.reflect;

import com.example.bill.annotationtest.PrintUtils;

/**
 * Created by Bill on 2018/5/4.
 */

public class Person extends Parent {

    public String country;
    public String city;
    private String name;
    private int age;

    public Person() {
        PrintUtils.print("调用Person的无参构造方法");
    }

    private Person(String country, String city, String name) {
        this.country = country;
        this.city = city;
        this.name = name;
    }

    public Person(String country, int age) {
        this.country = country;
        this.age = age;
    }

    private String getMobile(String number) {
        String mobile = "010-110" + "-" + number;
        return mobile;
    }

    private void setCountry(String country) {
        this.country = country;
        PrintUtils.print("country:" + country);
    }

    public void setCountry(String country, int age) {
        this.country = country;
        this.age = age;
        PrintUtils.print(country + "|" + age);
    }

}
