package com.me17b054.quizapp;

import android.content.Intent;
import android.graphics.Color;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.HashMap;
import java.util.Random;

public class Questions extends AppCompatActivity {
    Bundle extras;
    int point1=0;
    int i=0;
    int count;
    CountDownTimer count1;//Data Type CountDownTimer class count object
    int gameend=0;
    int gamefinish=0;
    String Question[];
    String Option1[];
    String Option2[];
    String Option3[];
    String Option4[];
    int Answer[];//never initialize outside method
    int point=0;
    Random r;
    int countnotfinal;
    TextView myquestion;
    TextView myoption1;
    TextView myoption2;
    TextView myoption3;
    TextView myoption4;
    int array[];
    HashMap <Integer,Button> hashMap;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Question= getResources().getStringArray(R.array.Question);
        Option1=getResources().getStringArray(R.array.OPTION1);
        Option2=getResources().getStringArray(R.array.OPTION2);
        Option3=getResources().getStringArray(R.array.OPTION3);
        Option4=getResources().getStringArray(R.array.OPTION4);
        Answer=getResources().getIntArray(R.array.ANSWERS);
        r = new Random();
        count = r.nextInt( 46- 0) + 0;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_questions);
        TextView number=(TextView)findViewById(R.id.title);
        number.setText("Question 1");
        TextView myquestion =(TextView)findViewById(R.id.question);
        TextView myoption1 =(TextView)findViewById(R.id.option1);
        TextView myoption2 =(TextView)findViewById(R.id.option2);
        TextView myoption3 =(TextView)findViewById(R.id.option3);
        TextView myoption4 =(TextView)findViewById(R.id.option4);
        TextView mTextField = (TextView) findViewById(R.id.timer);
        myquestion.setText(Question[count]);
        myoption1.setText(Option1[count]);
        myoption2.setText(Option2[count]);
        myoption3.setText(Option3[count]);
        myoption4.setText(Option4[count]);

        Button b1=(Button)findViewById(R.id.option1);
        Button b2=(Button)findViewById(R.id.option2);
        Button b3=(Button)findViewById(R.id.option3);
        Button b4=(Button)findViewById(R.id.option4);
        hashMap=new HashMap<Integer, Button>();
        hashMap.put(1,b1);
        hashMap.put(2,b2);
        hashMap.put(3,b3);
        hashMap.put(4,b4);

        count1 = new CountDownTimer(15000, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                TextView mTextField = (TextView) findViewById(R.id.timer);
                mTextField.setText("" + millisUntilFinished / 1000);
            }

            @Override
            public void onFinish() {
                int Answer[]=getResources().getIntArray(R.array.ANSWERS);
                TextView mTextField = (TextView) findViewById(R.id.timer);
                mTextField.setText("0");
                hashMap.get(Answer[count]).setBackgroundColor(Color.GREEN);
                gameend = 1;
                gamefinish=1;
                TextView Eliminated=(TextView)findViewById(R.id.textView3);
                Eliminated.setVisibility(View.VISIBLE);
                Button Next=(Button)findViewById(R.id.button7);
                Next.setVisibility(View.VISIBLE);
            }

        };count1.start();

    }
    public void Quit(View view)
    {
      Intent next=new Intent(Questions.this,Result.class);
            TextView points=(TextView)findViewById(R.id.point);
            int point=Integer.parseInt(points.getText().toString());
            next.putExtra("point",point);
            startActivity(next);
}

    public void question(View view)
    {
        if (gameend == 0)
        {
            TextView points = (TextView) findViewById(R.id.point);
            int point=(int)Integer.parseInt(points.getText().toString());
            Button button = (Button) view;
            String tag1 = (String) button.getTag();
            int tag = Integer.parseInt(tag1);
            int correct=Answer[count];
            if (tag == correct) {
                button.setBackgroundColor(Color.GREEN);
                point= point + 10;
                String point2 = (String)Integer.toString(point);
                points.setText(point2);
                gameend=1;
                count1.cancel();
                Button Next=(Button)findViewById(R.id.button7);
                Next.setVisibility(View.VISIBLE);
            } else if(tag!=correct)
            {
                button.setBackgroundColor(Color.RED);
                point = point - 5;
                String point2 = (String) Integer.toString(point);
                points.setText(point2);
                hashMap.get(correct).setBackgroundColor(Color.GREEN);
                gameend=1;
                count1.cancel();
                gamefinish=1;
                Button Next=(Button)findViewById(R.id.button7);
                Next.setVisibility(View.VISIBLE);
            }
        }
        if(gamefinish==1)
        {
            TextView Eliminated=(TextView)findViewById(R.id.textView3);
            Eliminated.setVisibility(View.VISIBLE);
            Button Next=(Button)findViewById(R.id.button7);
            Next.setVisibility(View.VISIBLE);
        }
        }


    public void onBackPressed() { }
    public void Play(View view)
    {

        TextView myquestion =(TextView)findViewById(R.id.question);
        TextView myoption1 =(TextView)findViewById(R.id.option1);
        TextView myoption2 =(TextView)findViewById(R.id.option2);
        TextView myoption3 =(TextView)findViewById(R.id.option3);
        TextView myoption4 =(TextView)findViewById(R.id.option4);
        if(gamefinish==0)
        {
                count = r.nextInt(46 - 0) + 0;
                i++;
                gameend=0;
                TextView number=(TextView)findViewById(R.id.title);
                number.setText("Question "+(i+1));
                Button b1=(Button)findViewById(R.id.option4);
                b1.setBackgroundColor(Color.parseColor("#FF33B5E5"));
                Button b2=(Button)findViewById(R.id.option3);
                b2.setBackgroundColor(Color.parseColor("#FF33B5E5"));
                Button b3=(Button)findViewById(R.id.option1);
                b3.setBackgroundColor(Color.parseColor("#FF33B5E5"));
                Button b4=(Button)findViewById(R.id.option2);
                b4.setBackgroundColor(Color.parseColor("#FF33B5E5"));
                myquestion.setText(Question[count]);
                myoption1.setText(Option1[count]);
                myoption2.setText(Option2[count]);
                myoption3.setText(Option3[count]);
                myoption4.setText(Option4[count]);
                final int correct=Answer[count];
            Button Next=(Button)findViewById(R.id.button7);
            Next.setVisibility(View.INVISIBLE);
                count1 = new CountDownTimer(15000, 1000) {
                    @Override
                    public void onTick(long millisUntilFinished) {
                        TextView mTextField = (TextView) findViewById(R.id.timer);
                        mTextField.setText("" + millisUntilFinished / 1000);
                    }

                    @Override
                    public void onFinish() {

                        TextView mTextField = (TextView) findViewById(R.id.timer);
                        mTextField.setText("0");
                        hashMap.get(correct).setBackgroundColor(Color.GREEN);
                        gameend = 1;
                        gamefinish=1;
                        TextView Eliminated=(TextView)findViewById(R.id.textView3);
                        Eliminated.setVisibility(View.VISIBLE);
                        Button Next=(Button)findViewById(R.id.button7);
                        Next.setVisibility(View.VISIBLE);
                    }

                };  count1.start();

            }

        else if(gamefinish==1)
        {
            Intent next=new Intent(Questions.this,Result.class);
            TextView points=(TextView)findViewById(R.id.point);
            int point=Integer.parseInt(points.getText().toString());
            next.putExtra("point",point);
            startActivity(next);
        }
    }
    }


