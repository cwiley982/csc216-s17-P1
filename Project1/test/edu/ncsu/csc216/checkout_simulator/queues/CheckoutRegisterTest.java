/**
 * 
 */
package edu.ncsu.csc216.checkout_simulator.queues;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import edu.ncsu.csc216.checkout_simulator.items.Cart;
import edu.ncsu.csc216.checkout_simulator.items.ExpressCart;
import edu.ncsu.csc216.checkout_simulator.simulation.Log;

/**
 * Tests functionality of CheckoutRegister
 * 
 * @author Caitlyn Wiley
 *
 */
public class CheckoutRegisterTest {

	/**
	 * Tests getting the size of the line for a register
	 */
	@Test
	public void testSize() {
		Log log = new Log();
		CheckoutRegister register = new CheckoutRegister(log);
		assertEquals(0, register.size());
	}

	/**
	 * Tests adding a cart to the line of a checkout register
	 */
	@Test
	public void testAddCartToLine() {
		Log log = new Log();
		CheckoutRegister register = new CheckoutRegister(log);
		Cart cart = new ExpressCart(20, 30);
		register.addCartToLine(cart);
		assertEquals(1, register.size());
		assertEquals(0, cart.getWaitTime());
		Cart cart2 = new ExpressCart(30, 20);
		register.addCartToLine(cart2);
		assertEquals(2, register.size());
		assertEquals(20, cart2.getWaitTime());
	}

	/**
	 * Tests checking whether the register has another cart in its line or not
	 */
	@Test
	public void testHasNext() {
		Log log = new Log();
		CheckoutRegister register = new CheckoutRegister(log);
		Cart cart = new ExpressCart(20, 30);
		register.addCartToLine(cart);
		assertEquals(1, register.size());
		assertTrue(register.hasNext());
	}

	/**
	 * Tests checking when the next cart in line will finish at the register and
	 * leave the simulation
	 */
	@Test
	public void testDepartTimeNext() {
		Log log = new Log();
		CheckoutRegister register = new CheckoutRegister(log);
		assertEquals(Integer.MAX_VALUE, register.departTimeNext());
		Cart cart = new ExpressCart(20, 30);
		register.addCartToLine(cart);
		assertEquals(1, register.size());
		assertEquals(50, register.departTimeNext());
	}

	/**
	 * Tests processing the next cart in line at the register
	 */
	@Test
	public void testProcessNext() {
		Log log = new Log();
		CheckoutRegister register = new CheckoutRegister(log);
		Cart cart = new ExpressCart(20, 30);
		register.addCartToLine(cart);
		assertEquals(1, register.size());
		assertEquals(cart, register.processNext());
		assertFalse(register.hasNext());
	}
}
