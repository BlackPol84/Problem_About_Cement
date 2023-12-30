package ru.ykul.manager;

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

    private void validate(String inputFile, String outputFile, double discount, double discountDiff) {
        if(inputFile == null || inputFile.isEmpty()) {
            throw new IllegalArgumentException("The file name for reading is set incorrectly");
        }
        if(outputFile == null || outputFile.isEmpty()) {
            throw new IllegalArgumentException("The file name for the record is set incorrectly");
        }
        if(discount < 0 || discountDiff < 0) {
            throw new IllegalArgumentException("The discount cannot be negative");
        }
    }

    public void saveOrderReport(String inputFile, String outputFile, double discount, double discountDiff) {

        validate(inputFile, outputFile, discount, discountDiff);

        try {
            List<String> stringOrders = fileOrderService.readFile(inputFile);
            OrderAdapter orderAdapter = orderAdapterFactory.getOrderAdapter(inputFile);
            List<Order> orders = orderAdapter.parseOrder(stringOrders);
            OrderReport orderReport = orderService.getReport(orders, discount, discountDiff);
            fileOrderService.recordOrder(orderReport, outputFile);
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage(), e);
        }
    }
}