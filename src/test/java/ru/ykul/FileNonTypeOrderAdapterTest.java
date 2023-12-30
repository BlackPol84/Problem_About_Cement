package ru.ykul;

import org.junit.jupiter.api.Test;
import ru.ykul.adapter.FileNoneTypeOrderAdapter;
import ru.ykul.adapter.FileOrderAdapter;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FileNonTypeOrderAdapterTest {

    @Test
    void fileNonTypeOrderAdapter_ifStringOrdersEmpty_returnEmptyOrders() {
        List<String> stringOrders = new ArrayList<>();
        FileNoneTypeOrderAdapter fileNoneTypeOrderAdapter = new FileNoneTypeOrderAdapter();
        assertEquals(0, fileNoneTypeOrderAdapter.parseOrder(stringOrders).size());

    }
}
