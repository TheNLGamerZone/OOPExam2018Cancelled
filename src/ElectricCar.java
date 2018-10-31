import java.util.Objects;

/**
 * This object represents a electric car. 
 * Extends from {@link Car}.
 * @author Tim
 *
 */
public class ElectricCar extends Car
{
	private String batteryCapacity;
	
	public ElectricCar(String brand, String modelName, int price, String enginePower, String batteryCapacity) 
	{
		super(brand, modelName, price, enginePower);
		
		this.batteryCapacity = batteryCapacity;
	}

	/**
	 * Returns a string representing the battery capacity of this car.
	 * @return A string representing the battery capacity of this car.
	 */
	public String getBatteryCapacity()
	{
		return this.batteryCapacity;
	}
	
	/**
	 * Returns a new instance of this object based on the given data.
	 * @param data data to be used
	 * @return A new instance of this object based on the given data.
	 */
	public static ElectricCar read(String[] data)
	{
		String brand = data[0];
		String modelName = data[1];
		String enginePower = data[2];
		String batteryCapacity = data[3];
		int price = Integer.valueOf(data[4].split("\\s")[0]);
		
		return new ElectricCar(brand, modelName, price, enginePower, batteryCapacity);
	}
	
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
		
		if (!(object instanceof ElectricCar))
		{
			return false;
		}
		
		ElectricCar car = (ElectricCar) object;
		
		return this.getBrand().equals(car.getBrand()) &&
				this.getModelName().equals(car.getModelName()) &&
				this.getEnginePower().equals(car.getEnginePower()) &&
				this.getBatteryCapacity().equals(car.getBatteryCapacity()) &&
				this.getPrice() == car.getPrice();
	}
	
	/**
	 * Returns the hash code of this object.
	 */
	@Override
	public int hashCode()
	{
		return Objects.hash(this.getBrand(), this.getModelName(), this.getEnginePower(), this.getPrice(), this.getBatteryCapacity());
	}

	/**
	 * Returns a textual representation of this object.
	 */
	@Override
	public String toString() {
		return String.format("ELECTRIC_CAR %s, %s, %s, %s, %d euro", this.getBrand(), this.getModelName(), this.getEnginePower(), this.getBatteryCapacity(), this.getPrice());
	}
}
