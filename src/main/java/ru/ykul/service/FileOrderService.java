package ru.ykul.service;

import ru.ykul.entity.OrderReport;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class FileOrderService {

    private final static String PATH = FileOrderService.class.getResource("/storage/").getPath();

    public List<String> readFile(String inputFile) {

        try {
            return Files.lines(Path.of(PATH.replaceFirst("^/(.:/)", "$1") + inputFile)).toList();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void recordOrder(OrderReport orderReport, String outPutFile) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(PATH + outPutFile))) {
            writer.write(orderReport.toString());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
