/**
 * 
 */
package edu.ncsu.csc216.checkout_simulator.queues;

import java.util.NoSuchElementException;

import edu.ncsu.csc216.checkout_simulator.items.Cart;
import edu.ncsu.csc216.checkout_simulator.simulation.Log;

/**
 * Creates a checkout register that keeps track of the carts in line for that
 * register
 * 
 * @author Caitlyn Wiley
 *
 */
public class CheckoutRegister implements LineOfItems {

	/** The ShoppingCartQueue of carts waiting for or being processed at this register. */
	private ShoppingCartQueue line;
	/** The Log where carts will log their data upon exiting register line */
	private Log log;
	/** The time when the line for this checkout register will finally be clear all of carts currently in line. */
	private int timeWhenAvailable;

	/**
	 * Constructs a CheckoutRegister with a log to store cart data
	 * 
	 * @param log
	 *            the log where carts will log their data
	 */
	public CheckoutRegister(Log log) {
		this.log = log;
		line = new ShoppingCartQueue();
		timeWhenAvailable = 0;
	}

	/**
	 * Returns the size of the line for a register
	 * 
	 * @return the number of carts in line for the register
	 */
	@Override
	public int size() {
		return line.size();
	}
	
	/**
	 * Logs the next carts info and removes it from the line for the register
	 * 
	 * @return the cart that was processed
	 */
	@Override
	public Cart processNext() {
		if (hasNext()) {
			log.logCart(line.front());
			line.front().removeFromWaitingLine();
			return line.remove();
		} else {
			throw new NoSuchElementException();
		}
	}
	
	/**
	 * Tells whether the line for the register has another cart in it or not
	 * 
	 * @return true if the line isn't empty
	 */
	@Override
	public boolean hasNext() {
		return !line.isEmpty();
	}
	
	/**
	 * Returns the time when the cart at the front of the line will finish
	 * checking out and leave
	 * 
	 * @return the time when the next cart will leave the checkout register
	 */
	@Override
	public int departTimeNext() {
		if (!line.isEmpty()) {
			return line.front().getArrivalTime() + line.front().getWaitTime() + line.front().getProcessTime();
		} else {
			return Integer.MAX_VALUE;
		}
	}
	
	/**
	 * Adds a cart to the back of the line for the register
	 * 
	 * @param cart
	 *            the cart to add to the line
	 */
	public void addCartToLine(Cart cart) {
		if (timeWhenAvailable == 0) { // first time a cart is being added
			timeWhenAvailable = cart.getArrivalTime() + cart.getProcessTime();
			cart.setWaitTime(0);
		} else if (timeWhenAvailable <= cart.getArrivalTime()) {
			cart.setWaitTime(0);
			timeWhenAvailable += (cart.getArrivalTime() - timeWhenAvailable) + cart.getProcessTime();
		} else { // timeWhenAvailable > arrivalTime
			cart.setWaitTime(timeWhenAvailable - cart.getArrivalTime());
			timeWhenAvailable += cart.getProcessTime();
		}
		line.add(cart);
	}
}
