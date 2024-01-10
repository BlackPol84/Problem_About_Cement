package ru.ykul.service;

import org.junit.jupiter.api.Test;
import ru.ykul.entity.Order;
import ru.ykul.entity.OrderReport;
import ru.ykul.service.OrderService;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class OrderServiceTest {

    OrderService orderService = new OrderService();

    @Test
    void getReport_ifOrdersEmpty_returnEmptyOrderReport() {
        List<Order> orders = new ArrayList<>();
        OrderReport orderReport = orderService.getReport(orders,0.5f, 0.05f);
        assertEquals(0, orderReport.getOrderReport().size());
    }

    @Test
    void getReport_ifDiscountAndDiscountDiffZero_returnCostWithoutDiscount() {
        List<Order> orders = new ArrayList<>();
        orders.add(new Order(LocalDateTime.of(2021, 2, 9, 16, 0, 22),"Industrial",9000));
        OrderReport orderReport = orderService.getReport(orders, 0f, 0f);
        assertEquals(90000, orderReport.getOrderReport().get("Industrial"));
    }
}
