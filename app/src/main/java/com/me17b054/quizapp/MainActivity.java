package com.me17b054.quizapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void Continue(View view)
    {
        Intent intent =new Intent(MainActivity.this,Select.class);
        startActivity(intent);
    }
    public void Play(View view)
    {

        Intent intent =new Intent(MainActivity.this,Rules.class);
        startActivity(intent);
  }
  }
