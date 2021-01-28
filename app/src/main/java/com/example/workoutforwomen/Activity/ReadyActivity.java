package com.example.workoutforwomen.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.workoutforwomen.DataBase.DataManager;
import com.example.workoutforwomen.Model.MovementItem;
import com.example.workoutforwomen.Model.TrainingItem;
import com.example.workoutforwomen.R;

import java.util.ArrayList;
import static maes.tech.intentanim.CustomIntent.customType;

public class ReadyActivity extends AppCompatActivity {
    TextView tv,readyText,timeLeft,skipBtn,nextMovement,movementName;
    ImageView imageView;
    CountDownTimer countDownTimer;
    ArrayList<MovementItem> list;
    TrainingItem trainingItem;
    int order;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ready);

        list= (ArrayList<MovementItem>) getIntent().getSerializableExtra("movementList");
        trainingItem= (TrainingItem) getIntent().getSerializableExtra("exercise");
        order=getIntent().getIntExtra("movementOrder",0);
        order=order-1;
        init();
        setImageData(imageView);
       // Toast.makeText(this, "Size: "+list.get(order).getName(), Toast.LENGTH_SHORT).show();
        countDownTimer=new CountDownTimer(10000, 500) {

            public void onTick(long millisUntilFinished) {
                Log.d("pixel",millisUntilFinished+"");
                if(millisUntilFinished/1000>=10)
                   tv.setText("00:"+millisUntilFinished/1000+"");
                else  tv.setText("00:0"+millisUntilFinished/1000+"");
            }

            public void onFinish() {

                finish();
                Intent intent=new Intent(ReadyActivity.this, ExerciseDetailActivity.class);
                intent.putExtra("movementList",list);
                intent.putExtra("movementOrder",order+1);
                intent.putExtra("exercise",trainingItem);
                startActivity(intent);
                customType(ReadyActivity.this,"left-to-right");


            }
        }.start();
        skipBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              //  Toast.makeText(ReadyActivity.this, "asdsd", Toast.LENGTH_SHORT).show();
                finish();
                Intent intent=new Intent(ReadyActivity.this, ExerciseDetailActivity.class);
                intent.putExtra("movementList",list);
                intent.putExtra("movementOrder",order+1);
                intent.putExtra("exercise",trainingItem);
                startActivity(intent);
                customType(ReadyActivity.this,"left-to-right");
            }
        });
    }

    private void init() {
        tv=findViewById(R.id.ready_time);
        readyText=findViewById(R.id.ready_text);
        timeLeft=findViewById(R.id.time_info);
        skipBtn=findViewById(R.id.skip_btn);
        nextMovement=findViewById(R.id.next_exercise);
        movementName=findViewById(R.id.next_name);
        imageView=findViewById(R.id.gif_ready);
        Typeface font = Typeface.createFromAsset(this.getAssets(), "fonts/Poppins-Bold.ttf");
        Typeface font2 = Typeface.createFromAsset(this.getAssets(), "fonts/Poppins-ExtraLight.ttf");
        tv.setTypeface(font);
        readyText.setTypeface(font);
        timeLeft.setTypeface(font);
        skipBtn.setTypeface(font);
        nextMovement.setTypeface(font2);
        movementName.setTypeface(font);
        if(order==0) readyText.setText(R.string.ready_to_go);
        else readyText.setText(R.string.rest);
        movementName.setText(list.get(order).getName());

   }
    private void setImageData(ImageView imgReadya) {

        Glide.with(this).asGif().load("file:///android_asset/exercise_img/"+list.get(order).getGif()).into(imgReadya);

    }

    @Override
    protected void onPause() {
        super.onPause();
        countDownTimer.cancel();

    }
}