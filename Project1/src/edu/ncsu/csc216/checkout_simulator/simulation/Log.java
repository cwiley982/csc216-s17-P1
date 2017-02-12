/**
 * 
 */
package edu.ncsu.csc216.checkout_simulator.simulation;

import edu.ncsu.csc216.checkout_simulator.items.Cart;

/**
 * @author Caitlyn
 *
 */
public class Log {

	private int numCompleted;
	private int totalWaitTime;
	private int totalProcessTime;
	
	/**
	 * 
	 */
	public Log() {
		// TODO Auto-generated constructor stub
	}

	public int getNumCompleted() {
		return numCompleted;
	}
	
	public void logCart(Cart cart) {
		totalWaitTime += cart.getWaitTime();
		totalProcessTime += cart.getProcessTime();
		numCompleted++;
	}
	
	public double averageWaitTime() {
		return totalWaitTime / numCompleted;
	}
	
	public double averageProcessTime() {
		return totalProcessTime / numCompleted;
	}
}
