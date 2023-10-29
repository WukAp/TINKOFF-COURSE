package edu.hw3.Task6;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class StockMarketWithPriorityQueueTest {
    private record TestStock(int price) implements Stock {
        private TestStock {
            if (price < 0) {
                throw new IllegalArgumentException("stock price shouldn't be negative");
            }
        }

            @Override public boolean equals(Object o) {
                if (this == o) {
                    return true;
                }
                if (o == null || getClass() != o.getClass()) {
                    return false;
                }
                TestStock testStock = (TestStock) o;
                return price == testStock.price;
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

        Assertions.assertEquals(12, stockMarket.mostValuableStock().price());

        stockMarket.add(new TestStock(13));
        Assertions.assertEquals(13, stockMarket.mostValuableStock().price());

        stockMarket.remove(new TestStock(13));
        Assertions.assertEquals(12, stockMarket.mostValuableStock().price());

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
