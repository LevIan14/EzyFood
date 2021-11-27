package com.example.ezyfood;

import com.example.ezyfood.model.Order;

import java.util.ArrayList;
import java.util.List;

public class Constants {

    private static ArrayList<Order> orderList = new ArrayList<>();

    public static ArrayList<Order> getOrderList() {
        return orderList;
    }

    public static void updateOrderList(ArrayList<Order> lists) {
        orderList = lists;
    }

    public static int getGrandTotal() {
        int total = 0;
        for(int i = 0 ; i < orderList.size() ; i++) {
            total += orderList.get(i).getTotalPrice();
        }
        return total;
    }

    public static void clearOrderList() {
        orderList = new ArrayList<>();
    }
}
