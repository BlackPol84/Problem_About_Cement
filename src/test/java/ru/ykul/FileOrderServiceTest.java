package ru.ykul;

import org.junit.jupiter.api.Test;
import ru.ykul.service.FileOrderService;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;


public class FileOrderServiceTest {

    FileOrderService fileOrderService = new FileOrderService();

    @Test
    void readFile_ifFileEmpty_returnArrayListEmpty() {
        List<String> stringOrders = new ArrayList<>();
        assertEquals(stringOrders, fileOrderService.readFile("isEmpty_test.txt"));
    }

    @Test
    void readFile_ifFileNotFound_throwRuntimeException() {
        assertThrows(RuntimeException.class, () -> {
            fileOrderService.readFile("Non-existent file");
        });
    }
}