package com.example.workoutforwomen;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.app.Activity;
import android.os.Build;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.LinearLayout;

import com.example.workoutforwomen.Fragment.ActivitiesFragment;
import com.example.workoutforwomen.Fragment.DailyFragment;
import com.example.workoutforwomen.Fragment.HomeFragment;
import com.example.workoutforwomen.Fragment.SettingFragment;
import com.example.workoutforwomen.NavigateItem.NavigateItem;
import static maes.tech.intentanim.CustomIntent.customType;
public class MainActivity extends AppCompatActivity {
    NavigateItem nav1,nav2,nav3,nav4;
    float screenNav;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            getWindow().setStatusBarColor(getResources().getColor(R.color.white));
        }
        try {
            getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
        }
        catch (Exception e){}
        DisplayMetrics dm = new DisplayMetrics();

        getWindowManager().getDefaultDisplay().getMetrics(dm);
      screenNav=dm.widthPixels/dm.densityDpi;
      Log.d("pixel",""+dm.density);
        nav1=findViewById(R.id.nav1);

        nav2=findViewById(R.id.nav2);
        nav3=findViewById(R.id.nav3);
        nav4=findViewById(R.id.nav4);
        nav1.setType("Home");
        nav2.setType("Activities");
        nav3.setType("Daily");
        nav4.setType("Setting");
        loadFragment(new HomeFragment());
        nav1.activateFirst();
        if(screenNav<2){
            LinearLayout.LayoutParams paramBig = (LinearLayout.LayoutParams) nav1.getLayoutParams();

            paramBig.weight= (float) 1.5;
            nav1.setLayoutParams(paramBig);
            //
            LinearLayout.LayoutParams paramSmall2 = (LinearLayout.LayoutParams) nav2.getLayoutParams();
            paramSmall2.weight= (float) 1;
            nav2.setLayoutParams(paramSmall2);
            //
            LinearLayout.LayoutParams paramSmall3= (LinearLayout.LayoutParams) nav3.getLayoutParams();
            paramSmall3.weight= (float) 1;
            nav3.setLayoutParams(paramSmall3);
            //
            LinearLayout.LayoutParams paramSmall4 = (LinearLayout.LayoutParams) nav4.getLayoutParams();
            paramSmall4.weight= (float) 1;
            nav4.setLayoutParams(paramSmall4);
        }

        onNavSelected();
        Log.d("densit","ss"+dm.widthPixels);
    }

    private void onNavSelected() {

        if (screenNav<2) {
            LinearLayout.LayoutParams paramBig = (LinearLayout.LayoutParams) nav1.getLayoutParams();

            paramBig.weight = (float) 1.5;
            nav1.setLayoutParams(paramBig);

        }
        nav1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(screenNav<2){
                LinearLayout.LayoutParams paramBig = (LinearLayout.LayoutParams) nav1.getLayoutParams();

                paramBig.weight= (float) 1.5;
                nav1.setLayoutParams(paramBig);
                //
                LinearLayout.LayoutParams paramSmall2 = (LinearLayout.LayoutParams) nav2.getLayoutParams();
                paramSmall2.weight= (float) 1;
                nav2.setLayoutParams(paramSmall2);
                //
                LinearLayout.LayoutParams paramSmall3= (LinearLayout.LayoutParams) nav3.getLayoutParams();
                paramSmall3.weight= (float) 1;
                nav3.setLayoutParams(paramSmall3);
                //
                LinearLayout.LayoutParams paramSmall4 = (LinearLayout.LayoutParams) nav4.getLayoutParams();
                paramSmall4.weight= (float) 1;
                nav4.setLayoutParams(paramSmall4);
                }
                //
                nav1.activate();

                nav2.deactivate();
                nav3.deactivate();
                nav4.deactivate();
                loadFragment(new HomeFragment());
            }
        });
        nav2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(screenNav<2){
                LinearLayout.LayoutParams paramBig = (LinearLayout.LayoutParams) nav2.getLayoutParams();

                paramBig.weight= (float) 2;
                nav2.setLayoutParams(paramBig);
                //
                LinearLayout.LayoutParams paramSmall1= (LinearLayout.LayoutParams) nav1.getLayoutParams();
                paramSmall1.weight= (float) 1;
                nav1.setLayoutParams(paramSmall1);
                //
                LinearLayout.LayoutParams paramSmall3= (LinearLayout.LayoutParams) nav3.getLayoutParams();
                paramSmall3.weight= (float) 1;
                nav3.setLayoutParams(paramSmall3);
                //
                LinearLayout.LayoutParams paramSmall4 = (LinearLayout.LayoutParams) nav4.getLayoutParams();
                paramSmall4.weight= (float) 1;
                nav4.setLayoutParams(paramSmall4);
                }
                //
                //
                nav2.activate();
                nav1.deactivate();
                nav3.deactivate();
                nav4.deactivate();
                loadFragment(new ActivitiesFragment());
            }
        });
        nav3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (screenNav < 2){
                    LinearLayout.LayoutParams paramBig = (LinearLayout.LayoutParams) nav3.getLayoutParams();

                paramBig.weight = (float) 1.5;
                nav3.setLayoutParams(paramBig);
                //
                LinearLayout.LayoutParams paramSmall1 = (LinearLayout.LayoutParams) nav1.getLayoutParams();
                paramSmall1.weight = (float) 1;
                nav1.setLayoutParams(paramSmall1);
                //
                LinearLayout.LayoutParams paramSmall3 = (LinearLayout.LayoutParams) nav1.getLayoutParams();
                paramSmall3.weight = (float) 1;
                nav1.setLayoutParams(paramSmall3);
                //
                LinearLayout.LayoutParams paramSmall4 = (LinearLayout.LayoutParams) nav4.getLayoutParams();
                paramSmall4.weight = (float) 1;
                nav4.setLayoutParams(paramSmall4);
            }
                //
                //
                nav3.activate();
                nav2.deactivate();
                nav1.deactivate();
                nav4.deactivate();
                loadFragment(new DailyFragment());
            }
        });
        nav4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(screenNav<2) {
                    LinearLayout.LayoutParams paramBig = (LinearLayout.LayoutParams) nav4.getLayoutParams();

                    paramBig.weight = (float) 1.5;
                    nav4.setLayoutParams(paramBig);
                    //
                    LinearLayout.LayoutParams paramSmall1 = (LinearLayout.LayoutParams) nav1.getLayoutParams();
                    paramSmall1.weight = (float) 1;
                    nav1.setLayoutParams(paramSmall1);
                    //
                    LinearLayout.LayoutParams paramSmall3 = (LinearLayout.LayoutParams) nav1.getLayoutParams();
                    paramSmall3.weight = (float) 1;
                    nav1.setLayoutParams(paramSmall3);
                    //
                    LinearLayout.LayoutParams paramSmall4 = (LinearLayout.LayoutParams) nav1.getLayoutParams();
                    paramSmall1.weight = (float) 1;
                    nav1.setLayoutParams(paramSmall4);
                }
                //
                nav4.activate();
                nav2.deactivate();
                nav3.deactivate();
                nav1.deactivate();
                loadFragment(new SettingFragment());
            }
        });
    }
    private void loadFragment(Fragment fragment) {
        // load fragment
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.frame_container, fragment);

        transaction.commit();
    }
}