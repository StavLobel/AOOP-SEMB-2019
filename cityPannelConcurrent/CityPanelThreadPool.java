package cityPannelConcurrent;

import java.awt.Graphics;
import java.util.LinkedList;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import DesignPatterns.*;
import cityTraffic.Observable;
import cityTraffic.Observer;
import vehicleGraphicsDecorator.VehicleGraphicDecorator;
import vehicles.Vehicle;

/**
 * The Class CityPanelThreadPool.
 * 
 * @author Stav Lobel
 */
public class CityPanelThreadPool implements Runnable{
	
	private boolean active = true;
	
	private final int MAX_RUNNING;
	
	/** The pool. */
	private LinkedList<IVehicle> pool;
	
	/** The queue. */
	private BlockingQueue<IVehicle> queue;
	
	/**
	 * Instantiates a new city panel thread pool.
	 *
	 * @param maxRunning the max running
	 * @param maxWaiting the max waiting
	 */
	public CityPanelThreadPool(int maxRunning,int maxWaiting) {
		queue = new LinkedBlockingDeque<IVehicle>(maxWaiting);
		MAX_RUNNING = maxRunning;
	}
	
	public void run() {
		while (active) {
			while ((queue.isEmpty() || pool.size() >= MAX_RUNNING) && active) {
				synchronized (this) {
					try {
						wait();
					}
					catch (InterruptedException e) {}
				}
			}
			dequeue();
		}
	}
	
	private boolean dequeue() {
		IVehicle toRun = null;
		synchronized (pool) {
			if (pool.size() < MAX_RUNNING) {
				toRun = queue.remove();
				pool.add(toRun);
				(new Thread(toRun)).start();
			}
		}
		return true;
	}
	
	/**
	 * Adds the vehicle.
	 *
	 * @param v the vehicle
	 * @return true, if successful
	 * @throws Exception the exception
	 */
	public boolean addVehicle(IVehicle v) throws Exception{
		if (!(queue.remainingCapacity() > 0))
			throw new Exception("Cannot create more vehicles.");
		synchronized (queue) {
			if (!(queue.remainingCapacity() > 0))
				throw new Exception("Cannot create more vehicles.");
			queue.add(v);
			this.notify();
		}
		return true;
	}
	
	/**
	 * Gets the number of active vehicles.
	 *
	 * @return the number of active vehicles
	 */
	public int getNumberOfActiveVehicles() {
		return pool.size();
	}
	
	public boolean hasActiveVehicles() {
		return !pool.isEmpty();
	}
	
	public boolean queueIsEmpty() {
		return queue.isEmpty();
	}
	
	
	/**
	 * Gets the active vehicles.
	 *
	 * @return the active vehicles
	 */
	public IVehicle[] GetPool() {
		IVehicle[] temp = null;
		if (pool.isEmpty() == false) {
			synchronized (pool) {
				temp = new IVehicle[pool.size()];
				for (int i = 0 ; i < pool.size() ; ++i)
					temp[i] = pool.get(i);
			}	
		}
		return temp;
	}
	
	public boolean paintVehicles(Graphics g) {
		if (pool.isEmpty())
			return false;
		synchronized (pool) {
			if (pool.isEmpty())
				return false;
			IVehicle[] toDraw = GetPool();
			for (int i = 0 ; i < toDraw.length ; ++i) {
				((VehicleGraphicDecorator) toDraw[i]).drawObject(g); 
			}
		}
		return true;
	}
	
	/**
	 * Kill all active vehicles.
	 *
	 * @return true, if successful
	 */
	public boolean killAllActiveVehicles() {
		if (pool.isEmpty())
			return false;
		synchronized (pool) {
			while (pool.isEmpty() == false) {
				((IVehicle) pool.removeFirst()).getCore().kill("User");
			}
		}
		synchronized (this) {
			notify();	
		}
		return true;
	}
	
	/**
	 * Kill all vehicles.
	 *
	 * @return true, if successful
	 */
	public boolean killAllVehicles() {
		synchronized (queue) {
			while (queue.isEmpty() == false) {
				queue.remove().getCore().kill("User");
			}
		}
		synchronized (pool) {
			while (pool.isEmpty() == false) {
				pool.remove().getCore().kill("User");
			}
		}
		return true;
	}
	
	public boolean killVehicle(Vehicle toKill,String byWho) {
		for (int i = 0 ; i < pool.size() ; ++i) {
			if (pool.get(i).getCore().equals(toKill)) {
				activeVehicles.remove(i).getCore().kill(byWho);
				return true;
			}
		}
		return false;
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
