package com.example.workoutforwomen.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.animation.ValueAnimator;
import android.content.Intent;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.provider.SyncStateContract;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.workoutforwomen.DataBase.DataManager;
import com.example.workoutforwomen.Model.MovementItem;
import com.example.workoutforwomen.Model.TrainingItem;
import com.example.workoutforwomen.R;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

import static maes.tech.intentanim.CustomIntent.customType;

public class ExerciseDetailActivity extends AppCompatActivity {
    ImageView backBtn,playBtn, movementGif;
    TextView movementNumber,movementTime,movementName,movementInstruction,movementDescription, btnPrevious, btnSkip;
    LinearLayout progressBar;
    boolean isPlaying=false;
    RelativeLayout container;
    CountDownTimer countDownTimer;
    ArrayList<MovementItem> list;
    ProgressBar timeProgressBar;
    DisplayMetrics dm;
    TrainingItem trainingItem;
    int order;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercise_detail);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            getWindow().setStatusBarColor(getResources().getColor(R.color.white));
        }
        try {
            getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
        }
        catch (Exception e){}
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
        list= (ArrayList<MovementItem>) getIntent().getSerializableExtra("movementList");
        trainingItem= (TrainingItem) getIntent().getSerializableExtra("exercise");
        order=getIntent().getIntExtra("movementOrder",0);
        Log.d("resultt",trainingItem.getName());
        //Trả order về đúng thứ tự trong list
        order=order-1;
        //
        init();

        movementSecond=list.get(order).getDuration()*1000;
        secondLeft=movementSecond;
   playBtn.setVisibility(View.GONE);
        playGif();
      dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);

        playBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                playBtn.setVisibility(View.GONE);
                if(firstRun==false) ProgressCountDown(secondLeft,(float)secondLeft/(list.get(order).getDuration()*1000));
                playGif();
              isPlaying=true;
            }
        });
        movementGif.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(isPlaying==true){
                    countDownTimer.cancel();
                    animator.cancel();
                    isPlaying=false;
                    playBtn.setVisibility(View.VISIBLE);
                  PauseGif();
                }
            }
        });
        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        btnSkip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                list.get(order).setCompleteTime((int) (movementSecond-(int) secondLeft));
                if(order+1>list.size()-1)
                {
                    finish();
                    Intent intent=new Intent(ExerciseDetailActivity.this, ResultActivity.class);
                    intent.putExtra("movementList",list);
                    intent.putExtra("exercise",trainingItem);
                    startActivity(intent);
                    customType(ExerciseDetailActivity.this,"left-to-right");
                }
                else {
                    Intent intent=new Intent(ExerciseDetailActivity.this, ReadyActivity.class);
                    list.get(order).setCompleteTime((int) (movementSecond-(int) secondLeft));
                    intent.putExtra("movementList",list);
                    intent.putExtra("movementOrder",order+2);
                    intent.putExtra("exercise",trainingItem);
                    startActivity(intent);
                    customType(ExerciseDetailActivity.this,"left-to-right");
                    finish();

                }
            }
        });
        btnPrevious.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
                Intent intent=new Intent(ExerciseDetailActivity.this, ReadyActivity.class);
                intent.putExtra("movementList",list);
                intent.putExtra("movementOrder",order);
                startActivity(intent);
                customType(ExerciseDetailActivity.this,"right-to-left");
            }
        });
    }

    private void PauseGif() {
        Glide.with(this).asBitmap().load("file:///android_asset/exercise_img/"+list.get(order).getGif()).into(movementGif);
    }

    boolean firstRun=true;
    long secondLeft=30000;
    long movementSecond;
    private void playGif() {
        isPlaying=true;
        setImageData(movementGif);

        countDownTimer=new CountDownTimer(secondLeft, 1000) {

            public void onTick(long millisUntilFinished) {
                if(millisUntilFinished<movementSecond-1000&&millisUntilFinished>movementSecond-2000)   {
                    firstRun=false;
                    Log.d("sss",secondLeft+"");
                    ProgressCountDown(millisUntilFinished,1);
                }
                if(millisUntilFinished/1000>=10)
                    movementTime.setText("00:"+millisUntilFinished/1000+"");
                else  movementTime.setText("00:0"+millisUntilFinished/1000+"");
                secondLeft=millisUntilFinished;
            }

            public void onFinish() {
                list.get(order).setCompleteTime((int) movementSecond);
                if(order+1>list.size()-1)
                {
                    finish();
                    Intent intent=new Intent(ExerciseDetailActivity.this, ResultActivity.class);
                    intent.putExtra("movementList",list);
                    intent.putExtra("exercise",trainingItem);
                    startActivity(intent);
                    customType(ExerciseDetailActivity.this,"left-to-right");
                }
                else {
                    finish();
                    Intent intent=new Intent(ExerciseDetailActivity.this, ReadyActivity.class);
                    intent.putExtra("movementList",list);
                    intent.putExtra("movementOrder",order+2);
                    intent.putExtra("exercise",trainingItem);
                   startActivity(intent);
                    customType(ExerciseDetailActivity.this,"left-to-right");
                }

            }
        }.start();

    }
    int width=0;
    ValueAnimator animator ;
    private void ProgressCountDown(long second, float y){
        animator = ValueAnimator.ofFloat(y, 0f);
        Log.d("sizee",""+second+" "+list.get(order).getDuration()*1000+y);
        int value=100;
        if(y<1) value=(int) ((y*100)-10);

        timeProgressBar.setProgress(value);

        animator.setDuration(second);
        animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                float value = (float) animation.getAnimatedValue();

              timeProgressBar.setProgress((int) (value*100));

            }
        });
        animator.start();
    }

    private void init() {
        backBtn=findViewById(R.id.exit_exercise);
        playBtn=findViewById(R.id.play_btn);
        movementGif=findViewById(R.id.movement_gif);
        movementNumber=findViewById(R.id.exercise_number);
        movementTime=findViewById(R.id.time_left);
        movementName=findViewById(R.id.movement_name);
        movementInstruction=findViewById(R.id.movement_instruction);
        movementDescription=findViewById(R.id.movement_description);
        btnPrevious=findViewById(R.id.previous_btn);
        btnSkip=findViewById(R.id.skip_btn);
        Typeface font = Typeface.createFromAsset(this.getAssets(), "fonts/Poppins-Bold.ttf");
        Typeface font2 = Typeface.createFromAsset(this.getAssets(), "fonts/Poppins-ExtraLight.ttf");
        movementNumber.setTypeface(font);
        movementTime.setTypeface(font);
        movementName.setTypeface(font);
        btnPrevious.setTypeface(font);
        btnSkip.setTypeface(font);
        movementInstruction.setTypeface(font2);
        movementDescription.setTypeface(font2);

        container=findViewById(R.id.movement_container);
        movementNumber.setText(order+1+"/"+list.size());
        movementName.setText(list.get(order).getName());
        timeProgressBar=findViewById(R.id.movement_progress_bar);
        timeProgressBar.setProgress(100);
        if(order==0) btnPrevious.setVisibility(View.GONE);

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