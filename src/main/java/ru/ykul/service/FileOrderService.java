package ru.ykul.service;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.BufferedReader;
import java.io.FileReader;

public class FileOrderService {
    private final static String PATH = FileOrderService.class.getResource("/storage/").getPath();
    public List<String> readingFile(String inPutFile) {
        String line;
        List<String> stringOrders = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(PATH + inPutFile))) {
            while ((line = reader.readLine()) != null) {
                stringOrders.add(line);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return stringOrders;
    }
    public void recordOrder(OrderReport orderReport, String outPutFile) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(PATH + outPutFile))) {
            //try (BufferedWriter writer = new BufferedWriter(new FileWriter(outPutFile))) {
            writer.write(orderReport.toString());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
