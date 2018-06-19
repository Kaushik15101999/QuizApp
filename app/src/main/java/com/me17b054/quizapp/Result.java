package com.me17b054.quizapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Result extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
    int point=0;
    Bundle extras=getIntent().getExtras();
    int point1=extras.getInt("point",point);
        TextView points=(TextView)findViewById(R.id.textView7);
        String point2=(String)Integer.toString(point1);
        points.setText(point2);
    }
}
