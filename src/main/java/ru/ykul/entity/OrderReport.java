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

        if(orderReport == null) {
            return "";
        }

        StringBuilder orderBuilder = new StringBuilder();
        for(Map.Entry<String, Integer> pairCompanyPrice : orderReport.entrySet()) {
            orderBuilder.append("<" + pairCompanyPrice.getKey() + ">" + " - " + "<" + pairCompanyPrice.getValue() + ">\n");
        }
        return orderBuilder.toString();
    }
}
