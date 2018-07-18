package com.example.bill.annotationtest.runtime;

import com.example.bill.annotationtest.PrintUtils;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * Created by Bill on 2018/5/17.
 */

public class ParseAnnotation {

    private static String className = "com.example.bill.annotationtest.runtime.UserAnnotation";

    /**
     * 类
     *
     * @throws ClassNotFoundException
     */
    public static void parseTypeAnnotation() throws ClassNotFoundException {
        Class clazz = Class.forName(className);

        Annotation[] annotations = clazz.getAnnotations(); //TODO 只能得到当前的类???
        for (Annotation annotation : annotations) {
            MethodInfo methodInfo = (MethodInfo) annotation;
            PrintUtils.print("id= \"" + methodInfo.id() + "\"; name= \""
                    + methodInfo.name() + "\"; gid = " + methodInfo.gid());
        }
    }

    /**
     * 构造方法
     */
    public static void parseConstructAnnotation() {
        Constructor[] constructors = UserAnnotation.class.getConstructors();
        for (Constructor constructor : constructors) {
            /*
             * 判断构造方法中是否有指定注解类型的注解
             */
            boolean hasAnnotation = constructor.isAnnotationPresent(MethodInfo.class);
            if (hasAnnotation) {
                /*
                 * 根据注解类型返回方法的指定类型注解
                 */
                MethodInfo annotation = (MethodInfo) constructor.getAnnotation(MethodInfo.class);
                PrintUtils.print("constructor = " + constructor.getName()
                        + " ; id = " + annotation.id() + " ; description = "
                        + annotation.name() + "; gid= " + annotation.gid());
            }
        }
    }

    /**
     * 属性
     */
    public static void parseFieldAnnotation() {
        Field[] fields = UserAnnotation.class.getDeclaredFields();
        for (Field field : fields) {
            /*
             * 判断方法中是否有指定注解类型的注解
             */
            boolean hasAnnotation = field.isAnnotationPresent(MethodInfo.class);
            if (hasAnnotation) {
                /*
                 * 根据注解类型返回方法的指定类型注解
                 */
                MethodInfo annotation = field.getAnnotation(MethodInfo.class);
                PrintUtils.print("field = " + field.getName() + " ; id = "
                        + annotation.id() + " ; description = "
                        + annotation.name() + "; gid= " + annotation.gid());
            }
        }
    }

    /**
     * 方法
     */
    public static void parseMethodAnnotation() {
        Method[] methods = UserAnnotation.class.getDeclaredMethods();
        for (Method method : methods) {
            /*
             * 判断方法中是否有指定注解类型的注解
             */
            boolean hasAnnotation = method.isAnnotationPresent(MethodInfo.class);
            if (hasAnnotation) {
                /*
                 * 根据注解类型返回方法的指定类型注解
                 */
                MethodInfo annotation = method.getAnnotation(MethodInfo.class);
                PrintUtils.print("method = " + method.getName() + " ; id = "
                        + annotation.id() + " ; description = "
                        + annotation.name() + "; gid= " + annotation.gid());
            }
        }
    }


}
