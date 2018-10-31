import java.util.Comparator;

/**
 * Comparator that compares the brands of vehicles.
 * @author Tim
 *
 */
public class VehicleBrandComparator implements Comparator<Vehicle>
{
	/**
	 * Compares the vehicle brands of two vehicles.
	 */
	@Override
	public int compare(Vehicle vehicle1, Vehicle vehicle2) {
		String firstBrand = vehicle1.getBrand();
		String secondBrand = vehicle2.getBrand();
				
		return firstBrand.compareTo(secondBrand);
	}
}
