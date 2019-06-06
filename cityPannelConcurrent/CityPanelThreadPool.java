package cityPannelConcurrent;

import java.awt.Graphics;
import java.util.LinkedList;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;

import designPatterns.*;
import graphics.CityPanel;
import vehicleGraphicsDecorator.VehicleGraphicDecorator;
import vehicles.Vehicle;

/**
 * The Class CityPanelThreadPool.
 * 
 * @author Stav Lobel
 */
public class CityPanelThreadPool implements Runnable,Observer{
	
	private boolean active = true;
	
	private final int MAX_RUNNING;
	
	private final String USER_TAG = "User";
	
	/** The pool. */
	LinkedList<IVehicle> pool = new LinkedList<IVehicle>();
	
	/** The queue. */
	private BlockingQueue<IVehicle> queue;
	
	private CityPanel panel;
	
	/**
	 * Instantiates a new city panel thread pool.
	 *
	 * @param maxRunning the max running
	 * @param maxWaiting the max waiting
	 */
	public CityPanelThreadPool(int maxRunning,int maxWaiting,CityPanel panel) {
		this.panel = panel;
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
	
	public boolean getNotified(Observable observable,String msg) {
		if (msg.equals(Vehicle.KILLED)) {
			synchronized (pool) {
				pool.remove(getIndex((Vehicle) observable));
			}
			synchronized (this) {
				this.notify();
			}
			return true;
		}
		else if (msg.equals("Exit"))
			this.shutdown();
		return false;	
	}
	
	private boolean dequeue() {
		IVehicle toRun = null;
		synchronized (pool) {
			if (pool.size() < MAX_RUNNING) {
				toRun = queue.remove();
				pool.add(toRun);
				(new Thread(toRun.getCore())).start();
				panel.infoButton.addVehicle(toRun);
				toRun.getCore().addObserver(panel.infoButton);
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
		synchronized (queue) {
			try {
				queue.add(v);
				v.getCore().addObserver(this);
			}
			catch (Exception e) {
				throw new Exception("Cannot create more vehicles.");	
			}
			synchronized (this) {
				this.notify();
			}
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
	public boolean ClearActivePool() {
		if (pool.isEmpty())
			return false;
		synchronized (pool) {
			pool.forEach(v -> v.getCore().kill(USER_TAG));
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
	public boolean ClearPool() {
		synchronized (queue) {
			while (queue.isEmpty() == false) {
				queue.forEach(v -> v.getCore().kill(USER_TAG));
			}
		}
		synchronized (pool) {
			while (pool.isEmpty() == false) {
				pool.forEach(v -> v.getCore().kill(USER_TAG));
			}
		}
		return true;
	}
	
	private int getIndex(Vehicle v) {
		if (!pool.isEmpty()) {
			synchronized (pool) {
				for (int i = 0 ; i < pool.size() ; ++i)
					if (pool.get(i).getCore().equals(v))
						return i;
			}
		}
		return -1;
	}
	
	/**
	 * Shutdown.
	 *
	 * @return true, if successful
	 */
	public synchronized boolean shutdown() {
		ClearPool();
		active = false;
		return true;
	}
	
	public LinkedList<IVehicle> getAllVehicles(){
		LinkedList<IVehicle> temp = new LinkedList<IVehicle>();
		synchronized (pool) {
			pool.forEach(v -> temp.add((IVehicle) v.clone()));
		}
		synchronized (queue) {
			queue.forEach(v -> temp.add((IVehicle) v));
		}
		return temp;
	}
}
