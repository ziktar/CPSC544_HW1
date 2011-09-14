package edu.fullerton.cpsc544.diceroller.test;

import android.test.ActivityInstrumentationTestCase2;
import edu.fullerton.cpsc544.diceroller.*;

public class DiceRollerTest extends
		ActivityInstrumentationTestCase2<DiceRoller> {

	public DiceRollerTest() {
		super("edu.fullerton.cpsc544.diceroller", DiceRoller.class);
	}
	
	private DiceRoller roller;

	@Override
	protected void setUp() throws Exception {
		super.setUp();
		roller = new DiceRoller();
		roller.rollDice();
	}
	
	public void testRollADie() {
		assertTrue(roller.getUserDie(1) >= 1);
		assertTrue(roller.getUserDie(2) >= 1);
		assertTrue(roller.getUserDie(1) <= 6);
		assertTrue(roller.getUserDie(2) <= 6);

		assertTrue(roller.getComputerDie(1) >= 1);
		assertTrue(roller.getComputerDie(2) >= 1);
		assertTrue(roller.getComputerDie(1) <= 6);
		assertTrue(roller.getComputerDie(2) <= 6);
		
		try {
			roller.getUserDie(0);
			fail();
		} catch (Exception e) {
		}
		
		try {
			roller.getUserDie(3);
			fail();
		} catch (Exception e) {
		}
		
		try {
			roller.getComputerDie(0);
			fail();
		} catch (Exception e) {
		}
		
		try {
			roller.getComputerDie(3);
			fail();
		} catch (Exception e) {
		}
	}

	public void testGetUserDieRollSum() {
		int userDieRollerSum = roller.getUserDieRollSum();
		assertTrue("userDieRollerSum should be >= 2, but was " + userDieRollerSum, userDieRollerSum >= 2);
		assertTrue("userDieRollerSum should be <= 12, but was " + userDieRollerSum, userDieRollerSum <= 12);
	}

	public void testGetComputerDieRollSum() {
		int computerDieRollerSum = roller.getComputerDieRollSum();
		assertTrue("computerDieRollerSum should be >= 2, but was " + computerDieRollerSum, computerDieRollerSum >= 2);
		assertTrue("computerDieRollerSum should be <= 12, but was " + computerDieRollerSum, computerDieRollerSum <= 12);
	}

	public void testComputeWinner() {
		assertEquals(-1, roller.computeWinner(2, 3));
		assertEquals(-1, roller.computeWinner(2, 12));
		assertEquals(-1, roller.computeWinner(11, 12));

		assertEquals(0, roller.computeWinner(2, 2));
		assertEquals(0, roller.computeWinner(3, 3));
		assertEquals(0, roller.computeWinner(12, 12));

		assertEquals(1, roller.computeWinner(3, 2));
		assertEquals(1, roller.computeWinner(12, 2));
		assertEquals(1, roller.computeWinner(12, 11));
	}
}
