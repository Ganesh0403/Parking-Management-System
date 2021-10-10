package test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import parking.HomePage;
import parking.TotalRevenue;

public class TotalRevenueTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testCorrect() {
		TotalRevenue obj9 = new TotalRevenue();
		assertEquals(29740, obj9.getTotalRevenue(20));
	}

	@Test
	public void testCorrect1() {
		TotalRevenue obj9 = new TotalRevenue();
		assertEquals(28253, obj9.getTotalRevenue(19));
	}

}
