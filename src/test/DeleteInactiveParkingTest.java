package test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import parking.HomePage;

public class DeleteInactiveParkingTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
		HomePage obj9 = new HomePage();
		assertEquals(true, obj9.DeleteInactiveParking());
	}

}
