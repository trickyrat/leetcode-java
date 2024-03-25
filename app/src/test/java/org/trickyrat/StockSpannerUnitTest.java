package org.trickyrat;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class StockSpannerUnitTest {
    @Test
    public void test() {
        StockSpanner stockSpanner = new StockSpanner();
        Assertions.assertEquals(1, stockSpanner.next(100));
        Assertions.assertEquals(1, stockSpanner.next(80));
        Assertions.assertEquals(1, stockSpanner.next(60));
        Assertions.assertEquals(2, stockSpanner.next(70));
        Assertions.assertEquals(1, stockSpanner.next(60));
        Assertions.assertEquals(4, stockSpanner.next(75));
        Assertions.assertEquals(6, stockSpanner.next(85));
    }

}