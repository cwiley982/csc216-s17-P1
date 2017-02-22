/**
 * 
 */
package edu.ncsu.csc216.checkout_simulator.queues;

import java.util.NoSuchElementException;

import edu.ncsu.csc216.checkout_simulator.items.Cart;
import edu.ncsu.csc216.checkout_simulator.items.CartFactory;

/**
 * Creates a Store to hold all carts and registers
 * 
 * @author Caitlyn Wiley
 *
 */
public class Store implements LineOfItems {
	/**
	 * The queue of carts (still shopping) created by CartFactory in the Store
	 * constructor. Carts are added to the queue in order of their arrivalTimes.
	 */
	private ShoppingCartQueue shopping;
	/** An array of CheckoutRegisters in the Store */
	private CheckoutRegister[] register;
	
	/**
	 * Creates a store that holds all of the carts and registers
	 * 
	 * @param numOfCarts
	 *            the number of carts in the store
	 * @param register
	 *            the number of registers in the store
	 */
	public Store(int numOfCarts, CheckoutRegister[] register) {
		shopping = new ShoppingCartQueue();
		for (int i = 1; i <= numOfCarts; i++) {
			shopping.add(CartFactory.createCart());
		}
		this.register = register;
	}

	/**
	 * Returns the number of carts still shopping
	 * 
	 * @return the number of carts in shopping
	 */
	@Override
	public int size() {
		return shopping.size();
	}
	
	/**
	 * Tells whether there are still more carts that haven't quit shopping yet
	 * 
	 * @return true if shopping isn't empty
	 */
	@Override
	public boolean hasNext() {
		return !shopping.isEmpty();
	}

	/**
	 * Processes the next cart to quit shopping and puts it in a line
	 * 
	 * @return the Cart that has been processed
	 */
	@Override
	public Cart processNext() {
		if (hasNext()) {
			shopping.front().getInLine(register);
			return shopping.remove();
		} else {
			throw new NoSuchElementException();
		}
	}

	/**
	 * Returns the time when the next cart that's still shopping will enter a
	 * line for a register
	 * 
	 * @return the time the cart at the front of the shopping line will quit
	 *         shopping
	 */
	@Override
	public int departTimeNext() {
		if (!shopping.isEmpty()) {
			return shopping.front().getArrivalTime();
		} else {
			return Integer.MAX_VALUE;
		}
	}

}
