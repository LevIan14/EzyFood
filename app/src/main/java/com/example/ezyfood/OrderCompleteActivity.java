package com.example.ezyfood;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class OrderCompleteActivity extends AppCompatActivity {

    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_complete);

        recyclerView = findViewById(R.id.recyclerViewOrderComplete);
        OrderCompleteViewAdapter orderCompleteViewAdapter = new OrderCompleteViewAdapter(this, Constants.getOrderList());
        recyclerView.setAdapter(orderCompleteViewAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        TextView totalOrder = findViewById(R.id.totalOrder);
        totalOrder.setText(String.valueOf(Constants.getGrandTotal()));

        Constants.clearOrderList();

    }

    public void goToMainActivity(View view) {
        Intent intent = new Intent("com.package.name.MyAction");
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
        finish();
    }
}
