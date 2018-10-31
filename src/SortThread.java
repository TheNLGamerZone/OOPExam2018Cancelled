import java.util.Comparator;

/**
 * Thread that will take care of sorting.
 * @author Tim
 *
 */
public class SortThread extends Thread
{
	private Comparator<Vehicle> comparator;
	private Mobility4You application;
	
	public SortThread(Comparator<Vehicle> comparator, Mobility4You application)
	{
		super();
		
		this.comparator = comparator;
		this.application = application;
	}
	
	/**
	 * Will run the sorting on another thread.
	 */
	@Override
	public void run()
	{
		this.application.sortWithComparator(this.comparator);
		
		System.out.println(this.application.getCatalog());
	}
}
