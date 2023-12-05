package ru.ykul.entity;

import java.util.Map;

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
        StringBuilder orderBuilder = new StringBuilder();
        for(String company : orderReport.keySet()) {
            orderBuilder.append("<" + company + ">" + " - " + "<" + orderReport.get(company) + ">\n");
        }
        return orderBuilder.toString();
    }
}
