package edu.hw3.Task6;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.util.Objects;

class StockMarketWithPriorityQueueTest {
    private static class TestStock implements Stock {
        private final float price;

        private TestStock(float price) {
            if (price < 0) {
                throw new IllegalArgumentException("stock price shouldn't be negative");
            }
            this.price = price;
        }

        @Override
        public float getPrice() {
            return price;
        }

        @Override public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (o == null || getClass() != o.getClass()) {
                return false;
            }
            TestStock testStock = (TestStock) o;
            return Float.compare(price, testStock.price) == 0;
        }

        @Override
        public int hashCode() {
            return Objects.hash(price);
        }
    }

    @Test
    void removeException() {
        StockMarket stockMarket = new StockMarketWithPriorityQueue();
        Assertions.assertThrows(
            RuntimeException.class,
            () -> stockMarket.remove(new TestStock(10))
        );
    }

    @Test
    void mostValuableStock() {
        StockMarket stockMarket = new StockMarketWithPriorityQueue();
        stockMarket.add(new TestStock(12));
        stockMarket.add(new TestStock(10));
        stockMarket.add(new TestStock(11));

        Assertions.assertEquals(12, stockMarket.mostValuableStock().getPrice());

        stockMarket.add(new TestStock(13));
        Assertions.assertEquals(13, stockMarket.mostValuableStock().getPrice());

        stockMarket.remove(new TestStock(13));
        Assertions.assertEquals(12, stockMarket.mostValuableStock().getPrice());

    }

    @Test
    void mostValuableStockException() {
        StockMarket stockMarket = new StockMarketWithPriorityQueue();
        Assertions.assertThrows(
            RuntimeException.class,
            stockMarket::mostValuableStock
        );
    }
}
