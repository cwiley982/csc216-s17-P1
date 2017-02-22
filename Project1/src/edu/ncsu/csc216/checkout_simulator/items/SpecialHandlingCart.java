/**
 * 
 */
package edu.ncsu.csc216.checkout_simulator.items;

import java.awt.Color;

import edu.ncsu.csc216.checkout_simulator.queues.CheckoutRegister;

/**
 * Creates a SpecialHandlingCart with the color red that can enter only special
 * register lines
 * 
 * @author Caitlyn Wiley
 *
 */
public class SpecialHandlingCart extends Cart {

	/** The color of the cart */
	private static Color color;
	
	/**
	 * Constructs a cart using the super class and sets the color field
	 * 
	 * @param arrivalTime
	 *            when the carts quits shopping and enters a line
	 * @param processTime
	 *            how long the cart takes to checkout
	 */
	public SpecialHandlingCart(int arrivalTime, int processTime) {
		super(arrivalTime, processTime);
		color = Color.RED;
	}

	/**
	 * Searches through the special register lines and adds the cart to the line
	 * with the least number of carts
	 * 
	 * @param registers
	 *            the array of CheckoutRegisters that will be searched through
	 */
	@Override
	public void getInLine(CheckoutRegister[] registers) {
		int numSpecialRegisters = (int) Math.ceil(registers.length * .25);
		int shortestLine = registers.length - numSpecialRegisters; // first
																	// special
																	// register
		for (int i = shortestLine + 1; i < registers.length; i++) {
			if (registers[i].size() < registers[shortestLine].size()) {  //if next line is shorter
				shortestLine = i;
			} else if (registers[i].size() == registers[shortestLine].size()) {
				shortestLine = Math.min(shortestLine, i);  //if lines are equal, choose smaller index
			}
		}
		// shortestLine holds the index of the shortest line the cart can join
		registers[shortestLine].addCartToLine(this);
		super.setRegisterIndex(shortestLine);
	}

	/**
	 * Returns the color of the cart to be used in the simulation
	 * 
	 * @return the color of the cart
	 */
	@Override
	public Color getColor() {
		return color;
	}

}
