package com.example.bill.annotationtest.annotation;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;
import android.widget.Toast;

import com.bill.annotationmodule.BindView;
import com.bill.annotationmodule.DIActivity;
import com.bill.annotationmodule.DIView;
import com.example.bill.annotationtest.R;

@DIActivity
public class AnnotationActivity extends AppCompatActivity {

    @BindView(R.id.text)
    TextView textView;

    @DIView(R.id.text)
    TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_annotation);
        new AnnotationActivity$$ViewInjector(this);
        if (textView == null) {
            Toast.makeText(getApplicationContext(), "text is null", Toast.LENGTH_LONG).show();
        } else {
            textView.setText("Hello World!");
        }


        DIAnnotationActivity.bindView(this);
        if (tv != null) {
            Toast.makeText(getApplicationContext(), "" + tv.getText().toString(), Toast.LENGTH_LONG).show();
        }
    }
}
