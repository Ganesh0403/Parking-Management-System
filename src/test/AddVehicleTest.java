package test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import parking.AddVehicle;


public class AddVehicleTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testCorrect() {
		AddVehicle obj9 = new AddVehicle();
		assertEquals(false, obj9.AddVehicles("","","","","","","",""));
	}

//	@Test
//	public void testCorrect1() {
//		AddVehicle obj9 = new AddVehicle();
//		assertEquals(true, obj9.AddVehicles("1","Bhavansh","MH14CC1234"," 12:34:50","2021-10-10","UPI","2","8888888888"));
//	}
	
	@Test
	public void testCorrect2() {
		AddVehicle obj9 = new AddVehicle();
		assertEquals(true, obj9.AddVehicles("4","Bhavansh","MH14CC1234"," 12:34:50","2021-10-10","UPI","2","8888888888"));
	}
	@Test
	public void testCorrect3() {
		AddVehicle obj9 = new AddVehicle();
		assertEquals(true, obj9.AddVehicles("5","Jitu","MH14CC1234"," 12:34:50","2021-10-10","UPI","2","8888888888"));
	}
	@Test
	public void testCorrect4() {
		AddVehicle obj9 = new AddVehicle();
		assertEquals(true, obj9.AddVehicles("6","Ganesh","MH14CC1234"," 12:34:50","2021-10-10","UPI","2","8888888888"));
	}

}
