package com.example.ezyfood;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ezyfood.model.Order;

import java.util.List;

public class MyOrderViewAdapter extends RecyclerView.Adapter<MyOrderViewAdapter.MyOrderViewHolder> {

    List<Order> orderList;
    Context context;

    public MyOrderViewAdapter(Context c, List<Order> orderList) {
        this.context = c;
        this.orderList = orderList;
    }

    @NonNull
    @Override
    public MyOrderViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.my_order_row, parent, false);
        return new MyOrderViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyOrderViewHolder holder, int position) {
        holder.itemNameTextView.setText(orderList.get(position).getDrinks().getName());
        holder.priceTextView.setText(String.valueOf(orderList.get(position).getDrinks().getPrice()));
        holder.qtyTextView.setText(String.valueOf(orderList.get(position).getQty()));
    }

    @Override
    public int getItemCount() {
        return orderList.size();
    }

    public void removeItem (int position) {
        orderList.remove(position);
//        Constants.removeItemOrderList(position);
        notifyItemRemoved(position);
    }

    public class MyOrderViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView itemNameTextView, qtyTextView, priceTextView;
        Button deleteButton;
        public MyOrderViewHolder(View view) {
            super(view);
            itemNameTextView = view.findViewById(R.id.itemNameTextView);
            qtyTextView = view.findViewById(R.id.qtyTextView);
            priceTextView = view.findViewById(R.id.priceTextView);
            deleteButton = view.findViewById(R.id.deleteOrder);

            deleteButton.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            removeItem(getAdapterPosition());
        }
    }

}
