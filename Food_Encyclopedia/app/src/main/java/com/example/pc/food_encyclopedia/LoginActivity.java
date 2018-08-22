package com.example.pc.food_encyclopedia;

import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_layout);
        initScreens();

    }

    private void initScreens()
    {
        getSupportActionBar().hide();
        TextView textView=findViewById(R.id.welcome_foodes);
        Typeface type = Typeface.createFromAsset(getAssets(),"ZapChance.ttf");
        textView.setTypeface(type);
    }
}
