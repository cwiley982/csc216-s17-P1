/**
 * 
 */
package edu.ncsu.csc216.checkout_simulator.items;

import java.awt.Color;

import edu.ncsu.csc216.checkout_simulator.queues.CheckoutRegister;

/**
 * Creates a RegularShoppingCart with the color blue that can enter all lines
 * except the express register
 * 
 * @author Caitlyn Wiley
 *
 */
public class RegularShoppingCart extends Cart {

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
	public RegularShoppingCart(int arrivalTime, int processTime) {
		super(arrivalTime, processTime);
		color = Color.BLUE;
	}

	/**
	 * Searches through all lines except the line for the express register and
	 * adds the cart to the register with the shortest line
	 * 
	 * @param registers
	 *            the array of CheckoutRegisters that will be searched through
	 */
	@Override
	public void getInLine(CheckoutRegister[] registers) {
		int shortestLine = 1; //first register cart can join
		//can join regular and special register lines
		for (int i = shortestLine + 1; i < registers.length; i++) { 
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
