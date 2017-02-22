/**
 * 
 */
package edu.ncsu.csc216.checkout_simulator.queues;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import edu.ncsu.csc216.checkout_simulator.simulation.Log;

/**
 * Tests the functionality of the Store class
 * 
 * @author Caitlyn Wiley
 *
 */
public class StoreTest {

	/**
	 * Tests getting the size of a store as well as the Store constructor
	 */
	@Test
	public void testSize() {
		CheckoutRegister[] register = new CheckoutRegister[3];
		Store store = new Store(7, register);
		assertEquals(7, store.size());
	}

	/**
	 * Tests hasNext method in Store, tells whether the store has another cart
	 * in it or not
	 */
	@Test
	public void testHasNext() {
		CheckoutRegister[] register = new CheckoutRegister[3];
		Store store = new Store(7, register);
		assertTrue(store.hasNext());
	}

	/**
	 * Tests processing the next cart that will quit shopping
	 */
	@Test
	public void testProcessNext() {
		Log log = new Log();
		CheckoutRegister r1 = new CheckoutRegister(log);
		CheckoutRegister r2 = new CheckoutRegister(log);
		CheckoutRegister r3 = new CheckoutRegister(log);
		CheckoutRegister[] register = { r1, r2, r3 };
		Store store = new Store(7, register);
		store.processNext();
		assertEquals(6, store.size());
	}

	/**
	 * Tests depart time next method in Store
	 */
	@Test
	public void testDepartTimeNext() {
		Log log = new Log();
		CheckoutRegister r1 = new CheckoutRegister(log);
		CheckoutRegister r2 = new CheckoutRegister(log);
		CheckoutRegister r3 = new CheckoutRegister(log);
		CheckoutRegister[] register = { r1, r2, r3 };
		Store store = new Store(12, register);
		assertNotEquals(Integer.MAX_VALUE, store.departTimeNext());
		for (int i = 0; i < store.size(); i++) {
			store.processNext();
			i--; // starts over at 0 since each time the size decreases so i has
					// to restart loop
		}
		assertEquals(Integer.MAX_VALUE, store.departTimeNext());
	}
}
