package com.me17b054.quizapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.SharedPreferences;
import android.util.Log;
import android.view.View;
import android.content.Intent;
import android.os.CountDownTimer;
import android.widget.TextView;

public class ResetHighScore extends AppCompatActivity {
    SharedPreferences.Editor editor;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reset_high_score);

    }
    public void YES(View view)
    {SharedPreferences sp;
        sp = getSharedPreferences("my_data", MODE_PRIVATE);
    editor = sp.edit();
     editor.putInt("max_score",0);
            editor.commit();
            Intent next=new Intent(ResetHighScore.this,Result.class);
            int point=0;
            next.putExtra("point",point);
            startActivity(next);


    }
    public void NO(View view)
    {
        int point=0;

        int point2=getIntent().getIntExtra("point",point);
        Log.d("Points","Value"+point2);

        Intent next=new Intent(ResetHighScore.this,Result.class);


            next.putExtra("point",point2);
                    startActivity(next);
                    }
                    }
