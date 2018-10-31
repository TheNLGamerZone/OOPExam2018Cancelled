import java.util.Comparator;

/**
 * Comparator that compares the types of vehicles.
 * @author Tim
 *
 */
public class CarTypeComparator implements Comparator<Vehicle>
{
	/**
	 * Compares the vehicle types of two vehicles.
	 */
	@Override
	public int compare(Vehicle vehicle1, Vehicle vehicle2) {
		String firstIdentifier = vehicle1.toString().split("\\s")[0];
		String secondIdentifier = vehicle2.toString().split("\\s")[0];
				
		return firstIdentifier.compareTo(secondIdentifier);
	}
}
