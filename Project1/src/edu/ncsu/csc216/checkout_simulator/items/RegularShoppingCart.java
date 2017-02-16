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
public class RegularShoppingCart extends Cart{

	private static Color color;
	/**
	 * 
	 */
	public RegularShoppingCart(int arrivalTime, int processTime) {
		super(arrivalTime, processTime);
		color = Color.BLUE;
	}

	@Override
	public void getInLine(CheckoutRegister[] a) {
		int shortestLine = 1; //first register cart can join
		for (int i = 2; i < a.length; i++) { //can join regular and special register lines
			if (a[i].size() < a[shortestLine].size()) {
				shortestLine = i;
			} else if (a[i].size() == a[shortestLine].size()) {
				shortestLine = Math.min(shortestLine, i);  //if lines are equal, choose smaller index
			}
		}
		// shortestLine holds the index of the shortest line the cart can join
		a[shortestLine].addCartToLine(this);
		super.setRegisterIndex(shortestLine);
	}

	@Override
	public Color getColor() {
		return color;
	}

}
