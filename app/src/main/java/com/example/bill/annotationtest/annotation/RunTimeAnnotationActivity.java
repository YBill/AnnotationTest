package com.example.bill.annotationtest.annotation;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.example.bill.annotationtest.R;

public class RunTimeAnnotationActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_run_time_annotation);
    }

    public void handleClick(View view) {
        switch (view.getId()) {
            case R.id.btn_1:
                try {
                    ParseAnnotation.parseTypeAnnotation();
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }
                break;
            case R.id.btn_2:
                ParseAnnotation.parseConstructAnnotation();
                break;
            case R.id.btn_3:
                ParseAnnotation.parseFieldAnnotation();
                break;
            case R.id.btn_4:
                ParseAnnotation.parseMethodAnnotation();
                break;
        }


    }
}
