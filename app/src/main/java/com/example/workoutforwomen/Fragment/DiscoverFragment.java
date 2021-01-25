package com.example.workoutforwomen.Fragment;

import android.graphics.Typeface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.workoutforwomen.Adapter.FullBodyAdapter;
import com.example.workoutforwomen.Adapter.TrainingAdapter;
import com.example.workoutforwomen.DataBase.DataManager;
import com.example.workoutforwomen.Model.TrainingItem;
import com.example.workoutforwomen.R;

import java.util.ArrayList;

public class DiscoverFragment extends Fragment {
    ArrayList<TrainingItem> list1;
    ArrayList<TrainingItem> list2,list3,list4;
    FullBodyAdapter fullBodyAdapter;
    TrainingAdapter adapter1,adapter2,adapter3;
    RecyclerView rvFullbody,rv1,rv2,rv3;
    TextView tv1,tv2,tv3,tv4;
    DataManager dataManager;
    public DiscoverFragment() {
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_discover, container, false);
        Typeface font = Typeface.createFromAsset(getContext().getAssets(), "fonts/Poppins-Bold.ttf");
        rvFullbody=view.findViewById(R.id.fullbody_recyclerview);
        tv1=view.findViewById(R.id.fullbody);
        dataManager=DataManager.getInstance(getContext());
        tv1.setTypeface(font);
        list1=dataManager.getTrainingItemList(1);
        fullBodyAdapter=new FullBodyAdapter(list1,getContext());
        rvFullbody.setAdapter(fullBodyAdapter);
        rvFullbody.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false));



        //setup train 1

        rv1=view.findViewById(R.id.training_recyclerview1);
        tv2=view.findViewById(R.id.text1);
        tv2.setTypeface(font);
        list2=dataManager.getTrainingItemList(2);
        adapter1=new TrainingAdapter(list2,getContext());
        rv1.setAdapter(adapter1);
        rv1.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false));

        //setup train 2


        rv2=view.findViewById(R.id.training_recyclerview2);
        tv3=view.findViewById(R.id.text2);
        tv3.setTypeface(font);
        list3=dataManager.getTrainingItemList(3);
        adapter2=new TrainingAdapter(list3,getContext());
        rv2.setAdapter(adapter2);
        rv2.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false));


        //setup train 3

        rv3=view.findViewById(R.id.training_recyclerview3);
        tv4=view.findViewById(R.id.text3);
        tv4.setTypeface(font);
        list4=dataManager.getTrainingItemList(4);
        adapter3=new TrainingAdapter(list4,getContext());
        rv3.setAdapter(adapter3);
        rv3.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false));
        return view;
    }
}
