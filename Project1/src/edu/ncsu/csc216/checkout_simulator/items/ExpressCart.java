/**
 * 
 */
package edu.ncsu.csc216.checkout_simulator.items;

import java.awt.Color;

import edu.ncsu.csc216.checkout_simulator.queues.CheckoutRegister;

/**
 * Creates an ExpressCart with the color green that can enter all lines
 * 
 * @author Caitlyn Wiley
 *
 */
public class ExpressCart extends Cart {

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
	public ExpressCart(int arrivalTime, int processTime) {
		super(arrivalTime, processTime);
		color = Color.GREEN;
	}
	
	/**
	 * Searches through all lines to determine which is shortest and the cart is
	 * added to that line
	 * 
	 * @param registers
	 *            the array of CheckoutRegisters that will be searched through
	 */
	@Override
	public void getInLine(CheckoutRegister[] registers) {
		int shortestLine = 0;
		for (int i = 1; i < registers.length; i++) {
			if (registers[i].size() < registers[shortestLine].size()) {
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
