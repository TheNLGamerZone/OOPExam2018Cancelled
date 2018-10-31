import java.util.Objects;

/**
 * This object represents a gas-powered car. 
 * Extends from {@link Car}.
 * @author Tim
 *
 */
public class GasCar extends Car
{
	private String engineDisplacement;
	
	public GasCar(String brand, String modelName, int price, String enginePower, String engineDisplacement) 
	{
		super(brand, modelName, price, enginePower);
		
		this.engineDisplacement = engineDisplacement;
	}

	/**
	 * Returns a string representing the engine displacement of this car.
	 * @return A string representing the engine displacement of this car.
	 */
	public String getEngineDisplacement()
	{
		return this.engineDisplacement;
	}
	
	/**
	 * Returns a new instance of this object based on the given data.
	 * @param data data to be used
	 * @return A new instance of this object based on the given data.
	 */
	public static GasCar read(String[] data)
	{
		String brand = data[0];
		String modelName = data[1];
		String engineDisplacement = data[2];
		String enginePower = data[3];
		int price = Integer.valueOf(data[4].split("\\s")[0]);
		
		return new GasCar(brand, modelName, price, enginePower, engineDisplacement);
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
		
		if (!(object instanceof GasCar))
		{
			return false;
		}
		
		GasCar car = (GasCar) object;
		
		return this.getBrand().equals(car.getBrand()) &&
				this.getModelName().equals(car.getModelName()) &&
				this.getEnginePower().equals(car.getEnginePower()) &&
				this.getEngineDisplacement().equals(car.getEngineDisplacement()) &&
				this.getPrice() == car.getPrice();
	}
	
	/**
	 * Returns the hash code of this object.
	 */
	@Override
	public int hashCode()
	{
		return Objects.hash(this.getBrand(), this.getModelName(), this.getEnginePower(), this.getPrice(), this.getEngineDisplacement());
	}

	/**
	 * Returns a textual representation of this object.
	 */
	@Override
	public String toString() {
		return String.format("GAS_CAR %s, %s, %s, %s, %d euro", this.getBrand(), this.getModelName(), this.getEngineDisplacement(), this.getEnginePower(), this.getPrice());
	}
}
