package com.kumar.user.androidmvpunittesting;

import android.content.Context;
import android.content.Intent;

import com.kumar.user.androidmvpunittesting.main.MainActivity;

/**
 * Created by User on 6/28/2017.
 */

public class ActivityUtil {

    private Context context;

    public ActivityUtil(Context context) {
        this.context = context;
    }

    public void startMainActivity(){
        context.startActivity(new Intent(context, MainActivity.class));
    }
}
