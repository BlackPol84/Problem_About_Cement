package ru.ykul.service;

import java.util.*;

public class OrderService {
    //цена цемента за 1 кг
    private final int CEMENT_PRICE = 10;
    public OrderReport getReport(List<Order> orders, double discount, double discountDiff) {
        Map<String, Integer> finalOrders = new HashMap<>();

        Comparator<Order> comparator = Comparator.comparing(obj -> obj.getOrderTime());
        Collections.sort(orders, comparator);

        for(Order receivedOrder : orders) {
            int costOrder = orderCalculation(receivedOrder, discount);
            finalOrders.merge(receivedOrder.getCompany(),costOrder, (oldVal, newVal) -> oldVal + newVal);
            if(discount == 0) {
                discount = 0;
            } else {
                discount = discount + discountDiff < 1 ? discount + discountDiff : 0;}
        }

        OrderReport orderReport = new OrderReport();
        orderReport.setOrderReport(finalOrders);

        return orderReport;
    }
    private int orderCalculation(Order receivedOrder, double discount) {
        return (int) (((receivedOrder.getAmountOfCement())*CEMENT_PRICE)*(1 - discount));
    }
}
