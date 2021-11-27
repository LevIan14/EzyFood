package com.example.ezyfood;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void goToDrinksActivity(View view) {
        Intent intent = new Intent(this, DrinksActivity.class);
        startActivity(intent);
    }

    public void goToMyOrderActivity(View view) {
        Intent intent = new Intent(this, MyOrderActivity.class);
        startActivity(intent);
    }
}