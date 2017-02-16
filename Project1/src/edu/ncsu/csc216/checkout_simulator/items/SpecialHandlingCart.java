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
public class SpecialHandlingCart extends Cart{

	private static Color color;
	
	/**
	 * 
	 */
	public SpecialHandlingCart(int arrivalTime, int processTime) {
		super(arrivalTime, processTime);
		color = Color.RED;
	}

	@Override
	public void getInLine(CheckoutRegister[] a) {
		int shortestLine = (int) Math.ceil(a.length * .75); //first special register
		for (int i = (int) Math.ceil(a.length * .75) + 1; i < a.length; i++) {
			if (a[i].size() < a[shortestLine].size()) {  //if next line is shorter
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
