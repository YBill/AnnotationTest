package com.example.bill.annotationtest.runtime;

import android.app.Activity;
import android.view.View;

import java.lang.reflect.Field;

/**
 * Created by Bill on 2018/7/21.
 */

public class IdInjectProcessor {

    public static void inject(Activity activity) {
        Class cls = activity.getClass();
//        Field[] fields = cls.getFields(); // 只能获取public方法，包括父类
        Field[] fields = cls.getDeclaredFields(); // 能获取自己声明的各种字段，包括public，protected，private
        if (fields != null) {
            for (Field field : fields) {
                IdInject inject = field.getAnnotation(IdInject.class);
                if (inject != null) {
                    View view = activity.findViewById(inject.value());
                    if (view != null) {
                        field.setAccessible(true); //能获取自己声明的各种字段，包括public，protected，private
                        try {
                            field.set(activity, view);
                        } catch (IllegalAccessException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }
    }

}
