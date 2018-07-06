package com.example.bill.annotationtest.reflect;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.example.bill.annotationtest.PrintUtils;
import com.example.bill.annotationtest.R;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ReflectTestActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reflect_test);
    }

    public void handleClick(View view) {
        testField();
    }

    private void testMethod() {
        Class mClass = Person.class;
        //1、得到clazz 对应的类中有哪些方法,不能获取private方法
        Method[] methods = mClass.getMethods();
        for (int i = 0; i < methods.length; i++) {
            PrintUtils.print(i + ":" + methods[i].getName());
        }

        //2、获取所有的方法(且只获取当着类声明的方法，包括private方法）
        Method[] methods2 = mClass.getDeclaredMethods();
        for (int i = 0; i < methods2.length; i++) {
            PrintUtils.print(i + ":" + methods2[i].getName());
        }

        //3、获取指定的方法
        Method method = null;
        Method method2 = null;
        try {
            method = mClass.getDeclaredMethod("setCountry", String.class);//第一个参数是方法名，后面的是方法里的参数
            PrintUtils.print("method:" + method);

            method2 = mClass.getDeclaredMethod("setCountry", String.class, int.class);//第一个参数是方法名，后面的是方法里的参数
            PrintUtils.print("method2: " + method2);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }

        //4、执行方法！
        try {
            Object obj = mClass.newInstance();

            //通过反射执行private方法
            method.setAccessible(true);
            method.invoke(obj, "Bill");

            method2.invoke(obj, "Bill", 22);
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

    }

    public void testField() {
        try {
            Class clazz = Class.forName("com.example.bill.annotationtest.reflect.Person");
            //1、获取字段
            //1.1 获取Field的数组,私有字段也能获取
            Field[] fields = clazz.getDeclaredFields();
            for (Field field : fields) {
                PrintUtils.print(field.getName());
            }

            //1.2 获取指定名字的Field（如果是私有的，见下面的4)
            Field field = clazz.getDeclaredField("country");
            PrintUtils.print("field:" + field.getName());

            Person person = new Person("ABC", 12);
            //2、获取指定对象的Field的值
            Object val = field.get(person);
            PrintUtils.print("获取指定对象字段'name'的Field的值=:" + val);

            //3、设置指定对象的Field的值
            field.set(person, "Bill");
            PrintUtils.print("设置指定对象字段'name'的Field的值=: " + person.country);

            //4、若该字段是私有的，需要调用setAccessible(true)方法
            Field field2 = clazz.getDeclaredField("age");
            field2.setAccessible(true);
            PrintUtils.print("获取指定私有字段名=: " + field2.getName());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }

}
