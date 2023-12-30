package ru.ykul;

import org.junit.jupiter.api.Test;
import ru.ykul.entity.OrderReport;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class OrderReportTest {

    @Test
    public void orderReport_ifMapEmpty_returnEmptyString() {
        Map<String, Integer> report = new HashMap<>();
        OrderReport orderReport = new OrderReport();
        orderReport.setOrderReport(report);
        assertEquals(new HashMap<>(), orderReport.getOrderReport());
    }



}
