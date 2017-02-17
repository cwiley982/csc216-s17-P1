/**
 * 
 */
package edu.ncsu.csc216.checkout_simulator.items;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.fail;

import java.awt.Color;

import org.junit.Test;

import edu.ncsu.csc216.checkout_simulator.queues.CheckoutRegister;
import edu.ncsu.csc216.checkout_simulator.simulation.Log;

/**
 * @author Caitlyn
 *
 */
public class ExpressCartTest {

	@Test
	public void testExpressCart() {
		ExpressCart cart = null;
		try {
			cart = new ExpressCart(20, 30);
			assertNotNull(cart);
		} catch (IllegalArgumentException e) {
			fail();
		}

		ExpressCart cart2 = null;
		try {
			cart2 = new ExpressCart(-20, 30);
			fail();
		} catch (IllegalArgumentException e) {
			assertNull(cart2);
		}

		ExpressCart cart3 = null;
		try {
			cart3 = new ExpressCart(20, -30);
			fail();
		} catch (IllegalArgumentException e) {
			assertNull(cart3);
		}
	}

	@Test
	public void testGetArrivalTime() {
		try {
			ExpressCart cart = new ExpressCart(20, 30);
			assertEquals(20, cart.getArrivalTime());
		} catch (IllegalArgumentException e) {
			fail();
		}
	}

	@Test
	public void testGetWaitTime() {
		try {
			ExpressCart cart = new ExpressCart(20, 30);
			assertEquals(0, cart.getWaitTime());
		} catch (IllegalArgumentException e) {
			fail();
		}
	}

	@Test
	public void testGetColor() {
		try {
			ExpressCart cart = new ExpressCart(20, 30);
			assertEquals(Color.GREEN, cart.getColor());
		} catch (IllegalArgumentException e) {
			fail();
		}
	}

	@Test
	public void testGetInLine() {
		try {
			ExpressCart cart = new ExpressCart(20, 30);
			Log log = new Log();
			CheckoutRegister r1 = new CheckoutRegister(log);
			CheckoutRegister r2 = new CheckoutRegister(log);
			CheckoutRegister r3 = new CheckoutRegister(log);
			CheckoutRegister[] registers = { r1, r2, r3 };
			cart.getInLine(registers);
			assertEquals(0, cart.getRegisterIndex());
		} catch (IllegalArgumentException e) {
			fail();
		}
	}

}
