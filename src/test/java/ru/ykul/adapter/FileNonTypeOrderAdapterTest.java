package ru.ykul.adapter;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class FileNonTypeOrderAdapterTest {

    FileNoneTypeOrderAdapter fileNoneTypeOrderAdapter = new FileNoneTypeOrderAdapter();

    @Test
    void parseOrder_ifContainsEmpty_shouldReturnEmpty() {
        List<String> stringOrders = new ArrayList<>();
        assertEquals(0, fileNoneTypeOrderAdapter.parseOrder(stringOrders).size());
    }

    @Test
    void parseOrder_ifStringOrdersNull_throwRuntimeException() {
        assertThrows(RuntimeException.class, () -> {
            fileNoneTypeOrderAdapter.parseOrder(null);
        });
    }

    @Test
    void parseOrder_ifStringOrdersIncorrect_throwRuntimeException() {
        List<String> stringOrders = new ArrayList<>();
        stringOrders.add("|Industrial|8800");
        assertThrows(RuntimeException.class, () -> {
            fileNoneTypeOrderAdapter.parseOrder(stringOrders);
        });
    }
}
