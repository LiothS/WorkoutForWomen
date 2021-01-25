package com.example.workoutforwomen.Adapter;

import android.content.Context;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

import com.example.workoutforwomen.Model.ChallengeItem;
import com.example.workoutforwomen.R;

import java.util.List;

public class ChallengeDetailAdapter extends PagerAdapter {
    List<ChallengeItem> list;
    Context context;
    private LayoutInflater layoutInflater;
    TextView tvLevel, tvName, tvLetsGo, tvMessage;
    public ChallengeDetailAdapter(List<ChallengeItem> list, Context context) {
        this.list = list;
        this.context = context;
        this.textViews=new TextView[list.size()];
    }
    public TextView textViews[];

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view.equals(object);
    }
    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, final int position) {
        layoutInflater = LayoutInflater.from(context);
        View view = layoutInflater.inflate(R.layout.challenge_big_item, container, false);
        Typeface font = Typeface.createFromAsset(context.getAssets(), "fonts/Poppins-Bold.ttf");
        Typeface font2 = Typeface.createFromAsset(context.getAssets(), "fonts/Poppins-ExtraLight.ttf");
        Typeface font3 = Typeface.createFromAsset(context.getAssets(), "fonts/Poppins-Medium.ttf");
        RelativeLayout challengeContainer;
        tvLevel=view.findViewById(R.id.big_challenge_lv);

        tvName=view.findViewById(R.id.big_challenge_name);
        tvLetsGo=view.findViewById(R.id.big_challenge_lets_go);
        tvMessage=view.findViewById(R.id.challenge_message);
        challengeContainer=view.findViewById(R.id.big_challenge_container);
        tvLevel.setText(list.get(position).getChallengeLv());
        tvName.setText(list.get(position).getChallengeName());
        tvLevel.setTypeface(font2);
        tvName.setTypeface(font);
        tvMessage.setTypeface(font3);
        tvLetsGo.setTypeface(font);
        if(position%2==0){
           challengeContainer.setBackgroundColor(context.getResources().getColor(R.color.test_red));

        }
        else
        {
           challengeContainer.setBackgroundColor(context.getResources().getColor(R.color.testcolor_blue));

        }
        tvMessage.setText(list.get(position).getChallengeMessage());
        if(position==2) tvMessage.setVisibility(View.VISIBLE);
            else
            tvMessage.setVisibility(View.GONE);
        textViews[position]=tvMessage;
        container.addView(view, 0);
        return view;
    }
    public  void showMessage(int position){

        tvMessage.setVisibility(View.VISIBLE);
    }
 
    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View)object);
    }
}
