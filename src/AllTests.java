import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import org.junit.Before;
import org.junit.Test;

public class AllTests {
	Object testObject;
	String hybridString = "Toyota, Prius, 1.5L, 50KW, 12000Ah, 24000 euro";
	String gasString = "Honda, Civic, 1.5L, 80KW, 18000 euro";
	String electricString = "Tesla, Model 3, 150KW, 50000Ah, 30000 euro";
	
	// Electric objects
	ElectricCar eCar1;
	ElectricCar eCar2;
	
	// Gas objects
	GasCar gCar1;
	GasCar gCar2;
	
	// Hybrid objects
	HybridCar hCar1;
	HybridCar hCar2;
	
	@Before
	public void setup()
	{
		testObject = new Object();
		eCar1 = new ElectricCar("Tesla", "Model 3", 30000, "150KW", "50000Ah");
		eCar2 = new ElectricCar("Tesla", "Model 3", 30000, "150KW", "50000Ah");
		
		gCar1 = new GasCar("Honda", "Civic", 18000, "80KW", "1.5L");
		gCar2 = new GasCar("Honda", "Civic", 18000, "80KW", "1.5L");
		
		hCar1 = new HybridCar("Toyota", "Prius", 24000, "50KW", "1.5L", "12000Ah");
		hCar2 = new HybridCar("Toyota", "Prius", 24000, "50KW", "1.5L", "12000Ah");
	}
	
	/* -- Electric Tests -- */
	@Test
	public void electric_equals_not_instance()
	{
		assertFalse(eCar1.equals(testObject));
	}
	
	@Test
	public void electric_equals_not_equal()
	{
		assertFalse(eCar1.equals(new ElectricCar("", "", 0, "", "")));
	}
	
	@Test
	public void electric_equals_equal()
	{
		assertEquals(eCar1, eCar2);
	}
	
	@Test
	public void electric_read_test()
	{
		assertEquals(eCar1, ElectricCar.read(electricString.split(",\\s")));
	}
	
	@Test
	public void electric_get_batcap()
	{
		assertEquals(eCar1.getBatteryCapacity(), "50000Ah");
	}
	
	
	
	/* -- Gas Tests -- */
	@Test
	public void gas_equals_not_instance()
	{
		assertFalse(gCar1.equals(testObject));
	}
	
	@Test
	public void gas_equals_not_equal()
	{
		assertFalse(gCar1.equals(new GasCar("", "", 0, "", "")));
	}
	
	@Test
	public void gas_equals_equal()
	{
		assertEquals(gCar1, gCar2);

	}
	
	@Test
	public void gas_read_test()
	{
		assertEquals(gCar1, GasCar.read(gasString.split(",\\s")));
	}
	
	@Test
	public void gas_get_engdis()
	{
		assertEquals(gCar1.getEngineDisplacement(), "1.5L");
	}
	
	
	
	/* -- Hybrid Tests -- */
	@Test
	public void hybrid_equals_not_instance()
	{
		assertFalse(hCar1.equals(testObject));
	}
	
	@Test
	public void hybrid_equals_not_equal()
	{
		assertFalse(hCar1.equals(new HybridCar("", "", 0, "", "", "")));
	}
	
	@Test
	public void hybrid_equals_equal()
	{
		assertEquals(hCar1, hCar2);
	}
	
	@Test
	public void hybrid_read_test()
	{
		assertEquals(hCar1, HybridCar.read(hybridString.split(",\\s")));
	}
	
	@Test
	public void hybrid_get_batcap()
	{
		assertEquals(hCar1.getBatteryCapacity(), "12000Ah");
	}
	
	@Test
	public void hybrid_get_engdis()
	{
		assertEquals(hCar1.getEngineDisplacement(), "1.5L");
	}
}
