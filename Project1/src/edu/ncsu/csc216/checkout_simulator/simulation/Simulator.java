/**
 * 
 */
package edu.ncsu.csc216.checkout_simulator.simulation;

import java.awt.Color;

import edu.ncsu.csc216.checkout_simulator.items.Cart;
import edu.ncsu.csc216.checkout_simulator.queues.CheckoutRegister;
import edu.ncsu.csc216.checkout_simulator.queues.LineOfItems;
import edu.ncsu.csc216.checkout_simulator.queues.Store;

/**
 * Creates a Simulator to handle all events and actions performed by other
 * classes
 * 
 * @author Caitlyn Wiley
 *
 */
public class Simulator {

	/** Minimum number of registers allowed */
	private static final int MIN_NUM_REGISTERS = 3;
	/** Maximum number of registers allowed */
	private static final int MAX_NUM_REGISTERS = 12;
	/** Number of registers in the simulation */
	private int numRegisters;
	/** Number of carts in the simulation */
	private int numCarts;
	/** Number of steps taken in the simulation */
	private int stepsTaken;
	/** The Cart currently being handled */
	private Cart currentCart;
	/** The EventCalendar for the simulation */
	private EventCalendar theCalendar;
	/** The Store where the carts still shopping are held */
	private Store theStore;
	/** An array of CheckoutRegisters in the simulation */
	private CheckoutRegister[] register;
	/** The Log that holds info about carts' processing and wait times */
	private Log myLog;
	
	/**
	 * Constructs a simulator to hold a store, event calendar, log, collection
	 * of carts and collection of registers
	 * 
	 * @param numCarts
	 *            the number of carts in the simulation
	 * @param numRegisters
	 *            the number of registers in the simulation
	 */
	public Simulator(int numRegisters, int numCarts) {
		if (numCarts < 1 || numRegisters < MIN_NUM_REGISTERS || numRegisters > MAX_NUM_REGISTERS) {
			throw new IllegalArgumentException();
		}
		this.numCarts = numCarts;
		this.numRegisters = numRegisters;
		myLog = new Log();
		register = new CheckoutRegister[this.numRegisters];
		for (int i = 0; i < this.numRegisters; i++) {
			register[i] = new CheckoutRegister(myLog);
		}
		theStore = new Store(this.numCarts, register);
		theCalendar = new EventCalendar(register, theStore);
	}

	/**
	 * Returns an array of colors used for the carts in the simulation
	 * 
	 * @return the array of colors used in the simulation
	 */
	public static Color[] simulationColors() {
		Color[] colors = { Color.GREEN, Color.BLUE, Color.RED };
		return colors;
	}
	
	/**
	 * Returns a String array with the names of the labels for each cart to be
	 * displayed on the simulator
	 * 
	 * @return the String array with the cart names
	 */
	public static String[] simulationLabels() {
		String[] labels = { "Express Cart", "Regular Cart", "Special Handling Cart" };
		return labels;
	}
	
	/**
	 * Handles the next event for the EventCalendar (cart quitting shopping and
	 * entering a line or a cart finishing at a register and logging its info)
	 */
	public void step() {
		if (moreSteps()) {
			currentCart = null;
			LineOfItems next = theCalendar.nextToBeProcessed();
			if (next instanceof Store) {
				currentCart = theStore.processNext();
				// handle cart quitting shopping, enter a line
			} else if (next instanceof CheckoutRegister) {
				CheckoutRegister registerToProcess = (CheckoutRegister) next;
				currentCart = registerToProcess.processNext();
				// handle cart leaving register, log info
			}
			stepsTaken++;
		}
	}
	
	/**
	 * Returns how many steps the simulation has taken (number of events
	 * handled)
	 * 
	 * @return the number of steps taken in the simulation so far
	 */
	public int getStepsTaken() {
		return stepsTaken;
	}
	
	/**
	 * Returns the total number of steps that will be taken when the simulation
	 * is finished
	 * 
	 * @return the total number of steps that will be taken
	 */
	public int totalNumberOfSteps() {
		return numCarts * 2; // each cart has two steps (1. quit shopping to
								// enter a line and 2. finish checkout and
								// leave)
	}
	
	/**
	 * Tells whether or not there are more steps to be taken
	 * 
	 * @return true if the stepsTaken is less than the total number of steps
	 */
	public boolean moreSteps() {
		return stepsTaken < totalNumberOfSteps();
	}
	
	/**
	 * Returns the index of the register that the currentCart is at
	 * 
	 * @return index of register currentCart is at
	 */
	public int getCurrentIndex() {
		if (currentCart == null) {
			return -1;
		} else {
			return currentCart.getRegisterIndex();
		}
	}
	
	/**
	 * Returns the color of the currentCart
	 * 
	 * @return the color of the currentCart
	 */
	public Color getCurrentCartColor() {
		return currentCart.getColor();
	}
	
	/**
	 * Tells whether the currentCart has left the simulation or is now in line
	 * for a CheckoutRegister
	 * 
	 * @return true if the currentCart left the simulation
	 */
	public boolean itemLeftSimulation() {
		return !currentCart.isWaitingInRegisterLine();
	}
	
	/**
	 * Returns the average wait time for all carts in the simulation
	 * 
	 * @return average wait time for all carts
	 */
	public double averageWaitTime() {
		return myLog.averageWaitTime();
	}
	
	/**
	 * Returns the average process time for all the carts in the simulation
	 * 
	 * @return the average process time for all carts
	 */
	public double averageProcessTime() {
		return myLog.averageProcessTime();
	}
}
