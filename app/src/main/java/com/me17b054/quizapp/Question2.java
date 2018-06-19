package com.me17b054.quizapp;

import android.content.Intent;
import android.graphics.Color;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Question2 extends AppCompatActivity {
    int gameend = 0;
    CountDownTimer count;//Data Type CountDownTimer class count object
    int point=0;
    Bundle extras;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question2);
        extras=getIntent().getExtras();
        int point1=extras.getInt("point",point);
        TextView points=(TextView)findViewById(R.id.point2);
        String point=Integer.toString(point1);
        points.setText(point);
        final TextView mTextField=(TextView)findViewById(R.id.textView8) ;
        count = new CountDownTimer(30000,1000){
            public void onTick(long millisUntilFinished) {
                mTextField.setText("" + millisUntilFinished / 1000);
            }

            public void onFinish() {
                mTextField.setText("0");
                Button b2 = (Button) findViewById(R.id.opt21);
                b2.setBackgroundColor(Color.GREEN);
                gameend=1;

            }
        }.start();

    }

    public void Question(View view) {
        extras=getIntent().getExtras();
        int point1=extras.getInt("point",point);
        if (gameend == 0) {
            TextView points = (TextView) findViewById(R.id.point2);
            Button b1 = (Button) view;
            String tag1 = (String) b1.getTag();
            int tag = Integer.parseInt(tag1);
            if (tag == 1) {
                b1.setBackgroundColor(Color.GREEN);
                point1 = point1 + 10;
                String point2 = (String) Integer.toString(point1);
                points.setText(point2);
                gameend=1;
                count.cancel();
            } else {
                b1.setBackgroundColor(Color.RED);
                point1 = point1 - 5;
                String point2 = (String) Integer.toString(point1);
                points.setText(point2);
                Button b2 = (Button) findViewById(R.id.opt21);
                b2.setBackgroundColor(Color.GREEN);
                gameend=1;
                count.cancel();
            }
        }
    }
    public void Next(View view)
    {
        Intent next=new Intent(Question2.this,Result.class);
        TextView points=(TextView)findViewById(R.id.point2);
        int point=Integer.parseInt(points.getText().toString());
        next.putExtra("point",point);
        startActivity(next);
    }
}
