package com.example.workoutforwomen;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;

import com.example.workoutforwomen.NavigateItem.NavigateItem;

public class MainActivity extends AppCompatActivity {
    NavigateItem nav1,nav2,nav3,nav4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        nav1=findViewById(R.id.nav1);

        nav2=findViewById(R.id.nav2);
        nav3=findViewById(R.id.nav3);
        nav4=findViewById(R.id.nav4);
        nav1.setType("Home");
        nav2.setType("Activities");
        nav3.setType("Daily");
        nav4.setType("Setting");
        onNavSelected();
    }

    private void onNavSelected() {
        nav1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                nav1.activate();
                nav2.deactivate();
                nav3.deactivate();
                nav4.deactivate();

            }
        });
        nav2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                nav2.activate();
                nav1.deactivate();
                nav3.deactivate();
                nav4.deactivate();
            }
        });
        nav3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                nav3.activate();
                nav2.deactivate();
                nav1.deactivate();
                nav4.deactivate();
            }
        });
        nav4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                nav4.activate();
                nav2.deactivate();
                nav3.deactivate();
                nav1.deactivate();
            }
        });
    }
}