package com.example.workoutforwomen.DataBase;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.workoutforwomen.Model.TrainingItem;

import java.util.ArrayList;

public class DataManager {
    SQLiteDatabase database;
    DataHelper dataHelper;
    public static DataManager dataManager;


    public DataManager(Context database) {
        dataHelper = new DataHelper(database);
    }

    public static DataManager getInstance(Context context) {
        if (dataManager == null) {
            dataManager = new DataManager(context);
        }
        return dataManager;
    }
    public  ArrayList<TrainingItem> getTrainingItemList(int bodyPart){
        ArrayList<TrainingItem> list=new ArrayList<>();
        database=dataHelper.getWritableDatabase();
        @SuppressLint("Recycle") Cursor cursor=database.rawQuery("SELECT tb_exercise.id, tb_exercise.name, tb_exercise.level,tb_exercise.duration,tb_exercise.image,tb_exercise.is_saved\n" +
                "from tb_exercise, tb_body_exercise\n" +
                "WHERE(\n" +
                "\t(tb_exercise.id=tb_body_exercise.id_exercise)\n" +
                "\tAND (tb_body_exercise.id_body_part="+bodyPart+")\n" +
                ")",null);

        if (cursor.getCount() != 0) {
            if (cursor.moveToFirst()) {
                do {
                    TrainingItem trainingItem=new TrainingItem();
                    trainingItem.id=cursor.getInt((cursor.getColumnIndex("id")));
                    trainingItem.Name=cursor.getString((cursor.getColumnIndex("name")));
                    trainingItem.level=cursor.getString((cursor.getColumnIndex("level")));
                    trainingItem.image=cursor.getString((cursor.getColumnIndex("image")));
                    trainingItem.duration=cursor.getInt((cursor.getColumnIndex("duration")));
                    trainingItem.isSaved=cursor.getInt((cursor.getColumnIndex("is_saved")));
                    list.add(trainingItem);
                } while (cursor.moveToNext());
            }
        }
        cursor.close();
        return list;
    }
    public  ArrayList<TrainingItem> getSavedExercise(){
        ArrayList<TrainingItem> list=new ArrayList<>();
        database=dataHelper.getWritableDatabase();
        @SuppressLint("Recycle") Cursor cursor=database.rawQuery("SELECT*from tb_exercise WHERE is_saved=1",null);

        if (cursor.getCount() != 0) {
            if (cursor.moveToFirst()) {
                do {
                    TrainingItem trainingItem=new TrainingItem();
                    trainingItem.id=cursor.getInt((cursor.getColumnIndex("id")));
                    trainingItem.Name=cursor.getString((cursor.getColumnIndex("name")));
                    trainingItem.level=cursor.getString((cursor.getColumnIndex("level")));
                    trainingItem.image=cursor.getString((cursor.getColumnIndex("image")));
                    trainingItem.duration=cursor.getInt((cursor.getColumnIndex("duration")));
                    trainingItem.isSaved=cursor.getInt((cursor.getColumnIndex("is_saved")));
                    list.add(trainingItem);
                } while (cursor.moveToNext());
            }
        }
        cursor.close();
        return list;
    }
    public void setSavedExercise(int id,int status) {
        database = dataHelper.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("is_saved", status);
        String s = "id="+id;
        database.update("tb_exercise", contentValues, s, null);
    }
}
