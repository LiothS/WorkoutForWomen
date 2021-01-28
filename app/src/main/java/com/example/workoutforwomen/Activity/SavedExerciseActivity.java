package com.example.workoutforwomen.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.example.workoutforwomen.Adapter.LongItemTrainingAdapter;
import com.example.workoutforwomen.DataBase.DataManager;
import com.example.workoutforwomen.Model.TrainingItem;
import com.example.workoutforwomen.R;

import java.util.ArrayList;

import static maes.tech.intentanim.CustomIntent.customType;

public class SavedExerciseActivity extends AppCompatActivity {
    ArrayList<TrainingItem> list1;
    LongItemTrainingAdapter adapter;
    RecyclerView recyclerView;
    ImageView backBtn;
    DataManager dataManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_exercise);
        dataManager=DataManager.getInstance(this);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            getWindow().setStatusBarColor(getResources().getColor(R.color.white));
        }
        try {
            getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
        }
        catch (Exception e){}
        SharedPreferences pref = getApplicationContext().getSharedPreferences("MyPref", MODE_PRIVATE);
        SharedPreferences.Editor editor=pref.edit();
        editor.putBoolean("reload",true);
        editor.commit();
        recyclerView=findViewById(R.id.list_exercise_rv);
        backBtn=findViewById(R.id.back_btn);
        BackButtonEvent();
        list1=dataManager.getSavedExercise();
        adapter=new LongItemTrainingAdapter(list1,this);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));

    }

    private void BackButtonEvent() {
        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
                customType(SavedExerciseActivity.this,"right-to-left");
            }
        });
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
        customType(SavedExerciseActivity.this,"right-to-left");
    }
}