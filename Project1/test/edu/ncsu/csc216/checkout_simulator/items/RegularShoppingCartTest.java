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
 * Tests the functionality of ExpressCart and therefore the super class Cart
 * 
 * @author Caitlyn Wiley
 *
 */
public class RegularShoppingCartTest {

	/**
	 * Tests the Constructor for an express cart
	 */
	@Test
	public void testRegularShoppingCart() {
		RegularShoppingCart cart = null;
		try {
			cart = new RegularShoppingCart(20, 30);
			assertNotNull(cart);
		} catch (IllegalArgumentException e) {
			fail();
		}

		RegularShoppingCart cart2 = null;
		try {
			cart2 = new RegularShoppingCart(-20, 30);
			fail();
		} catch (IllegalArgumentException e) {
			assertNull(cart2);
		}

		RegularShoppingCart cart3 = null;
		try {
			cart3 = new RegularShoppingCart(20, -30);
			fail();
		} catch (IllegalArgumentException e) {
			assertNull(cart3);
		}
	}

	/**
	 * Tests getting the arrival time of an express cart
	 */
	@Test
	public void testGetArrivalTime() {
		try {
			RegularShoppingCart cart = new RegularShoppingCart(20, 30);
			assertEquals(20, cart.getArrivalTime());
		} catch (IllegalArgumentException e) {
			fail();
		}
	}

	/**
	 * Tests getting the wait time for an express cart
	 */
	@Test
	public void testGetWaitTime() {
		try {
			RegularShoppingCart cart = new RegularShoppingCart(20, 30);
			assertEquals(0, cart.getWaitTime());
		} catch (IllegalArgumentException e) {
			fail();
		}
	}

	/**
	 * Tests getting the cart color of an express cart
	 */
	@Test
	public void testGetColor() {
		try {
			RegularShoppingCart cart = new RegularShoppingCart(20, 30);
			assertEquals(Color.BLUE, cart.getColor());
		} catch (IllegalArgumentException e) {
			fail();
		}
	}

	/**
	 * Tests getInLine method for an express cart
	 */
	@Test
	public void testGetInLine() {
		try {
			// tests when all registers are empty
			Cart cart = new RegularShoppingCart(20, 30);
			Log log = new Log();
			CheckoutRegister r1 = new CheckoutRegister(log);
			CheckoutRegister r2 = new CheckoutRegister(log);
			CheckoutRegister r3 = new CheckoutRegister(log);
			CheckoutRegister[] registers = { r1, r2, r3 };
			cart.getInLine(registers); // joins r2
			assertEquals(1, cart.getRegisterIndex());
			// tests when registers have different line sizes
			Cart c1 = new ExpressCart(25, 40);
			Cart c2 = new RegularShoppingCart(24, 15);
			r1.addCartToLine(c1); // r1 now has size 1 (c1)
			r2.addCartToLine(c2); // r2 now has size 2 (cart and c2)
			Cart cart2 = new RegularShoppingCart(23, 16);
			cart2.getInLine(registers); // joins r3
			assertEquals(2, cart2.getRegisterIndex());
			// tests when all registers aren't empty and two have the same line
			// size
			Cart cart3 = new RegularShoppingCart(24, 17);
			cart3.getInLine(registers); // joins r3
			assertEquals(2, cart3.getRegisterIndex());
			cart.getInLine(registers);
		} catch (IllegalArgumentException e) {
			fail();
		}
	}

}
