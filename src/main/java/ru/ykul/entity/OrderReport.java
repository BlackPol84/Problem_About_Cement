package ru.ykul.entity;

import java.util.Map;
import java.util.stream.Collectors;

public class OrderReport {

    private Map<String, Integer> orderReport;

    public OrderReport() {
    }

    public Map<String, Integer> getOrderReport() {
        return orderReport;
    }
    public void setOrderReport(Map<String, Integer> report) {
        this.orderReport = report;
    }

    @Override
    public String toString() {

        if(orderReport == null) {
            return "";
        }

        return orderReport.entrySet().stream().
                map(e -> "<" + e.getKey() + ">" + " - " + "<" + e.getValue() + ">\n").
                collect(Collectors.joining());
    }
}
