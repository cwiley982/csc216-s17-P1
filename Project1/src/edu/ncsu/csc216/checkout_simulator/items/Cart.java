/**
 * 
 */
package edu.ncsu.csc216.checkout_simulator.items;

import java.awt.Color;

import edu.ncsu.csc216.checkout_simulator.queues.CheckoutRegister;

/**
 * Creates a cart in the simulation with a predetermined arrival time and
 * process time
 * 
 * @author Caitlyn Wiley
 *
 */
public abstract class Cart {

	/** The index for the first CheckoutRegister */
	public static final int INITIAL_REGISTER_IDX = 0;
	/** When a Cart enters a line */
	private int arrivalTime;
	/** How long a Cart waits in line before checking out */
	private int waitTime;
	/** The time it takes a Cart to checkout */
	private int processTime;
	/** The index of the register a Cart is at */
	private int registerIndex;
	/** Tells whether a Cart is waiting in line or not */
	private boolean waitingProcessing;

	/**
	 * Constructs a Cart with an arrivalTime and a processTime
	 * 
	 * @param arrivalTime
	 *            when the cart gets in a line
	 * @param processTime
	 *            how long the Cart takes to checkout
	 */
	public Cart(int arrivalTime, int processTime) {
		if (arrivalTime < 0 || processTime < 0) {
			throw new IllegalArgumentException();
		}
		this.arrivalTime = arrivalTime;
		this.processTime = processTime;
	}
	
	/**
	 * Returns the time when the Cart finishes shopping and enters a line
	 * 
	 * @return when the Cart arrives in a line
	 */
	public int getArrivalTime() {
		return arrivalTime;
	}
	
	/**
	 * Returns the time the Cart spent waiting in line at a checkout register
	 * 
	 * @return how long a Cart waits in line
	 */
	public int getWaitTime() {
		return waitTime;
	}
	
	/**
	 * Sets the time the cart waited at the checkout line
	 * 
	 * @param waitTime
	 *            the waitTime to set
	 */
	public void setWaitTime(int waitTime) {
		this.waitTime = waitTime;
	}
	
	/**
	 * Returns the time the cart took to checkout
	 * 
	 * @return the processTime
	 */
	public int getProcessTime() {
		return processTime;
	}
	
	/**
	 * Returns the index of the register the cart is at
	 * 
	 * @return the registerIndex
	 */
	public int getRegisterIndex() {
		return registerIndex;
	}
	
	/**
	 * Tells whether the Cart is waiting in line or not
	 * 
	 * @return true if the Cart is in line
	 */
	public boolean isWaitingInRegisterLine() {
		return waitingProcessing;
	}
	
	/**
	 * Removes the cart from the line it was in and finishes processing it
	 */
	public void removeFromWaitingLine() {
		// Log.logCart(this);
		waitingProcessing = false;
		// finish processing
	}
	
	/**
	 * sets the index of the register the cart is at
	 * @param registerIndex the registerIndex to set
	 */
	protected void setRegisterIndex(int registerIndex) {
		this.registerIndex = registerIndex;
		waitingProcessing = true;
	}
	
	/**
	 * Determines which line a cart will join and puts the cart in that line
	 * 
	 * @param registers
	 *            the array of all CheckoutRegisters in the simulation
	 */
	public abstract void getInLine(CheckoutRegister[] registers);
	
	/**
	 * Returns the color of the Cart based on the type of cart
	 * 
	 * @return color of the cart
	 */
	public abstract Color getColor();

}
