package com.me17b054.quizapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.SharedPreferences;
import android.view.View;
import android.content.Intent;
import android.os.CountDownTimer;

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
        Intent next=new Intent(ResetHighScore.this,Result.class);

        android.widget.TextView points=(android.widget.TextView)findViewById(R.id.point);
            int point2=Integer.parseInt(points.getText().toString());
            next.putExtra("point",point2);
            startActivity(next);
    }
}
