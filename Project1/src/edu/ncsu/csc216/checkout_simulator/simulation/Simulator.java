/**
 * 
 */
package edu.ncsu.csc216.checkout_simulator.simulation;

import java.awt.Color;

import edu.ncsu.csc216.checkout_simulator.items.Cart;
import edu.ncsu.csc216.checkout_simulator.queues.CheckoutRegister;
import edu.ncsu.csc216.checkout_simulator.queues.LineOfItems;
import edu.ncsu.csc216.checkout_simulator.queues.ShoppingCartQueue;
import edu.ncsu.csc216.checkout_simulator.queues.Store;

/**
 * @author Caitlyn
 *
 */
public class Simulator {

	private static final int MIN_NUM_REGISTERS = 3;
	private static final int MAX_NUM_REGISTERS = 12;
	private int numRegisters;
	private int numCarts;
	private int stepsTaken;
	private Cart currentCart;
	private EventCalendar calendar;
	
	/**
	 * 
	 */
	public Simulator(int numCarts, int numRegisters) {
		if (numCarts > 0) {
			this.numCarts = numCarts;
		}
		if (numRegisters > MIN_NUM_REGISTERS && numRegisters < MAX_NUM_REGISTERS) {
			this.numRegisters = numRegisters;
		}
		CheckoutRegister[] register = new CheckoutRegister[this.numRegisters];
		new Store(this.numCarts, register);
		new Log();
		ShoppingCartQueue checkoutEntry = new ShoppingCartQueue();
		calendar = new EventCalendar((LineOfItems[]) register, (LineOfItems) checkoutEntry);
	}

	public static Color[] simulationColors() {
		Color[] colors = { Color.GREEN, Color.BLUE, Color.RED };
		return colors;
	}
	
	public static String[] simulationLabels() {
		String[] labels = { "Express Cart", "Regular Cart", "Special Handling Cart" };
		return labels;
	}
	
	public void step() {
		LineOfItems next = calendar.nextToBeProcessed();
		if (next instanceof Cart) {
			// handle cart quitting shopping, enter a line
		} else if (next instanceof CheckoutRegister) {
			// handle cart leaving register, log info
		}
		stepsTaken++;
	}
	
	public int getStepsTaken() {
		return stepsTaken;
	}
	
	public int totalNumberOfSteps() {
		return numCarts * 2; // each cart has two steps (1. quit shopping to
								// enter a line and 2. finish checkout and
								// leave)
	}
	
	public boolean moreSteps() {
		if (stepsTaken < totalNumberOfSteps()) {
			return true;
		} else {
			return false;
		}
	}
	
	public int getCurrentIndex() {
		return -1;
	}
	
	public Color getCurrentCartColor() {
		return currentCart.getColor();
	}
	
	public boolean itemLeftSimulation() {
		return false;
	}
	
	public double averageWaitTime() {
		return -1;
	}
	
	public double averageProcessTime() {
		return -1;
	}
}
