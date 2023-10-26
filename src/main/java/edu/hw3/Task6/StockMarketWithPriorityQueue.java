package edu.hw3.Task6;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class StockMarketWithPriorityQueue implements StockMarket {
    private final Comparator<Stock> compareByPrice = (o1, o2) -> -Float.compare(o1.getPrice(), o2.getPrice());
    private final Queue<Stock> stockQueue = new PriorityQueue<>(compareByPrice);

    /**
     * add the stock to the list of stock
     *
     * @param stock the element to add
     */
    @Override
    public void add(Stock stock) {
        stockQueue.add(stock); //return true -> no reason to check
    }

    /**
     * remove the stock to the list of stock
     *
     * @param stock the element to be removed
     */
    @Override
    public void remove(Stock stock) {
        if (!stockQueue.remove(stock)) {
            throw new RuntimeException("Failed to remove the stock");
        }

    }

    /**
     * gets the most valuable stock in stock list
     *
     * @return he most valuable the stock
     */
    @Override
    public Stock mostValuableStock() {
        if (stockQueue.isEmpty()) {
            throw new RuntimeException("Can't return the most valuable stock. The stock list is empty!");
        }
        return stockQueue.peek();
    }
}
