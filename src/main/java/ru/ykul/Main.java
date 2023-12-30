package ru.ykul;

import ru.ykul.adapter.OrderAdapterFactory;
import ru.ykul.manager.OrderManager;
import ru.ykul.service.FileOrderService;
import ru.ykul.service.OrderService;

public class Main {
    public static void main(String[] args) {
        FileOrderService fileOrderService = new FileOrderService();
        OrderAdapterFactory orderAdapterFactory = new OrderAdapterFactory();
        OrderService orderService = new OrderService();

        OrderManager manager = new OrderManager(fileOrderService, orderAdapterFactory, orderService);
        manager.saveOrderReport("discount_day.txt", "orders_report.txt", 0.5f, 0.05f);



    }
}