/**
 * 
 */
package edu.ncsu.csc216.checkout_simulator.simulation;

import java.awt.Color;

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
	
	/**
	 * 
	 */
	public Simulator(int numCarts, int numRegisters) {
		// TODO Auto-generated constructor stub
	}

	public static Color[] simulationColors() {
		return null;
	}
	
	public static String[] simulationLabels() {
		return null;
	}
	
	public void step() {
		
	}
	
	public int getStepsTaken() {
		return stepsTaken;
	}
	
	public int totalNumberOfSteps() {
		return -1;
	}
	
	public boolean moreSteps() {
		return false;
	}
	
	public int getCurrentIndex() {
		return -1;
	}
	
	public Color getCurrentCartColor() {
		return null;
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
