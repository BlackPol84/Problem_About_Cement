package ru.ykul.adapter;

public class OrderAdapterFactory {
    public OrderAdapter determineFileType (String inputFile) {
        if(inputFile.indexOf('.') == -1) {
            return new FileNonTypeOrderAdapter();
        } else {
            return new FileOrderAdapter();
        }
    }
}
