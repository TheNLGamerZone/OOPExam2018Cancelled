import java.util.Objects;

/**
 * This object represents a car. 
 * Extends from {@link Vehicle}.
 * @author Tim
 *
 */
public abstract class Car extends Vehicle
{
	private String enginePower;
	
	public Car(String brand, String modelName, int price, String enginePower)
	{
		super(brand, modelName, price);
		
		this.enginePower = enginePower;
	}

	/**
	 * Returns a string representing the engine power of this car.
	 * @return A string representing the engine power of this car.
	 */
	public String getEnginePower()
	{
		return this.enginePower;
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
		
		if (!(object instanceof Car))
		{
			return false;
		}
		
		Car car = (Car) object;
		
		return this.getBrand().equals(car.getBrand()) &&
				this.getModelName().equals(car.getModelName()) &&
				this.getEnginePower().equals(car.getEnginePower()) &&
				this.getPrice() == car.getPrice();
	}
	
	/**
	 * Returns the hash code of this object.
	 */
	@Override
	public int hashCode()
	{
		return Objects.hash(this.getBrand(), this.getModelName(), this.enginePower, this.getPrice());
	}
}
