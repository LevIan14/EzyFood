package com.example.ezyfood;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.ezyfood.model.Drinks;

import java.util.ArrayList;
import java.util.List;

public class DrinksActivity extends AppCompatActivity {

    Drinks d1 = new Drinks("Water", 3000);
    Drinks d2 = new Drinks("Milk", 5000);
    Drinks d3 = new Drinks("Coffee", 8000);
    Drinks d4 = new Drinks("Tea", 7000);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drink);

        Button mineralWater = findViewById(R.id.button_mineralwater);
        mineralWater.setText(d1.getName());

        Button milk = findViewById(R.id.button_milk);
        milk.setText(d2.getName());

        Button coffee = findViewById(R.id.button_coffee);
        coffee.setText(d3.getName());

        Button tea = findViewById(R.id.button_tea);
        tea.setText(d4.getName());

    }

    public void goToMyOrderActivity(View view) {
        Intent intent = new Intent(this, MyOrderActivity.class);
        startActivity(intent);
        finish();
    }

    public void goToOrderActivity(View view) {
        Intent intent = new Intent(this, OrderActivity.class);

        if(view.getId() == R.id.button_mineralwater || view.getId() == R.id.image_mineralwater) {
            intent.putExtra("Drink Name", d1.getName());
            intent.putExtra("Drink Price", Integer.toString(d1.getPrice()));
        }
        else if(view.getId() == R.id.button_milk || view.getId() == R.id.image_milk) {
            intent.putExtra("Drink Name", d2.getName());
            intent.putExtra("Drink Price", Integer.toString(d2.getPrice()));
        }
        else if(view.getId() == R.id.button_coffee || view.getId() == R.id.image_coffee) {
            intent.putExtra("Drink Name", d3.getName());
            intent.putExtra("Drink Price", Integer.toString(d3.getPrice()));
        }
        else if(view.getId() == R.id.button_tea || view.getId() == R.id.image_tea) {
            intent.putExtra("Drink Name", d4.getName());
            intent.putExtra("Drink Price", Integer.toString(d4.getPrice()));
        }

        startActivity(intent);
        finish();
    }




}
