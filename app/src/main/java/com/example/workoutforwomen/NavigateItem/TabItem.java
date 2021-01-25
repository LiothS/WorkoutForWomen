package com.example.workoutforwomen.NavigateItem;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Typeface;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;

import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.core.widget.TextViewCompat;

import com.example.workoutforwomen.R;

public class TabItem extends LinearLayout implements View.OnClickListener {
    LayoutInflater mInflater;
    String tabName;
    public TabItem(Context context) {
        super(context);
        mInflater = LayoutInflater.from(context);

        init();
    }

    public String getTabName() {
        return tabName;
    }

    public void setTabName(String tabName) {
        this.tabName = tabName;
        tv.setText(tabName);
    }

    public TabItem(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        mInflater = LayoutInflater.from(context);

        init();
    }

    public TabItem(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        mInflater = LayoutInflater.from(context);

        init();
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public TabItem(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        mInflater = LayoutInflater.from(context);

        init();
    }
    AppCompatTextView tv;
    LinearLayout line;
    public int getTextViewWidth(){
        return tv.getWidth();
    }
    public void init() {
        View v = mInflater.inflate(R.layout.tab_item, this, true);
        tv=v.findViewById(R.id.tab_name);
        line=v.findViewById(R.id.tab_line);
        Typeface font = Typeface.createFromAsset(getContext().getAssets(), "fonts/Poppins-Bold.ttf");
       tv.setTypeface(font);
        tv.setText(tabName);
        v.setOnClickListener(this);
        line.setVisibility(GONE);
        lineWidth=tv.getMeasuredWidthAndState();
    }

    @Override
    public void onClick(View v) {
        Deactivate();
        
    }
        int lineWidth;
    public void Deactivate() {
       tv.setTextColor(getResources().getColor(R.color.inactive));
    }


    public void Activate() {
        tv.setTextColor(getResources().getColor(R.color.textColor));
    }
}
