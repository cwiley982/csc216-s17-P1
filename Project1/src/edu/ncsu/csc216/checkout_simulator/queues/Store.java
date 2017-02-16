/**
 * 
 */
package edu.ncsu.csc216.checkout_simulator.queues;

import edu.ncsu.csc216.checkout_simulator.items.Cart;
import edu.ncsu.csc216.checkout_simulator.items.CartFactory;

/**
 * @author Caitlyn
 *
 */
public class Store implements LineOfItems{
	/*The queue of carts (still shopping) created by CartFactory in the Store constructor. Carts are added to the queue in order of their arrivalTimes.*/
	private ShoppingCartQueue shopping;
	private CheckoutRegister[] register;
	
	/**
	 * 
	 */
	public Store(int numOfCarts, CheckoutRegister[] register) {
		for (int i = 1; i <= numOfCarts; i++) {
			shopping.add(CartFactory.createCart());
		}
		this.register = register;
	}

	@Override
	public int size() {
		return shopping.size();
	}
	
	@Override
	public boolean hasNext() {
		return !shopping.isEmpty();
	}

	@Override
	public Cart processNext() {
		shopping.front().getInLine(register);
		return shopping.remove();
	}

	@Override
	public int departTimeNext() {
		if (!shopping.isEmpty()) {
			return shopping.front().getArrivalTime();
		} else {
			return Integer.MAX_VALUE;
		}
	}

}
