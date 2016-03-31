package com.drinktheapp.drink;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.os.Handler;

public class MainPage extends Activity {


    final int SPLASH_DISPLAY_LENGTH = 1000;

    @Override
    public void onCreate(Bundle icicle) {
        super.onCreate(icicle);
        setContentView(R.layout.splash);



        new Handler().postDelayed(new Runnable(){
            @Override
            public void run() {
                Intent newIntent = new Intent(MainPage.this,MainList.class);
                MainPage.this.startActivity(newIntent);
                MainPage.this.finish();
            }
        }, SPLASH_DISPLAY_LENGTH);
    }
}
