package ru.ykul;

import org.junit.jupiter.api.Test;
import ru.ykul.adapter.FileOrderAdapter;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FileOrderAdapterTest {

    @Test
    void fileOrderAdapter_ifStringOrdersEmpty_returnEmptyOrders() {
        List<String> stringOrders = new ArrayList<>();
        FileOrderAdapter fileOrderAdapter = new FileOrderAdapter();
        assertEquals(0, fileOrderAdapter.parseOrder(stringOrders).size());

    }
}
