package ru.ykul;

import ru.ykul.adapter.FileOrderAdapter;
import ru.ykul.adapter.OrderAdapterFactory;
import ru.ykul.service.FileOrderService;
import ru.ykul.manager.OrderManager;
import ru.ykul.service.OrderService;

public class Main {
    public static void main(String[] args) {
        FileOrderService fileOrderService = new FileOrderService();
        OrderAdapterFactory orderAdapterFactory = new OrderAdapterFactory();
        OrderService orderService = new OrderService();

        OrderManager manager = new OrderManager(fileOrderService, orderAdapterFactory, orderService);
        manager.saveOrderReport("discount_day_dollar", "discount_day_dollar.txt", 0.5f, 0.05f);



    }
}