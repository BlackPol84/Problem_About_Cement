package ru.ykul;

import ru.ykul.service.FileOrderAdapter;
import ru.ykul.service.FileOrderService;
import ru.ykul.service.OrderManager;
import ru.ykul.service.OrderService;

public class Main {
    public static void main(String[] args) {
        FileOrderService fileOrderService = new FileOrderService();
        FileOrderAdapter fileOrderAdapter = new FileOrderAdapter();
        OrderService orderService = new OrderService();

        OrderManager manager = new OrderManager(fileOrderService, fileOrderAdapter, orderService);
        manager.calculationManagement("discount_day.txt", 0.5f, 0.05f, "orders_report.txt");



    }
}