package com.example.bill.annotationtest.annotation;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.bill.annotationmodule.DIActivity;
import com.bill.annotationmodule.DIView;
import com.example.bill.annotationtest.R;

@DIActivity
public class AnnotationActivity extends AppCompatActivity {

    @DIView(R.id.text)
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_annotation);
        DIAnnotationActivity.bindView(this);
        textView.setText("Hello World!");
    }
}
