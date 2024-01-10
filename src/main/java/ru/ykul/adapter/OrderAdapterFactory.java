package ru.ykul.adapter;

public class OrderAdapterFactory {
    public OrderAdapter getOrderAdapter (String inputFile) {
        if(inputFile == null || inputFile.isEmpty()) {
            throw new IllegalArgumentException("The file name for reading is set incorrectly");
        }

        if(inputFile.indexOf('.') == -1) {
            return new FileNoneTypeOrderAdapter();
        } else {
            return new FileOrderAdapter();
        }
    }
}
