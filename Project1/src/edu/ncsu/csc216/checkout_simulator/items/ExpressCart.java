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
	public ExpressCart(int a, int b) {
		super(a, b);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void getInLine(CheckoutRegister[] a) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Color getColor() {
		// TODO Auto-generated method stub
		return null;
	}

}
