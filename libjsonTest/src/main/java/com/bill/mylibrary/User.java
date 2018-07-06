package com.bill.mylibrary;


import com.bill.jsonlib.Seriable;

import java.util.List;


/**
 * Created by Bill on 2018/7/6.
 */

public class User {

    @Seriable
    String name;

    @Seriable
    String area;

    @Seriable
    int age;

    int weight;

    @Seriable
    List<Article> mArticleList;

}
