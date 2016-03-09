package hackerrank;

import java.util.Scanner;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution_Matcher {

    private final Scanner scanner;
    private final BufferedWriter writer;

    public Solution_Matcher(Scanner scanner, BufferedWriter writer) {
        this.scanner = scanner;
        this.writer = writer;
    }
    
    
    /*
     * Add state to retain book of previous orders.
     */
    
    private Map<String, LinkedList<Order>> unmatchedOrders = new HashMap<>();

    /**
     * Your matching engine.
     *
     * @param order - order to add
     *
     * @return list of order ids for orders that match the given order ordered oldest to newest.
     */
	public List<Long> match(Order order) {
		// TODO add implementation here

		List<Long> matchingOrderIds = new ArrayList<>();

		if (order == null || order.product == null) {
			return matchingOrderIds;
		}

		LinkedList<Order> prevOrders = unmatchedOrders.get(order.product);

		if (prevOrders == null) {
			prevOrders = new LinkedList<Order>();
			unmatchedOrders.put(order.product, prevOrders);
		}

		Iterator<Order> iter = prevOrders.iterator();

		while(iter.hasNext()) {

			Order prevOrder = iter.next();

			if (prevOrder.customerSide == order.customerSide) {
				continue;
			}

			// matching BUY or SELL
			matchingOrderIds.add(prevOrder.orderId);

			// maintain orders state
			if (prevOrder.size > order.size) {
				prevOrder.size -= order.size;
				break;
			} else if (prevOrder.size < order.size) {
				order.size -= prevOrder.size;
				iter.remove();
			} else {
				iter.remove();
				break;
			}
		}

		if (order.size > 0) {
			prevOrders.add(order);
		}

		return matchingOrderIds;
	}

    private void processOrders() throws IOException {
        while (scanner.hasNext()) {
            Order order = readOrder();
            writeMatches(match(order));
        }
        writer.close();
    }

     private Order readOrder() {
        final long orderId = scanner.nextLong();
        final String product = scanner.next();
        final Side customerSide = Side.valueOf(scanner.next());
        final long size = scanner.nextLong();
        return new Order(orderId, product, customerSide, size);
    }

    private void writeMatches(List<Long> matchingIds) throws IOException {
        int length = matchingIds.size();
        writer.write(length + " matches: ");
        for (int i = 0; i < length; i++) {
            writer.write(String.valueOf(matchingIds.get(i)));
            if (i < length - 1) {
                writer.write(',');
            }
        }
        writer.newLine();
    }

    public static void main(String[] args) throws IOException {

    	
    	
    	
        Scanner in = new Scanner(System.in);
        final String fileName = System.getenv("OUTPUT_PATH");
        BufferedWriter out = new BufferedWriter(new FileWriter(fileName));

        Solution_Matcher m = new Solution_Matcher(in, out);
        m.processOrders();
    }

    private static class Order {
        /**
         * Unique id for this order. Guaranteed by source system to be unique
         */
        final long orderId;
        /**
         * Key for the financial product the customer wishes to trade.
         * Two orders are for the same product if order1.product.equals(order2.product)
         */
        final String product;
        /**
         * BUY if customer wishes to buy the product, SELL if they wish to sell.
         */
        final Side customerSide;
        /**
         * The amount of the order in AUD cents. For new orders, it will always be a non-zero positive value.
         */
        long size;

        public Order(long orderId, String product, Side customerSide, long size) {
            this.orderId = orderId;
            this.product = product;
            this.customerSide = customerSide;
            this.size = size;
        }
    }

    private enum Side { BUY, SELL }
}
