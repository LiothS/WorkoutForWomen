package com.example.workoutforwomen.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Typeface;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.workoutforwomen.Adapter.MovementAdapter;
import com.example.workoutforwomen.DataBase.DataManager;
import com.example.workoutforwomen.Model.MovementItem;
import com.example.workoutforwomen.Model.TrainingItem;
import com.example.workoutforwomen.R;
import com.google.android.material.appbar.CollapsingToolbarLayout;

import java.util.ArrayList;

import static maes.tech.intentanim.CustomIntent.customType;

public class MovementListActivity extends AppCompatActivity {
    ImageView backBtn, bookMark;
    RelativeLayout bgImg;
    TextView exName,tvAbout,exTime,exDescription,tvMovement,startBtn;
    RecyclerView recyclerView;
    ArrayList<MovementItem> list;
    MovementAdapter adapter;
    Toolbar toolbar;
    TrainingItem trainingItem;
    CollapsingToolbarLayout collapsingToolbarLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movement_list);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            getWindow().setStatusBarColor(getResources().getColor(R.color.white));
        }
        try {
            getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
        }
        catch (Exception e){}
        list= (ArrayList<MovementItem>) getIntent().getSerializableExtra("movementList");
        trainingItem= (TrainingItem) getIntent().getSerializableExtra("exercise");
        init();
        SharedPreferences pref = getApplicationContext().getSharedPreferences("MyPref", MODE_PRIVATE);
        SharedPreferences.Editor editor=pref.edit();
        editor.putBoolean("reload",true);
        editor.commit();
        adapter=new MovementAdapter(this,list);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        bookMark.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(trainingItem.getIsSaved()==0){
                    DataManager dataManager=DataManager.getInstance(MovementListActivity.this);
                    dataManager.setSavedExercise(trainingItem.getId(),1);
                   bookMark.setImageResource(R.drawable.ic_bookmark_inline_white);
                    trainingItem.setIsSaved(1);
                }
                else{
                    DataManager dataManager=DataManager.getInstance(MovementListActivity.this);
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
                customType(MovementListActivity.this,"right-to-left");
            }
        });
        startBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
                DataManager dataManager = DataManager.getInstance(MovementListActivity.this);
                ArrayList<MovementItem> moveList=dataManager.getMovementList(trainingItem.getId());

                Intent intent=new Intent(MovementListActivity.this, ReadyActivity.class);
                intent.putExtra("movementList",moveList);
                intent.putExtra("movementOrder",1);
                intent.putExtra("exercise",trainingItem);

               startActivity(intent);
                customType(MovementListActivity.this,"bottom-to-up");
            }
        });
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
        customType(MovementListActivity.this,"right-to-left");
    }

    private void init() {
        Typeface font = Typeface.createFromAsset(this.getAssets(), "fonts/Poppins-Bold.ttf");
        Typeface font2 = Typeface.createFromAsset(this.getAssets(), "fonts/Poppins-ExtraLight.ttf");
        backBtn=findViewById(R.id.back_btn);
        bookMark=findViewById(R.id.save_btn);
        bgImg=findViewById(R.id.exercise_img);
        tvAbout=findViewById(R.id.about);
        exTime=findViewById(R.id.ex_mins);
        exName=findViewById(R.id.exercise_name);
        exDescription=findViewById(R.id.ex_description);
        tvMovement=findViewById(R.id.movement);
        startBtn=findViewById(R.id.lets_start);
        recyclerView=findViewById(R.id.list_movement_rv);
        toolbar=findViewById(R.id.toolbar);
        collapsingToolbarLayout=findViewById(R.id.toolbar_layout);
        collapsingToolbarLayout.setContentScrimColor(getResources().getColor(R.color.black));
        exName.setText(trainingItem.getName());
        exTime.setText(trainingItem.getDuration()+" Min");
        if(trainingItem.getIsSaved()==1) bookMark.setImageResource(R.drawable.ic_bookmark_inline_white);
        int resID = getResources().getIdentifier(trainingItem.getImage(), "drawable",  getPackageName());
        bgImg.setBackgroundResource(resID);
        tvAbout.setTypeface(font);
        exTime.setTypeface(font2);
        exName.setTypeface(font2);
        exDescription.setTypeface(font2);
        tvMovement.setTypeface(font);
        startBtn.setTypeface(font);
    }
}