package com.me17b054.quizapp;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.content.SharedPreferences;


public class Result extends AppCompatActivity {

    int highscore;
    SharedPreferences sp;
    SharedPreferences.Editor editor;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        sp = getSharedPreferences("my_data", MODE_PRIVATE);
        editor = sp.edit();
        highscore = sp.getInt("max_score", 0);

    int point=0;

    int point1=getIntent().getIntExtra("point",point);
    if(point1>highscore)
        {
            highscore=point1;

            editor.putInt("max_score",highscore);
            editor.commit();
            TextView good=(TextView)findViewById(R.id.textView5);
            good.setVisibility(View.VISIBLE);
            android.os.CountDownTimer count1 = new android.os.CountDownTimer (5000,1000)
            {
            public void onTick(long millisUntilFinished) {

                    }

                    @Override
                    public void onFinish() {
                        TextView good=(TextView)findViewById(R.id.textView5);
            good.setVisibility(View.INVISIBLE);

                    }

                };  count1.start();

            TextView high=(TextView)findViewById(R.id.textView4);
            String highscore1=(String)Integer.toString(highscore);
            high.setText("NEW HIGH SCORE: "+highscore1);



}
else
    {
        TextView high=(TextView)findViewById(R.id.textView4);
        String highscore1=(String)Integer.toString(highscore);
            high.setText("HIGH SCORE: "+highscore1);
}
        TextView points=(TextView)findViewById(R.id.textView7);
        String point2=(String)Integer.toString(point1);
        points.setText(point2);
    }
    public void onBackPressed() {
        System.exit(0);

    }
    public void PlayAgain(View view)
    {
        Intent intent =new Intent(Result.this,Select.class);
        startActivity(intent);
    }
    public void Reset(View view)
    {

        TextView points=(TextView)findViewById(R.id.textView7);
        int point=Integer.parseInt(points.getText().toString());
        Intent intent =new Intent(Result.this,ResetHighScore.class);

        intent.putExtra("point",point);
        startActivity(intent);
        Log.d("Points","Value"+point);

    }


}
