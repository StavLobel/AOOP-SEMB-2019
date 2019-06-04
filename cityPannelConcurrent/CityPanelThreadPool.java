package cityPannelConcurrent;

import java.awt.Graphics;
import java.util.LinkedList;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import DesignPatterns.*;
import vehicleGraphicsDecorator.VehicleGraphicDecorator;

/**
 * The Class CityPanelThreadPool.
 * 
 * @author Stav Lobel
 */
public class CityPanelThreadPool {
	
	/** The pool. */
	private ThreadPoolExecutor pool;
	
	/** The queue. */
	private BlockingQueue<Runnable> queue;
	
	/** The active vehicles. */
	private LinkedList<IVehicle> activeVehicles = new LinkedList<IVehicle>();
	
	/**
	 * Instantiates a new city panel thread pool.
	 *
	 * @param maxRunning the max running
	 * @param maxWaiting the max waiting
	 */
	public CityPanelThreadPool(int maxRunning,int maxWaiting) {
		queue = new LinkedBlockingDeque<Runnable>(maxWaiting);
		pool = new ThreadPoolExecutor(maxRunning, maxRunning, 1 , TimeUnit.SECONDS, queue);
	}
	
	/**
	 * Adds the vehicle.
	 *
	 * @param v the vehicle
	 * @return true, if successful
	 * @throws Exception the exception
	 */
	public boolean addVehicle(IVehicle v) throws Exception{
		synchronized (queue) {
			if (!(queue.remainingCapacity() > 0))
				throw new Exception("Cannot create more vehicles.");
			activeVehicles.add(v);
			pool.execute(v);
			return true;
		}
	}
	
	/**
	 * Kill all active vehicles.
	 *
	 * @return true, if successful
	 */
	public boolean killAllActiveVehicles() {
		synchronized (activeVehicles) {
			int toRemove = getNumberOfActiveVehicles();
			while (toRemove > 0) {
				activeVehicles.remove().getCore().kill();
				toRemove -= 1;
			}
			return true;
		}	
	}
	
	/**
	 * Gets the number of active vehicles.
	 *
	 * @return the number of active vehicles
	 */
	public int getNumberOfActiveVehicles() {
		synchronized (activeVehicles) {
			int count = 0;
			for (int i = 0 ; i < activeVehicles.size() && i < pool.getMaximumPoolSize() ; ++i)
				if (activeVehicles.get(i).getCore().getFlag() == true)
					count += 1;
			return count;
		}
	}
	
	/**
	 * Gets the active vehicle.
	 *
	 * @param index the index
	 * @return the active vehicle
	 */
	public IVehicle getActiveVehicle(int index) {
		if (index >= getNumberOfActiveVehicles())
			return null;
		synchronized (activeVehicles) {
			return activeVehicles.get(index);
		}
	}
	
	/**
	 * Gets the active vehicles.
	 *
	 * @return the active vehicles
	 */
	public LinkedList<IVehicle> getActiveVehicles() {
		synchronized (activeVehicles) {
			LinkedList<IVehicle> temp = new LinkedList<IVehicle>();
			for (int i = 0 ; i < getNumberOfActiveVehicles() ; ++i)
				temp.add(activeVehicles.get(i));
			return temp;
		}
	}
	
	public boolean paintVehicles(Graphics g) {
		synchronized (activeVehicles) {
			LinkedList<IVehicle> toDraw = getActiveVehicles();
			for (int i = 0 ; i < toDraw.size() ; ++i) {
				((VehicleGraphicDecorator) toDraw.get(i)).drawObject(g); 
			}
		}
		return true;
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
	 * Kill all vehicles.
	 *
	 * @return true, if successful
	 */
	public boolean killAllVehicles() {
		synchronized (activeVehicles) {
			for (int i = 0 ; i < activeVehicles.size() ; ++i)
				activeVehicles.get(i).getCore().kill();
			activeVehicles.clear();
		}
		return true;
	}
	
	/**
	 * Shutdown.
	 *
	 * @return true, if successful
	 */
	public synchronized boolean shutdown() {
		killAllVehicles();
		pool.shutdown();
		return true;
	}
}
