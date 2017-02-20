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
 * @author Caitlyn Wiley
 *
 */
public class TestCheckoutRegister {

	@Test
	public void testSize() {
		Log log = new Log();
		CheckoutRegister register = new CheckoutRegister(log);
		assertEquals(0, register.size());
	}

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

	@Test
	public void testHasNext() {
		Log log = new Log();
		CheckoutRegister register = new CheckoutRegister(log);
		Cart cart = new ExpressCart(20, 30);
		register.addCartToLine(cart);
		assertEquals(1, register.size());
		assertTrue(register.hasNext());
	}

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
