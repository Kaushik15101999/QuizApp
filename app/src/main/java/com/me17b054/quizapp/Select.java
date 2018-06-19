package com.me17b054.quizapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class Select extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select);
    }
    public void Sports(View view)
    {
        Intent Sports =new Intent(Select.this,Question.class);
        startActivity(Sports);
    }
}
