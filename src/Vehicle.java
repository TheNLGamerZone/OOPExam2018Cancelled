import java.util.Objects;

/**
 * This object represents a vehicle.
 * @author Tim
 *
 */
public abstract class Vehicle 
{
	private String brand;
	private String modelName;
	private int price;
	
	public Vehicle(String brand, String modelName, int price)
	{
		this.brand = brand;
		this.modelName = modelName;
		this.price = price;
	}
	
	/**
	 * Returns a string representing the brand of this vehicle.
	 * @return A string representing the brand of this vehicle.
	 */
	public String getBrand()
	{
		return this.brand;
	}
	
	/**
	 * Returns a string representing the model name of this vehicle.
	 * @return A string representing the model name of this vehicle.
	 */
	public String getModelName()
	{
		return this.modelName;
	}
	
	/**
	 * Returns a string representing the price of this vehicle.
	 * @return A string representing the price of this vehicle.
	 */
	public int getPrice()
	{
		return this.price;
	}
	
	/**
	 * Returns a textual representation of this object.
	 */
	@Override
	public abstract String toString();
	
	/**
	 * Returns true if the given object is equal to this object, false otherwise.
	 */
	@Override
	public boolean equals(Object object)
	{
		if (this == object)
		{
			return true;
		}
		
		if (!(object instanceof Vehicle))
		{
			return false;
		}
		
		Vehicle vehicle = (Vehicle) object;
		
		return this.brand.equals(vehicle.getBrand()) &&
				this.modelName.equals(vehicle.getModelName()) &&
				this.price == vehicle.getPrice();
	}
	
	/**
	 * Returns the hash code of this object.
	 */
	@Override
	public int hashCode()
	{
		return Objects.hash(this.brand, this.modelName, this.price);
	}
}
