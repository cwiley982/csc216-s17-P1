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
		
	}
	
	public double averageWaitTime() {
		return -1;
	}
	
	public double averageProcessTime() {
		return -1;
	}
}
