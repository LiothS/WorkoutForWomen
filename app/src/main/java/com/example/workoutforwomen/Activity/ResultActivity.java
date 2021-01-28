package com.example.workoutforwomen.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Typeface;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.TextureView;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.workoutforwomen.DataBase.DataManager;
import com.example.workoutforwomen.Model.MovementItem;
import com.example.workoutforwomen.Model.TrainingItem;
import com.example.workoutforwomen.R;
import com.google.android.material.appbar.CollapsingToolbarLayout;

import java.util.ArrayList;

import static maes.tech.intentanim.CustomIntent.customType;

public class ResultActivity extends AppCompatActivity {
    CollapsingToolbarLayout collapsingToolbarLayout;
    RelativeLayout imgBg;
    TextView tvCompleted,tvExcellent,tvFeel, tvEasy, tvJustRight, tvTooHard, tvTime, tvCalories,tvTotalTime, tvTotalCalories,tvShare, tvFinish;
    LinearLayout item1,item2,item3;
    ImageView backBtn, bookMark;
    int totalTime=0, totalCalories=0;
    ArrayList<MovementItem> list;
    TrainingItem trainingItem;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercise_result);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            getWindow().setStatusBarColor(getResources().getColor(R.color.white));
        }
        try {
            getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
        }
        catch (Exception e){}
        init();
        list= (ArrayList<MovementItem>) getIntent().getSerializableExtra("movementList");
        trainingItem= (TrainingItem) getIntent().getSerializableExtra("exercise");
        TotalTimeCount();
        bookMark.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(trainingItem.getIsSaved()==0){
                    DataManager dataManager=DataManager.getInstance(ResultActivity.this);
                    dataManager.setSavedExercise(trainingItem.getId(),1);
                    bookMark.setImageResource(R.drawable.ic_bookmark_inline_white);
                    trainingItem.setIsSaved(1);
                }
                else{
                    DataManager dataManager=DataManager.getInstance(ResultActivity.this);
                    dataManager.setSavedExercise(trainingItem.getId(),0);
                    bookMark.setImageResource(R.drawable.ic_bookmark_outline);
                    trainingItem.setIsSaved(0);
                }
            }
        });
        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
                customType(ResultActivity.this,"right-to-left");
            }
        });
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
        customType(ResultActivity.this,"right-to-left");
    }

    private void TotalTimeCount() {
        for(int i=0;i<list.size();i++)
            totalTime=totalTime+list.get(i).getCompleteTime();

        totalTime=totalTime/1000;

        if(totalTime<60){
            if(totalTime>=10) tvTotalTime.setText("00:"+totalTime);
            else tvTotalTime.setText("00:0"+totalTime);
        }
        else {
            Log.d("result",totalTime+"33");
            String value="0"+totalTime/60+":";
            int sub=totalTime-(totalTime/60)*60;
            if(sub==0) tvTotalTime.setText(value+"00");
            else if (sub>=10) tvTotalTime.setText(value+sub);
            else tvTotalTime.setText(value+"0"+sub);
        }
    }

    private void init() {
        Typeface font = Typeface.createFromAsset(this.getAssets(), "fonts/Poppins-Bold.ttf");
        Typeface font2 = Typeface.createFromAsset(this.getAssets(), "fonts/Poppins-ExtraLight.ttf");
        collapsingToolbarLayout=findViewById(R.id.toolbar_layout);
        backBtn=findViewById(R.id.back_btn);
        bookMark=findViewById(R.id.save_btn);
        tvCompleted=findViewById(R.id.complete);
        tvExcellent=findViewById(R.id.excellent);
        tvFeel=findViewById(R.id.feel);
        tvEasy=findViewById(R.id.easy);
        tvJustRight=findViewById(R.id.just_right);
        tvTooHard=findViewById(R.id.too_hard);
        tvTime=findViewById(R.id.time);
        tvCalories=findViewById(R.id.calories);
        tvTotalTime=findViewById(R.id.total_time);
        tvTotalCalories=findViewById(R.id.total_calories);
        tvShare=findViewById(R.id.share_with_friends);
        tvFinish=findViewById(R.id.finish);
        item1=findViewById(R.id.item1);
        item2=findViewById(R.id.item2);
        item3=findViewById(R.id.item3);
        imgBg=findViewById(R.id.exercise_img);
        tvCompleted.setTypeface(font);
        tvExcellent.setTypeface(font2);
        tvFeel.setTypeface(font);
        tvEasy.setTypeface(font2);
        tvTooHard.setTypeface(font2);
        tvJustRight.setTypeface(font2);
        tvTime.setTypeface(font2);
        tvCalories.setTypeface(font2);
        tvTotalCalories.setTypeface(font);
        tvTotalTime.setTypeface(font);
        tvShare.setTypeface(font);
        tvFinish.setTypeface(font);
        collapsingToolbarLayout.setContentScrimColor(getResources().getColor(R.color.black));
    }
}