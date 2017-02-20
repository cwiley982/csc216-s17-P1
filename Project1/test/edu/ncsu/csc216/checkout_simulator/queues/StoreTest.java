/**
 * 
 */
package edu.ncsu.csc216.checkout_simulator.queues;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

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
	 * Will test depart next time method in Store
	 */
	@Test
	public void testDepartNextTime() {
		// not sure how to test this
		fail("Not yet implemented.");
	}
}
