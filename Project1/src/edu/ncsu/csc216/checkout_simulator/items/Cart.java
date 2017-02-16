/**
 * 
 */
package edu.ncsu.csc216.checkout_simulator.items;

import java.awt.Color;

import edu.ncsu.csc216.checkout_simulator.queues.CheckoutRegister;

/**
 * @author Caitlyn
 *
 */
public abstract class Cart {

	public static final int INITIAL_REGISTER_IDX = 0;
	private int arrivalTime;
	private int waitTime;
	private int processTime;
	private int registerIndex;
	private boolean waitingProcessing;
	/**
	 * 
	 */
	public Cart(int arrivalTime, int processTime) {
		this.arrivalTime = arrivalTime;
		this.processTime = processTime;
	}
	
	/**
	 * returns the time when the cart finishes shopping and enters a line
	 * @return the arrivalTime
	 */
	public int getArrivalTime() {
		return arrivalTime;
	}
	
	/**
	 * returns the time the cart spent waiting in line at a checkout register
	 * @return the waitTime
	 */
	public int getWaitTime() {
		return waitTime;
	}
	
	/**
	 * sets the time the cart waited at the checkout line
	 * @param waitTime the waitTime to set
	 */
	public void setWaitTime(int waitTime) {
		this.waitTime = waitTime;
	}
	
	/**
	 * returns the time the cart took to checkout
	 * @return the processTime
	 */
	public int getProcessTime() {
		return processTime;
	}
	
	/**
	 * returns the index of the register the cart is at
	 * @return the registerIndex
	 */
	public int getRegisterIndex() {
		return registerIndex;
	}
	
	/**
	 * @return true if the cart is in line
	 */
	public boolean isWaitingInRegisterLine() {
		return waitingProcessing;
	}
	
	/**
	 * removes the cart from the line it was in and finishes processing it
	 */
	public void removeFromWaitingLine() {
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
	
	public abstract void getInLine(CheckoutRegister[] a);
	
	public abstract Color getColor();

}
