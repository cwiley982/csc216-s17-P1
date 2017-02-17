/**
 * 
 */
package edu.ncsu.csc216.checkout_simulator.simulation;

import edu.ncsu.csc216.checkout_simulator.items.Cart;

/**
 * Creates a log that stores the info about how long carts took to wait in line
 * and checkout
 * 
 * @author Caitlyn Wiley
 *
 */
public class Log {

	/**
	 * Number of carts that have completed the simulation and logged their info
	 */
	private int numCompleted;
	/** The total time that all carts have had to wait */
	private int totalWaitTime;
	/** The total time all carts took to checkout */
	private int totalProcessTime;
	
	/**
	 * Constructs a log to hold the times for all carts and initializes the
	 * fields
	 */
	public Log() {
		numCompleted = 0;
		totalWaitTime = 0;
		totalProcessTime = 0;
	}

	/**
	 * Returns the number of carts that have completed the simulation and logged
	 * their info
	 * 
	 * @return the number of carts that have completed the simulation
	 */
	public int getNumCompleted() {
		return numCompleted;
	}
	
	/**
	 * Logs a cart's info by updating the fields with the cart's numbers
	 * 
	 * @param cart
	 *            the cart being logged
	 */
	public void logCart(Cart cart) {
		totalWaitTime += cart.getWaitTime();
		totalProcessTime += cart.getProcessTime();
		numCompleted++;
	}
	
	/**
	 * Returns the average wait time for all carts that have completed the
	 * simulation so far
	 * 
	 * @return the average wait time
	 */
	public double averageWaitTime() {
		return totalWaitTime / numCompleted;
	}
	
	/**
	 * Returns the average process time for all carts that have completed the
	 * simulation so far
	 * 
	 * @return the average process time
	 */
	public double averageProcessTime() {
		return totalProcessTime / numCompleted;
	}
}
