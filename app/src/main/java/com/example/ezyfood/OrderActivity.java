package com.example.ezyfood;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.ezyfood.model.Drinks;
import com.example.ezyfood.model.Order;

import java.util.ArrayList;

public class OrderActivity extends AppCompatActivity {

    int qty = 1;
    TextView qtyView;
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);

        intent = getIntent();
        String itemName = intent.getStringExtra("Drink Name");
        TextView name = findViewById(R.id.nameItem);
        TextView price = findViewById(R.id.priceItem);
        ImageView itemImage = findViewById(R.id.imageItem);

        name.setText(itemName);
        price.setText(intent.getStringExtra("Drink Price"));

        if(itemName.equals("Water")) {
            itemImage.setImageDrawable(getDrawable(R.drawable.mineralwater));
        }
        else if(itemName.equals("Milk")) {
            itemImage.setImageDrawable(getDrawable(R.drawable.milk));
        }
        else if(itemName.equals("Coffee")) {
            itemImage.setImageDrawable(getDrawable(R.drawable.coffee));
        }
        else if(itemName.equals("Tea")) {
            itemImage.setImageDrawable(getDrawable(R.drawable.tea));
        }

        qtyView = findViewById(R.id.qtyItem);

        qtyView.setText(String.valueOf(qty));
    }

    public void addQty(View view) {
        qty++;
        qtyView.setText(String.valueOf(qty));
    }

    public void minQty(View view) {
        if(qty > 1) qty--;
        qtyView.setText(String.valueOf(qty));
    }

    public void goToDrinks(View view) {
        addOrderList();
        Intent i = new Intent(this, DrinksActivity.class);
        startActivity(i);
        finish();
    }

    public void goToMyOrder(View view) {
        addOrderList();
        Intent intent = new Intent(this, MyOrderActivity.class);
        startActivity(intent);
        finish();
    }

    public void addOrderList() {
        String name = intent.getStringExtra("Drink Name");
        int price = Integer.parseInt(intent.getStringExtra("Drink Price"));
        int totalPrice = 0;
        ArrayList<Order> lists = Constants.getOrderList();

        if(lists.isEmpty()) {
            totalPrice = price * qty;
            Order newOrder = new Order(new Drinks(name, price), qty, totalPrice);
            lists.add(newOrder);
            Constants.updateOrderList(lists);
        }
        else {
            boolean isExist = false;
            for(int i = 0 ; i < lists.size() ; i++) {
                if(lists.get(i).getDrinks().getName().equals(name)) {
                    isExist = true;
                    lists.get(i).addQty(qty);
                    totalPrice = price * qty;
                    lists.get(i).addTotalPrice(totalPrice);
                    Constants.updateOrderList(lists);
                    break;
                }
            }
            if(!isExist) {
                totalPrice = price * qty;
                Order newOrder = new Order(new Drinks(name, price), qty, totalPrice);
                lists.add(newOrder);
                Constants.updateOrderList(lists);
            }
        }
    }




}
