import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Catalog is an object containing all vehicles that are loaded from files.
 * @author Tim
 *
 */
public class Catalog 
{
	private List<Vehicle> vehicles;
	
	public Catalog()
	{
		this.vehicles = new ArrayList<>();
	}
	
	/**
	 * Adds the given vehicle to the catalog.
	 * @param vehicle the vehicle to add
	 */
	public synchronized void addVehicle(Vehicle vehicle)
	{
		this.vehicles.add(vehicle);		
	}
	
	/**
	 * Returns a list containing all vehicles in the catalog.
	 * @return A list containing all vehicles in the catalog.
	 */
	public List<Vehicle> getVehicles()
	{
		return this.vehicles;
	}
	
	/**
	 * Sorts the catalog using the given comparator.
	 * @param comparator comparator to use
	 */
	public synchronized void sortWithComparator(Comparator<Vehicle> comparator)
	{
		Collections.sort(this.vehicles, comparator);
	}
	
	/**
	 * Returns a textual representation of this object.
	 */
	@Override
	public String toString()
	{
		StringBuilder builder = new StringBuilder();
		
		builder.append("All cars in our catalogue: \n");
		
		for (Vehicle vehicle : this.vehicles)
		{
			builder.append(vehicle + "\n");
		}
		
		return builder.toString();
	}
}
