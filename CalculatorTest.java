package com.simlon.testing;

import static org.junit.Assert.*;

import org.junit.Test;

import com.simlon.testing.Calculator;

public class CalculatorTest {
	Calculator calculator = new Calculator();
	@Test
	public void testSucc() {
		// ARANGE // ACT // ASSERT
		assertEquals("test succ", 2, calculator.succ(1));
		assertEquals("test succ", -2, calculator.succ(-3));
		assertEquals("test succ", 1, calculator.succ(0));
	}
	@Test
	public void pred() {
		// ARANGE // ACT // ASSERT
		assertEquals("test pred", 0, calculator.pred(1));
		assertEquals("test pred", -4, calculator.pred(-3));
		assertEquals("test pred", -1, calculator.pred(0));
	}
	@Test
	public void testAddTwoPositiveNumbers() {
		// ARANGE
		int a = 2;
		int b = 3;
		// ACT
		int somme = calculator.add(a, b);

		// ASSERT
		assertEquals(5, somme);
	}

}
