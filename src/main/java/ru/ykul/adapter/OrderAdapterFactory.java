package ru.ykul.adapter;

public class OrderAdapterFactory {
    public OrderAdapter getOrderAdapter (String inputFile) {
        if(inputFile.indexOf('.') == -1) {
            return new FileNoneTypeOrderAdapter();
        } else {
            return new FileOrderAdapter();
        }
    }
}
