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
	public Cart(int a, int b) {
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * @return the arrivalTime
	 */
	public int getArrivalTime() {
		return arrivalTime;
	}
	
	/**
	 * @return the waitTime
	 */
	public int getWaitTime() {
		return waitTime;
	}
	
	/**
	 * @param waitTime the waitTime to set
	 */
	public void setWaitTime(int waitTime) {
		this.waitTime = waitTime;
	}
	
	/**
	 * @return the processTime
	 */
	public int getProcessTime() {
		return processTime;
	}
	
	/**
	 * @return the registerIndex
	 */
	public int getRegisterIndex() {
		return registerIndex;
	}
	
	/**
	 * @return the waitingProcessing
	 */
	public boolean isWaitingInRegisterLine() {
		return waitingProcessing;
	}
	
	/**
	 * 
	 */
	public void removeFromWaitingLine() {
		//guessed
		waitingProcessing = false;
	}
	
	/**
	 * @param registerIndex the registerIndex to set
	 */
	protected void setRegisterIndex(int registerIndex) {
		this.registerIndex = registerIndex;
	}
	
	public abstract void getInLine(CheckoutRegister[] a);
	
	public abstract Color getColor();

}
