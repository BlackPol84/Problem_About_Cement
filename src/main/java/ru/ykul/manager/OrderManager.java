package ru.ykul.manager;

import ru.ykul.adapter.FileOrderAdapter;
import ru.ykul.adapter.OrderAdapter;
import ru.ykul.adapter.OrderAdapterFactory;
import ru.ykul.entity.Order;
import ru.ykul.entity.OrderReport;
import ru.ykul.service.FileOrderService;
import ru.ykul.service.OrderService;

import java.util.List;

public class OrderManager {

    private final FileOrderService fileOrderService;
    private final OrderAdapterFactory orderAdapterFactory;
    private final OrderService orderService;

    public OrderManager(FileOrderService fileOrderService, OrderAdapterFactory orderAdapterFactory, OrderService orderService) {
        this.fileOrderService = fileOrderService;
        this.orderAdapterFactory = orderAdapterFactory;
        this.orderService = orderService;
    }

    public void saveOrderReport(String inputFile, String outputFile, double discount, double discountDiff) {
        List<String> stringOrders = fileOrderService.readFile(inputFile);
        OrderAdapter orderAdapter = orderAdapterFactory.getOrderAdapter(inputFile);
        List<Order> orders = orderAdapter.parseOrder(stringOrders);
        OrderReport orderReport = orderService.getReport(orders, discount, discountDiff);
        fileOrderService.recordOrder(orderReport, outputFile);
    }
}