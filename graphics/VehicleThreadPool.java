package graphics;

import java.util.LinkedList;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import vehicles.Vehicle;

/**
 * The Class VehicleThreadPool.
 */
public class VehicleThreadPool {
	
	/** The pool. */
	private ThreadPoolExecutor pool;
	
	/** The queue. */
	private BlockingQueue<Runnable> queue;
	
	/** The active vehicles. */
	private LinkedList<Vehicle> activeVehicles = new LinkedList<Vehicle>();
	
	/**
	 * Instantiates a new vehicle thread pool.
	 *
	 * @param maxRunning the max running
	 * @param maxWating the max waiting
	 */
	public VehicleThreadPool(int maxRunning,int maxWaiting) {
		queue = new LinkedBlockingDeque<Runnable>(maxWaiting);
		pool = new ThreadPoolExecutor(maxRunning, maxRunning, 1 , TimeUnit.SECONDS, queue);
	}
	
	/**
	 * Adds the vehicle.
	 *
	 * @param v the new vehicle
	 * @return true, if successful
	 * @throws Exception the exception
	 */
	public boolean addVehicle(Vehicle v) throws Exception{
		if (!(queue.remainingCapacity() > 0))
			throw new Exception("Cannot create more vehicles.");
		activeVehicles.add(v);
		pool.execute(v);
		return true;
	}
	
	/**
	 * Kill all vehicles.
	 *
	 * @return true, if successful
	 */
	public boolean killAllVehicles() {
		int toRemove = getNumberOfActiveVehicles();
		while (toRemove > 0) {
			activeVehicles.remove().killVehicle();
			toRemove -= 1;
		}
		return true;
	}
	
	/**
	 * Gets the active vehicle.
	 *
	 * @param index the index
	 * @return the active vehicle
	 */
	public Vehicle getActiveVehicle(int index) {
		if (index >= getNumberOfActiveVehicles())
			return null;
		return activeVehicles.get(index);
	}
	
	/**
	 * Gets the active vehicles.
	 *
	 * @return the active vehicles
	 */
	public LinkedList<Vehicle> getActiveVehicles() {
		LinkedList<Vehicle> temp = new LinkedList<Vehicle>();
		for (int i = 0 ; i < getNumberOfActiveVehicles() ; ++i)
			temp.add(activeVehicles.get(i));
		return temp;
	}
	
	/**
	 * Gets the number of active vehicles.
	 *
	 * @return the number of active vehicles
	 */
	public int getNumberOfActiveVehicles() {
		int count = 0;
		for (int i = 0 ; i < activeVehicles.size() && i < pool.getMaximumPoolSize() ; ++i)
			if (activeVehicles.get(i).getFlag() == true)
				count += 1;
		return count;
	}
	
	/**
	 * Checks if is empty.
	 *
	 * @return true, if is empty
	 */
	public boolean isEmpty() {
		return getNumberOfActiveVehicles() == 0;
	}
	
	/**
	 * Shutdown.
	 *
	 * @return true, if successful
	 */
	public boolean shutdown() {
		pool.shutdown();
		return true;
	}
	
}
