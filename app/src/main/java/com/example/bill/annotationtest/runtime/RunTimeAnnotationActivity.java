package com.example.bill.annotationtest.runtime;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.bill.annotationtest.R;

public class RunTimeAnnotationActivity extends AppCompatActivity {

    @IdInject(R.id.text)
    private TextView text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_run_time_annotation);

        IdInjectProcessor.inject(this);
        if (text == null) {
            Toast.makeText(getApplicationContext(), "text is null", Toast.LENGTH_LONG).show();
        } else {
            text.setText("Running annotation!");
        }
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
