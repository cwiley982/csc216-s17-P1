/**
 * 
 */
package edu.ncsu.csc216.checkout_simulator.simulation;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.awt.Color;

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

	/**
	 * Tests getting the total number of steps
	 */
	@Test
	public void testTotalNumberOfSteps() {
		Simulator simulator = new Simulator(4, 7);
		assertEquals(14, simulator.totalNumberOfSteps());
	}

	/**
	 * Tests to see if simulator successfully reports whether there are more
	 * steps to be taken
	 */
	@Test
	public void testMoreSteps() {
		Simulator simulator = new Simulator(4, 7);
		assertTrue(simulator.moreSteps());
		for (int i = 0; i < 13; i++) {
			simulator.step();
		}
		assertTrue(simulator.moreSteps());
		simulator.step();
		assertFalse(simulator.moreSteps());
	}

	/**
	 * Tests to see if simulator correctly tells how many steps have been taken
	 */
	@Test
	public void testGetStepsTaken() {
		Simulator simulator = new Simulator(4, 7);
		assertEquals(0, simulator.getStepsTaken());
		simulator.step();
		assertEquals(1, simulator.getStepsTaken());
	}

	/**
	 * Tests getting the index of the register that the current cart is at
	 */
	@Test
	public void testGetCurrentIndex() {
		Simulator simulator = new Simulator(3, 12);
		assertEquals(-1, simulator.getCurrentIndex());
		simulator.step();
		assertNotEquals(-1, simulator.getCurrentIndex());
	}

	/**
	 * Tests getting the color of the current cart
	 */
	@Test
	public void testGetCurrentCartColor() {
		Simulator simulator = new Simulator(3, 12);
		simulator.step();
		int registerIndex = simulator.getCurrentIndex();
		// all lines are empty so the cart will join the register that matches
		// its type
		Color color = null;
		if (registerIndex == 0) {
			color = Color.GREEN;
		} else if (registerIndex == 1) {
			color = Color.BLUE;
		} else if (registerIndex == 2) {
			color = Color.RED;
		}
		assertEquals(color, simulator.getCurrentCartColor());
	}

	/**
	 * Tests telling whether the cart has left the simulation or not
	 */
	@Test
	public void testItemLeftSimulation() {
		Simulator simulator = new Simulator(3, 12);
		simulator.step();
		assertFalse(simulator.itemLeftSimulation()); // first step is always to
														// add a cart to a line
		for (int i = 0; i < simulator.totalNumberOfSteps() - 1; i++) {
			simulator.step();
		}
		assertTrue(simulator.itemLeftSimulation());
	}

	/**
	 * Tests getting the average wait time
	 */
	@Test
	public void testAverageWaitTime() {
		Simulator simulator = new Simulator(3, 12);
		assertEquals(0, (int) simulator.averageWaitTime());
	}

	/**
	 * Tests getting the average process time
	 */
	@Test
	public void testAverageProcessTime() {
		Simulator simulator = new Simulator(3, 12);
		assertEquals(0, (int) simulator.averageProcessTime());
	}
}
