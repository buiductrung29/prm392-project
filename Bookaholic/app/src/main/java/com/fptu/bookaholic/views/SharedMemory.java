package com.fptu.bookaholic.views;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Color;

public class SharedMemory {
    private SharedPreferences sharedPreferences;
    public SharedMemory(Context context){
        sharedPreferences = context.getSharedPreferences("SCREEN_FILTER_PREF", Context.MODE_PRIVATE);
    }

    private int GetValue(String prop, int def){
        return sharedPreferences.getInt(prop, def);
    }

    public void SetValue(String value, int v){
        sharedPreferences.edit().putInt(value, v).apply();;
    }

    public int GetAlpha(){
        return GetValue("alpha", 0x33);
    }

    public void SetAlpha(int val){
        SetValue("alpha", val);
    }

    public int GetRed() {
        return GetValue("red", 0x00);
    }

    public void SetRed(int val) {
        SetValue("red", val);
    }

    public int GetGreen(){
        return GetValue("green", 0x00);
    }

    public void SetGreen(int val){
        SetValue("green", val);
    }

    public int GetBlue(){
        return GetValue("blue", 0x00);
    }

    public void SetBlue(int val){
        SetValue("blue", val);
    }

    public int GetColor() {
        return Color.argb(GetAlpha(), GetRed(), GetGreen(), GetBlue());
    }
}
