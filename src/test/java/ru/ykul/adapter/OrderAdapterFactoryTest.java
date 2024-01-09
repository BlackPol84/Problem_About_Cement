package ru.ykul.adapter;

import org.junit.jupiter.api.Test;
import ru.ykul.adapter.FileNoneTypeOrderAdapter;
import ru.ykul.adapter.FileOrderAdapter;
import ru.ykul.adapter.OrderAdapterFactory;

import static org.junit.jupiter.api.Assertions.*;

public class OrderAdapterFactoryTest {

    OrderAdapterFactory orderAdapterFactory = new OrderAdapterFactory();

    @Test
    void getOrderAdapter_ifInputFileNull_throwIllegalArgumentException() {
        assertThrows(IllegalArgumentException.class, () -> {
            orderAdapterFactory.getOrderAdapter(null);
        });
    }

    @Test
    void getOrderAdapter_ifInputFileEmpty_throwIllegalArgumentException() {
        assertThrows(IllegalArgumentException.class, () -> {
            orderAdapterFactory.getOrderAdapter("");
        });
    }

    @Test
    void getOrderAdapter_ifInputFileWithExtension_returnFileOrderAdapter() {
        assertTrue(orderAdapterFactory.getOrderAdapter("discount_day_test.txt") instanceof FileOrderAdapter);
    }

    @Test
    void getOrderAdapter_ifInputFileWithoutExtension_returnFileNoneTypeOrderAdapter() {
        assertTrue(orderAdapterFactory.getOrderAdapter("discount_day_dollar_test") instanceof FileNoneTypeOrderAdapter);
    }
}
