package ru.ykul;

import org.junit.jupiter.api.Test;
import ru.ykul.adapter.FileNoneTypeOrderAdapter;
import ru.ykul.adapter.FileOrderAdapter;
import ru.ykul.adapter.OrderAdapterFactory;

import static org.junit.jupiter.api.Assertions.*;

public class OrderAdapterFactoryTest {

    OrderAdapterFactory orderAdapterFactory = new OrderAdapterFactory();

    @Test
    void OrderAdapterFactory_ifInputFileNull_throwIllegalArgumentException() {
        assertThrows(IllegalArgumentException.class, () -> {
            orderAdapterFactory.getOrderAdapter(null);
        });
    }

    @Test
    void OrderAdapterFactory_ifInputFileIsEmpty_throwIllegalArgumentException() {
        assertThrows(IllegalArgumentException.class, () -> {
            orderAdapterFactory.getOrderAdapter("");
        });
    }

    @Test
    void OrderAdapterFactory_ifInputFileWithExtension_returnFileOrderAdapter() {
        assertTrue(orderAdapterFactory.getOrderAdapter("discount_day_test.txt") instanceof FileOrderAdapter);
    }

    @Test
    void OrderAdapterFactory_ifInputFileWithoutExtension_returnFileNoneTypeOrderAdapter() {
        assertTrue(orderAdapterFactory.getOrderAdapter("discount_day_dollar_test") instanceof FileNoneTypeOrderAdapter);
    }
}
