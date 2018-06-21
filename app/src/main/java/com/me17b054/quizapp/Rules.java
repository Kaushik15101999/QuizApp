package com.me17b054.quizapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Button;
import android.content.Intent;

public class Rules extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rules);

    }
    public void Go(android.view.View view)
{
   Intent intent =new Intent(Rules.this,Select.class);
        startActivity(intent);
}
}
