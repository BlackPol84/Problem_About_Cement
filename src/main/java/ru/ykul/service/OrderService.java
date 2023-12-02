package ru.ykul.service;

import ru.ykul.entity.Order;
import ru.ykul.entity.OrderReport;

import java.util.*;

public class OrderService {

    private final int CEMENT_PRICE = 10;

    public OrderReport getReport(List<Order> orders, double discount, double discountDiff) {
        Map<String, Integer> report = new HashMap<>();

        Collections.sort(orders, Comparator.comparing(Order::getOrderTime));

        for(Order receivedOrder : orders) {
            int costOrder = calcCost(receivedOrder, discount);
            report.merge(receivedOrder.getCompany(),costOrder, (oldVal, newVal) -> oldVal + newVal);
            discount = Math.max(discount - discountDiff, 0);
        }

        OrderReport orderReport = new OrderReport();
        orderReport.setOrderReport(report);

        return orderReport;
    }

    private int calcCost(Order receivedOrder, double discount) {
        return (int) (((receivedOrder.getAmountOfCement())*CEMENT_PRICE)*(1 - discount));
    }
}
