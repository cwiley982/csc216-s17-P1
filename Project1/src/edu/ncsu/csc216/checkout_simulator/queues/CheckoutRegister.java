/**
 * 
 */
package edu.ncsu.csc216.checkout_simulator.queues;

import edu.ncsu.csc216.checkout_simulator.items.Cart;
import edu.ncsu.csc216.checkout_simulator.simulation.Log;

/**
 * @author Caitlyn
 *
 */
public class CheckoutRegister {

	/** The ShoppingCartQueue of carts waiting for or being processed at this register. */
	private ShoppingCartQueue line;
	private Log log;
	/** The time when the line for this checkout register will finally be clear all of carts currently in line. */
	private int timeWhenAvailable;
	/**
	 * 
	 */
	public CheckoutRegister(Log log) {
		this.log = log;
		line = new ShoppingCartQueue();
	}

	public int size() {
		return line.size();
	}
	
	public Cart processNext() {
		log.logCart(line.front());
		return line.remove();
	}
	
	public boolean hasNext() {
		return !line.isEmpty();
	}
	
	public int departTimeNext() {
		if (!line.isEmpty()) {
			return line.front().getArrivalTime() + line.front().getWaitTime() + line.front().getProcessTime();
		} else {
			return Integer.MAX_VALUE;
		}
	}
	
	public void addCartToLine(Cart cart) {
		line.add(cart);
		cart.setWaitTime(timeWhenAvailable - cart.getArrivalTime());
		timeWhenAvailable += cart.getProcessTime();
	}
}
