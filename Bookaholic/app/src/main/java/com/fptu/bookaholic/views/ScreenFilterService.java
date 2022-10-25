package com.fptu.bookaholic.views;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.graphics.PixelFormat;
import android.os.IBinder;
import android.view.View;
import android.view.WindowManager;
import android.widget.LinearLayout;

public class ScreenFilterService extends Service {

    public static int STATE_ACTIVE = 0;
    public static int STATE_INACTIVATE = 1;

    public static int STATE;

    static {
        STATE = STATE_ACTIVE;
    }

    private SharedMemory sharedMemory;
    private View view;

    public ScreenFilterService() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onCreate() {
        sharedMemory = new SharedMemory(this);
        view = new LinearLayout(this);
        view.setBackgroundColor(sharedMemory.GetColor());

        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams(
                WindowManager.LayoutParams.FIRST_APPLICATION_WINDOW,
                WindowManager.LayoutParams.FIRST_APPLICATION_WINDOW,
                WindowManager.LayoutParams.TYPE_SYSTEM_DIALOG,
                280,
                PixelFormat.TRANSLUCENT
        );

        WindowManager windowManager = (WindowManager) getSystemService(Context.WINDOW_SERVICE);
        assert windowManager != null;

        windowManager.addView(view, layoutParams);
        STATE = STATE_ACTIVE;
    }

    @Override
    public void onDestroy(){
        super.onDestroy();
        WindowManager windowManager = (WindowManager) getSystemService(Context.WINDOW_SERVICE);
        assert  windowManager != null;
        windowManager.removeView(view);
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId){
        view.setBackgroundColor(sharedMemory.GetColor());
        return super.onStartCommand(intent, flags, startId);
    }
}