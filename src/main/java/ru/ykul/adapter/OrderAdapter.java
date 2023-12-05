package ru.ykul.adapter;

import ru.ykul.entity.Order;

import java.util.List;

public interface OrderAdapter {
    List<Order> parseOrder (List<String> stringOrders);
}
