import java.util.Comparator;
import java.util.Scanner;

public class Main {

	/**
	 * Start user input
	 * @param strings program args
	 */
	public static void main(String... strings)
	{
		Mobility4You application = new Mobility4You();
		Scanner input = new Scanner(System.in);
		
		System.out.print("What file to use: ");
		String fileName = input.nextLine();
		
		// Init app
		application.init(fileName);
		
		// Start user menu
		readInput(input, application, fileName);
		
		System.out.println("Program stopped.");
	}
	
	/**
	 * Read user input.
	 * @param scanner scanner to read from/with
	 * @param application instance of main application
	 * @param fileName file name
	 */
	private static void readInput(Scanner scanner, Mobility4You application, String fileName)
	{
		main:
		while (true)
		{
			System.out.println("Please make your choice:\n"
					+ "1 - Show the entire Mobility4Your catalogue\n"
					+ "2 - Add a new electric car\n"
					+ "3 - Add a new gas-powered car\n"
					+ "4 - Add a new hybrid car\n"
					+ "5 - Show the entire Mobility4You catalogue sorted by car-type\n"
					+ "6 - Show the entire Mobility4You catalogue sorted by brand (alphabetically)\n"
					+ "7 - Write to file\n"
					+ "8 - Stop the program");
			String currentInput = scanner.nextLine();
			
			switch (currentInput)
			{
			case "1":
				System.out.println(application.getCatalog());
				break;
			case "2":
				application.addVehicle(createCar(scanner, "ELECTRIC"));
				System.out.println("Added new car to catalogue.");
				break;
			case "3":
				application.addVehicle(createCar(scanner, "GAS"));
				System.out.println("Added new car to catalogue.");
				break;
			case "4":
				application.addVehicle(createCar(scanner, "HYBRID"));
				System.out.println("Added new car to catalogue.");
				break;
			case "5":
				startSort(new CarTypeComparator(), application);
				break;
			case "6":
				startSort(new VehicleBrandComparator(), application);
				break;
			case "7":
				application.save(fileName);
				System.out.println("Written to file.");
				break;
			case "8":
				break main;
			default:
				System.out.println("That is not a valid option!");
			}
		}
	
		// Exiting app
		application.save(fileName);
	}
	
	/**
	 * Start sorting with the given comparator.
	 * @param comparator comparator to sort with
	 * @param application instance of main application
	 */
	private static void startSort(Comparator<Vehicle> comparator, Mobility4You application)
	{
		SortThread sortThread = new SortThread(comparator, application);
		
		sortThread.start();
	}
	
	/**
	 * Create a car from user input.
	 * @param scanner scanner to read from/with
	 * @param carType car type to create
	 * @return A new car instance based on user input.
	 */
	private static Car createCar(Scanner scanner, String carType)
	{
		System.out.println("Adding new " + carType.toLowerCase() + " car to catalogue: ");
		
		String brand = requestFromUser(scanner, "brand");
		String modelName = requestFromUser(scanner, "model name");
		int price = Integer.valueOf(requestFromUser(scanner, "price"));
		String enginePower = requestFromUser(scanner, "engine power");
		
		switch (carType)
		{
		case "GAS":
			String engineDisplacement = requestFromUser(scanner, "engine displacement");
			
			return new GasCar(brand, modelName, price, enginePower, engineDisplacement);
		case "ELECTRIC":
			String batteryCapacity = requestFromUser(scanner, "battery capacity");
			
			return new ElectricCar(brand, modelName, price, enginePower, batteryCapacity);
		case "HYBRID":
			engineDisplacement = requestFromUser(scanner, "engine displacement");
			batteryCapacity = requestFromUser(scanner, "battery capacity");

			return new HybridCar(brand, modelName, price, enginePower, engineDisplacement, batteryCapacity);
		}
		
		
		return null;
	}
	
	/**
	 * Returns input from user.
	 * @param scanner scanner to read from/with
	 * @param request question to be asked
	 * @return Input from user.
	 */
	private static String requestFromUser(Scanner scanner, String request)
	{
		System.out.printf("Please enter the %s of the car: ", request);
		
		return scanner.nextLine();
	}
}
