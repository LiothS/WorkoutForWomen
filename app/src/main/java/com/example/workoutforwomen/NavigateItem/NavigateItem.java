package com.example.workoutforwomen.NavigateItem;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Typeface;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.core.content.res.ResourcesCompat;

import com.example.workoutforwomen.R;

public class NavigateItem extends LinearLayout implements View.OnClickListener {
    LayoutInflater mInflater;
    public NavigateItem(Context context) {
        super(context);
        mInflater = LayoutInflater.from(context);

        init();
    }
    String type="";
    public void setType(String str){
        this.type=str;
        switch (type){
            case "Home":tv.setText("Home");
                img.setImageResource(R.drawable.ic_home_outline);
                break;
            case "Activities":tv.setText("Activities");
                img.setImageResource(R.drawable.ic_activity_outline);
                break;
            case "Daily":tv.setText("Daily");
                img.setImageResource(R.drawable.ic_daily_outline);
                break;
            case "Setting":tv.setText("Setting");
                img.setImageResource(R.drawable.ic_settings_2_outline);
                break;
        }


    }


    public NavigateItem(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        mInflater = LayoutInflater.from(context);
        init();
    }

    public NavigateItem(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        mInflater = LayoutInflater.from(context);
        init();
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public NavigateItem(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        mInflater = LayoutInflater.from(context);
        init();
    }
    AppCompatTextView tv;
    ImageView img;
    LinearLayout linearLayout;
    LinearLayout line;
    boolean isActive=false;
    public void init()
    {
        View v = mInflater.inflate(R.layout.navigate_item, this, true);
        tv =  v.findViewById(R.id.tv_navigate);
        img=v.findViewById(R.id.item_img);

        tv.setSingleLine(true);

        tv.measure(0,0);
        measuredTitleWidth=tv.getMeasuredWidthAndState();
        linearLayout=v.findViewById(R.id.layout_contain);
        linearLayout.measure(0,0);
        line=v.findViewById(R.id.linear_line);
        line.measure(0,0);
        linearLayout.setVisibility(GONE);

        img.setImageResource(R.drawable.ic_home_black);
        v.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {



        if(isActive==false) activate();
        else deactivate();

        
    }

    public void deactivate() {
        if(isActive==false) return;
        ValueAnimator animator = ValueAnimator.ofFloat(1f, 0f);
        switch (type){
            case "Home":
                img.setImageResource(R.drawable.ic_home_outline);
                break;
            case "Activities":
                img.setImageResource(R.drawable.ic_activity_outline);
                break;
            case "Daily":
                img.setImageResource(R.drawable.ic_daily_outline);
                break;
            case "Setting":
                img.setImageResource(R.drawable.ic_settings_2_outline);
                break;
        }
        animator.setDuration(300);
        linearLayout.setVisibility(VISIBLE);
        isActive=false;
        animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                float value = (float) animation.getAnimatedValue();
                tv.setWidth(0);
                line.setVisibility(GONE);


                if (value <= 0.0f) {
                    //linearLayout.setVisibility(GONE);

                }
                //  Toast.makeText(getContext(), ""+measuredTitleWidth, Toast.LENGTH_SHORT).show();
                //tv.setLayoutParams(new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT));

            }
        });
        animator.start();
        lineBoolean=false;
    }
    public void activateFirst(){
        if(isActive==true) return;
        if(type.contains("Activi")||type.contains("Sett"))measuredTitleWidth= (int) getResources().getDimension(R.dimen.long_navigate);
        else measuredTitleWidth= (int) getResources().getDimension(R.dimen.short_navigate);

        switch (type){
            case "Home":
                img.setImageResource(R.drawable.ic_home_outline_active);
                break;
            case "Activities":
                img.setImageResource(R.drawable.ic_activity_outline_active);
                break;
            case "Daily":
                img.setImageResource(R.drawable.ic_daily_outline_active);
                break;
            case "Setting":
                img.setImageResource(R.drawable.ic_settings_2_outline_active);
                break;
        }

        linearLayout.setVisibility(VISIBLE);
        line.setVisibility(VISIBLE);
        //Toast.makeText(getContext(), ""+measuredTitleWidth, Toast.LENGTH_SHORT).show();

                tv.setWidth((int) ( measuredTitleWidth*1.5));

                LayoutParams params = (LayoutParams) line.getLayoutParams();
// Changes the height and width to the specified *pixels*

                params.width= (int) (measuredTitleWidth/3);

                isActive=true;

    }
    boolean lineBoolean=false;
    int measuredTitleWidth;
    public void activate() {

        if(isActive==true) return;
        if(type.contains("Activi")||type.contains("Sett")) measuredTitleWidth= (int) getResources().getDimension(R.dimen.long_navigate);
        else measuredTitleWidth= (int) getResources().getDimension(R.dimen.short_navigate);
        ValueAnimator animator = ValueAnimator.ofFloat(0f, 1.5f);
        switch (type){
            case "Home":
                img.setImageResource(R.drawable.ic_home_outline_active);
                break;
            case "Activities":
                img.setImageResource(R.drawable.ic_activity_outline_active);
                break;
            case "Daily":
                img.setImageResource(R.drawable.ic_daily_outline_active);
                break;
            case "Setting":
                img.setImageResource(R.drawable.ic_settings_2_outline_active);
                break;
        }
        animator.setDuration(300);
        linearLayout.setVisibility(VISIBLE);

        line.setVisibility(VISIBLE);
       //Toast.makeText(getContext(), ""+measuredTitleWidth, Toast.LENGTH_SHORT).show();
        animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                float value = (float) animation.getAnimatedValue();
               tv.setWidth((int) ( measuredTitleWidth* value));

                LayoutParams params = (LayoutParams) line.getLayoutParams();
// Changes the height and width to the specified *pixels*


               // Toast.makeText(getContext(), ""+params.width, Toast.LENGTH_SHORT).show();
                    if(value<=1.0f){
                    params.width= (int) (tv.getWidth()/3);
                    line.setLayoutParams(params);}


                if(value>1&& !lineBoolean){
                    if(measuredTitleWidth==getResources().getDimension(R.dimen.short_navigate))
                    params.width= (int) ((int) (getResources().getDimension(R.dimen.short_navigate)/3));
                    else   params.width= (int) (getResources().getDimension(R.dimen.long_navigate)/4);
                    lineBoolean=true;
                    line.setLayoutParams(params);
                    Log.d("length",""+params.width);
                }
                isActive=true;
                if(value>1.5f) {
                    //tv.setLayoutParams(new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT));
//                    params.width=measuredTitleWidth/3;
//                    line.setLayoutParams(params);}}
                    //  Toast.makeText(getContext(), ""+measuredTitleWidth, Toast.LENGTH_SHORT).show();
                    //tv.setLayoutParams(new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT));
                }
            }
        });
        animator.start();

    }
}
