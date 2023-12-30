package ru.ykul;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.ykul.adapter.FileOrderAdapter;
import ru.ykul.adapter.OrderAdapterFactory;
import ru.ykul.entity.Order;
import ru.ykul.entity.OrderReport;
import ru.ykul.manager.OrderManager;
import ru.ykul.service.FileOrderService;
import ru.ykul.service.OrderService;

import java.time.LocalDateTime;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class OrderManagerTest {

    @InjectMocks
    OrderManager orderManager;
    @Mock
    FileOrderService fileOrderServiceMock;
    @Mock
    OrderAdapterFactory orderAdapterFactoryMock;
    @Mock
    OrderService orderServiceMock;

    @Test
    void orderManager_checkingMethodInvocation() {

        List<String> stringOrders = new ArrayList<>();
        stringOrders.add("2021-02-09T16:00:22|Industrial|9000");
        stringOrders.add("2021-02-11T08:42:59|Power Engineer Comp|88000");

        List<Order> orders = new ArrayList<>();
        Order order1 = new Order(LocalDateTime.of(2021, 2, 9, 16, 0, 22),"Industrial",9000);
        Order order2 = new Order(LocalDateTime.of(2021,2,11,8,42,59),"Power Engineer Comp",88000);
        orders.add(order1);
        orders.add(order2);

        Map<String, Integer> report = new HashMap<>();
        report.put("Industrial", 4500);
        report.put("Power Engineer Comp", 48400);

        OrderReport orderReport = new OrderReport();
        orderReport.setOrderReport(report);

        FileOrderAdapter fileOrderAdapterMock = Mockito.mock(FileOrderAdapter.class);

        when(fileOrderServiceMock.readFile("discount_day_test.txt")).thenReturn(stringOrders);
        when(orderAdapterFactoryMock.getOrderAdapter("discount_day_test.txt")).thenReturn(fileOrderAdapterMock);
        when(fileOrderAdapterMock.parseOrder(stringOrders)).thenReturn(orders);
        when(orderServiceMock.getReport(orders,0.5f, 0.05f)).thenReturn(orderReport);

        orderManager = new OrderManager(fileOrderServiceMock, orderAdapterFactoryMock, orderServiceMock);
        orderManager.saveOrderReport("discount_day_test.txt", "orders_report_test.txt", 0.5f, 0.05f);

        Mockito.verify(fileOrderServiceMock).readFile("discount_day_test.txt");
        Mockito.verify(orderAdapterFactoryMock).getOrderAdapter("discount_day_test.txt");
        Mockito.verify(fileOrderAdapterMock).parseOrder(stringOrders);
        Mockito.verify(orderServiceMock).getReport(orders,0.5f, 0.05f);
        Mockito.verify(fileOrderServiceMock).recordOrder(orderReport, "orders_report_test.txt");
    }

    @Test
    void saveOrderReport_ifInPutFileNull_throwIllegalArgumentException() {
        assertThrows(IllegalArgumentException.class, () -> {
            orderManager.saveOrderReport(null, "orders_report_test.txt", 0.5f, 0.05f);
        });
    }

    @Test
    void saveOrderReport_ifInPutFileEmpty_throwIllegalArgumentException() {
        assertThrows(IllegalArgumentException.class, () -> {
            orderManager.saveOrderReport("", "orders_report_test.txt", 0.5f, 0.05f);
        });
    }

    @Test
    void saveOrderReport_ifInPutFileIncorrect_throwRuntimeException() {
        assertThrows(RuntimeException.class, () -> {
            orderManager.saveOrderReport("discount_day_incorrect.txt", "orders_report_test.txt", 0.5f, 0.05f);
        });
    }

    @Test
    void saveOrderReport_ifOutPutFileNull_throwIllegalArgumentException() {
        assertThrows(IllegalArgumentException.class, () -> {
            orderManager.saveOrderReport("discount_day_test.txt", null, 0.5f, 0.05f);
        });
    }

    @Test
    void saveOrderReport_ifOutPutFileEmpty_throwIllegalArgumentException() {
        assertThrows(IllegalArgumentException.class, () -> {
            orderManager.saveOrderReport("discount_day_test.txt", "", 0.5f, 0.05f);
        });
    }

    @Test
    void saveOrderReport_ifDiscountLessThanZero_throwIllegalArgumentException() {
        assertThrows(IllegalArgumentException.class, () -> {
            orderManager.saveOrderReport("discount_day_test.txt", "orders_report_test.txt", -0.5f, 0.05f);
        });
    }

    @Test
    void saveOrderReport_ifDiscountDiffLessThanZero_throwIllegalArgumentException() {
        assertThrows(IllegalArgumentException.class, () -> {
            orderManager.saveOrderReport("discount_day_test.txt", "orders_report_test.txt", 0.5f, -0.05f);
        });
    }
}
