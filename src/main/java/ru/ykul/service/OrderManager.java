package ru.ykul.service;

import java.util.List;

public class OrderManager {
    private FileOrderService fileOrderService;
    private FileOrderAdapter fileOrderAdapter;
    private OrderService orderService;
    public OrderManager(FileOrderService fileOrderService, FileOrderAdapter fileOrderAdapter, OrderService orderService) {
        this.fileOrderService = fileOrderService;
        this.fileOrderAdapter = fileOrderAdapter;
        this.orderService = orderService;
    }
    public void calculationManagement(String inPutFile, double discount, double discountDiff, String outPutFile) {
        List<String> stringOrders = fileOrderService.readingFile(inPutFile);
        List<Order> orders = fileOrderAdapter.parseOrder(stringOrders);
        OrderReport orderReport = orderService.getReport(orders, discount, discountDiff);
        fileOrderService.recordOrder(orderReport, outPutFile);
    }
}