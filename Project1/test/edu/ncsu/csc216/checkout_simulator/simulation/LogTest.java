/**
 * 
 */
package edu.ncsu.csc216.checkout_simulator.simulation;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.Test;

import edu.ncsu.csc216.checkout_simulator.items.Cart;
import edu.ncsu.csc216.checkout_simulator.items.ExpressCart;

/**
 * @author Caitlyn
 *
 */
public class LogTest {

	@Test
	public void testLog() {
		Log log = new Log();
		assertEquals(0, log.getNumCompleted());
		assertEquals(0, (int) log.averageProcessTime());
		assertEquals(0, (int) log.averageWaitTime());
	}

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
