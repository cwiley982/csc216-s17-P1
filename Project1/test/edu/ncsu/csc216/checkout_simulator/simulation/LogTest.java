/**
 * 
 */
package edu.ncsu.csc216.checkout_simulator.simulation;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.Test;

import edu.ncsu.csc216.checkout_simulator.items.Cart;
import edu.ncsu.csc216.checkout_simulator.items.ExpressCart;
import edu.ncsu.csc216.checkout_simulator.items.RegularShoppingCart;

/**
 * Tests functionality of Log class
 * 
 * @author Caitlyn Wiley
 *
 */
public class LogTest {

	/**
	 * Tests constructing a Log
	 */
	@Test
	public void testLog() {
		Log log = new Log();
		assertEquals(0, log.getNumCompleted());
		assertEquals(0, (int) log.averageProcessTime());
		assertEquals(0, (int) log.averageWaitTime());
	}

	/**
	 * Tests getting the number of carts that have completed the simulation
	 */
	@Test
	public void testGetNumCompleted() {
		Log log = new Log();
		try {
			assertEquals(0, log.getNumCompleted());
			Cart cart = new ExpressCart(20, 30);
			log.logCart(cart);
			assertEquals(1, log.getNumCompleted());
			Cart cart2 = new RegularShoppingCart(30, 5);
			log.logCart(cart2);
			assertEquals(2, log.getNumCompleted());
		} catch (IllegalArgumentException e) {
			fail();
		}
	}

	/**
	 * Tests logging a cart's info
	 */
	@Test
	public void testLogCart() {
		Log log = new Log();
		try {
			Cart cart = new ExpressCart(20, 30);
			log.logCart(cart);
			assertEquals(1, log.getNumCompleted());
			assertEquals(0, (int) log.averageWaitTime());
			assertEquals(30, (int) log.averageProcessTime());
		} catch (IllegalArgumentException e) {
			fail();
		}
	}

}
