/**
 * 
 */
package edu.ncsu.csc216.checkout_simulator.simulation;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.fail;

import org.junit.Test;

/**
 * Tests functionality of Simulator class
 * 
 * @author Caitlyn Wiley
 *
 */
public class SimulatorTest {

	/**
	 * Tests valid constructors for simulator
	 */
	@Test
	public void testValidSimulator() {
		// test valid values for both parameters, non-boundary
		try {
			Simulator simulator = new Simulator(4, 7);
			assertNotNull(simulator);
		} catch (IllegalArgumentException e) {
			fail();
		}
		// test boundaries for numCarts and numRegisters
		try {
			Simulator simulator = new Simulator(3, 1);
			assertNotNull(simulator);
		} catch (IllegalArgumentException e) {
			fail();
		}
	}

	/**
	 * Tests invalid constructors for simulator
	 */
	@Test
	public void testIvalidSimulator() {
		// invalid numCarts
		Simulator simulator = null;
		try {
			simulator = new Simulator(3, 0);
			fail();
		} catch (IllegalArgumentException e) {
			assertNull(simulator);
		}
		// invalid numRegisters
		Simulator simulator2 = null;
		try {
			simulator2 = new Simulator(2, 1);
			fail();
		} catch (IllegalArgumentException e) {
			assertNull(simulator2);
		}
		// invalid numRegisters
		Simulator simulator3 = null;
		try {
			simulator3 = new Simulator(13, 1);
			fail();
		} catch (IllegalArgumentException e) {
			assertNull(simulator3);
		}
	}

}
