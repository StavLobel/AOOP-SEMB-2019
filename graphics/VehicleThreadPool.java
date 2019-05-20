package graphics;

import java.util.LinkedList;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import vehicles.Vehicle;

public class VehicleThreadPool {
	private ThreadPoolExecutor pool;
	private BlockingQueue<Runnable> queue;
	private LinkedList<Vehicle> activeVehicles = new LinkedList<Vehicle>();
	
	public VehicleThreadPool(int maxRunning,int maxWating) {
		queue = new LinkedBlockingDeque<Runnable>(maxWating);
		pool = new ThreadPoolExecutor(maxRunning, maxRunning, 1 , TimeUnit.SECONDS, queue);
	}
	
	public boolean addVehicle(Vehicle v) throws Exception{
		if (!(queue.remainingCapacity() > 0))
			throw new Exception("Cannot create more vehicles.");
		activeVehicles.add(v);
		pool.execute(v);
		return true;
	}
	
	public boolean killAllVehicles() {
		int toRemove = getNumberOfActiveVehicles();
		while (toRemove > 0) {
			activeVehicles.remove().killVehicle();
			toRemove -= 1;
		}
		return true;
	}
	
	public Vehicle getActiveVehicle(int index) {
		if (index >= getNumberOfActiveVehicles())
			return null;
		return activeVehicles.get(index);
	}
	
	public LinkedList<Vehicle> getActiveVehicles() {
		LinkedList<Vehicle> temp = new LinkedList<Vehicle>();
		for (int i = 0 ; i < getNumberOfActiveVehicles() ; ++i)
			temp.add(activeVehicles.get(i));
		return temp;
	}
	
	public int getNumberOfActiveVehicles() {
		int count = 0;
		for (int i = 0 ; i < activeVehicles.size() && i < pool.getMaximumPoolSize() ; ++i)
			if (activeVehicles.get(i).getFlag() == true)
				count += 1;
		return count;
	}
	
	public boolean isEmpty() {
		return getNumberOfActiveVehicles() == 0;
	}
	
	public boolean shutdown() {
		pool.shutdown();
		return true;
	}
	
}
