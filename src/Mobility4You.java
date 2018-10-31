import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Comparator;

/**
 * This is the main application object.
 * @author Tim
 *
 */
public class Mobility4You {
	private Catalog catalog;
	
	public Mobility4You()
	{
		this.catalog = new Catalog();
	}
	
	/**
	 * Initializes the application by reading the file with data
	 * @param fileName file name
	 */
	public void init(String fileName)
	{
		BufferedReader reader;
		
		try 
		{
			reader = new BufferedReader(new FileReader(fileName));
			String currentLine;
			
			while ((currentLine = reader.readLine()) != null)
			{
				this.parseString(currentLine);
			}
		} catch (IOException e)
		{
			e.printStackTrace();
		}
	}
	
	/**
	 * Parses a given string.
	 * @param dataLine string to parse
	 */
	private void parseString(String dataLine)
	{
		String identifier = dataLine.split("\\s")[0];
		String[] data = dataLine.split(",\\s");
		data[0] = String.join("\\s", Arrays.copyOfRange(data[0].split("\\s"), 1, data[0].split("\\s").length));
				
		switch (identifier) {
		case "ELECTRIC_CAR":
			this.catalog.addVehicle(ElectricCar.read(data));
			break;
		case "GAS_CAR":
			this.catalog.addVehicle(GasCar.read(data));
			break;
		case "HYBRID_CAR":
			this.catalog.addVehicle(HybridCar.read(data));
			break;
		}
	}
	
	/**
	 * Saves the data currently in memory to the given file.
	 * @param fileName file name
	 */
	public void save(String fileName)
	{
		try 
		{
			PrintWriter writer = new PrintWriter(new File(fileName));
			
			for (Vehicle vehicle : this.catalog.getVehicles())
			{
				writer.println(vehicle.toString());
			}
			
			writer.close();
		} catch (FileNotFoundException e) 
		{
			e.printStackTrace();
		}
	}
	
	/**
	 * Calls {@link Catalog#addVehicle(Vehicle)} to add the given vehicle.
	 * @param vehicle the vehicle to add
	 */
	public synchronized void addVehicle(Vehicle vehicle)
	{
		this.catalog.addVehicle(vehicle);		
	}
	
	/**
	 * Calls {@link Catalog#sortWithComparator(Comparator)} to sort the catalog.
	 * @param comparator comparator to use
	 */
	public synchronized void sortWithComparator(Comparator<Vehicle> comparator)
	{	
		this.catalog.sortWithComparator(comparator);
	}
	
	/**
	 * Returns the instance of {@link Catalog} that is being used.
	 * @return The instance of {@link Catalog} that is being used.
	 */
	public Catalog getCatalog()
	{
		return this.catalog;
	}
}
