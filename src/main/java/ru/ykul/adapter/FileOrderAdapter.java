package ru.ykul.adapter;

import ru.ykul.entity.Order;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class FileOrderAdapter implements OrderAdapter {
    @Override
    public List<Order> parseOrder (List<String> stringOrders) {
        List<Order> orders = new ArrayList<>();

        for (String lineOder : stringOrders) {
            orders.add(toOrder(lineOder));
        }
        return orders;
    }

    private Order toOrder(String lineOrder) {
        String[] orderParts = lineOrder.split("\\|");

        LocalDateTime orderTime = LocalDateTime.parse(orderParts[0]);
        String company = orderParts[1];
        int amountOfCement = Integer.parseInt(orderParts[2]);

        return new Order(orderTime, company, amountOfCement);
    }
}
