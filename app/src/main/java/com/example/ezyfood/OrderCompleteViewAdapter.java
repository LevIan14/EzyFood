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

public class OrderCompleteViewAdapter extends RecyclerView.Adapter<OrderCompleteViewAdapter.OrderCompleteViewHolder> {

    List<Order> orderList;
    Context context;

    public OrderCompleteViewAdapter(Context c, List<Order> orderList) {
        this.context = c;
        this.orderList = orderList;
    }

    @NonNull
    @Override
    public OrderCompleteViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.order_completed_row, parent, false);
        return new OrderCompleteViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull OrderCompleteViewHolder holder, int position) {
        holder.itemNameTextView.setText(orderList.get(position).getDrinks().getName());
        holder.priceTextView.setText(String.valueOf(orderList.get(position).getDrinks().getPrice()));
        holder.qtyTextView.setText(String.valueOf(orderList.get(position).getQty()));
        holder.totalOrderTextView.setText(String.valueOf(orderList.get(position).getTotalPrice()));
    }

    @Override
    public int getItemCount() {
        return orderList.size();
    }

    public class OrderCompleteViewHolder extends RecyclerView.ViewHolder {
        TextView itemNameTextView, qtyTextView, priceTextView, totalOrderTextView;
        public OrderCompleteViewHolder(View view) {
            super(view);
            itemNameTextView = view.findViewById(R.id.itemNameOrderComplete);
            qtyTextView = view.findViewById(R.id.qtyOrderComplete);
            priceTextView = view.findViewById(R.id.priceOrderComplete);
            totalOrderTextView = view.findViewById(R.id.totalOrderPerItem);
        }

    }

}
