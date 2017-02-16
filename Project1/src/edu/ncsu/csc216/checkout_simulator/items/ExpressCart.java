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
public class ExpressCart extends Cart{

	private static Color color;
	
	/**
	 * 
	 */
	public ExpressCart(int arrivalTime, int processTime) {
		super(arrivalTime, processTime);
		color = Color.GREEN;
	}
	
	@Override
	public void getInLine(CheckoutRegister[] a) {
		int shortestLine = 0;
		for (int i = 1; i < a.length; i++) {
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
