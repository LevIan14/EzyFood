package com.example.ezyfood;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class MyOrderActivity extends AppCompatActivity {

    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_order);

        recyclerView = findViewById(R.id.myOrderRecyclerView);
        MyOrderViewAdapter myOrderViewAdapter = new MyOrderViewAdapter(this, Constants.getOrderList());
        recyclerView.setAdapter(myOrderViewAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    public void goToOrderComplete(View view) {
        if(Constants.getOrderList().isEmpty()) {
            Toast.makeText(this, "You have no order list!", Toast.LENGTH_SHORT).show();
        }
        else {
            Intent intent = new Intent(this, OrderCompleteActivity.class);
            startActivity(intent);
            finish();
        }

    }
}
