package cityPannelConcurrent;

import java.util.LinkedList;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import DesignPatterns.*;

public class CityPanelThreadPool {
	
	private ThreadPoolExecutor pool;
	
	private BlockingQueue<Runnable> queue;
	
	private LinkedList<IVehicle> activeVehicles = new LinkedList<IVehicle>();
	
	public CityPanelThreadPool(int maxRunning,int maxWaiting) {
		queue = new LinkedBlockingDeque<Runnable>(maxWaiting);
		pool = new ThreadPoolExecutor(maxRunning, maxRunning, 1 , TimeUnit.SECONDS, queue);
	}
	
	public boolean addVehicle(IVehicle v) /*throws Exception*/{
		/*if (!(queue.remainingCapacity() > 0))
			throw new Exception("Cannot create more vehicles.");*/
		activeVehicles.add(v);
		pool.execute(v);
		return true;
	}
	
	public boolean killAllVehicles() {
		int toRemove = getNumberOfActiveVehicles();
		while (toRemove > 0) {
			activeVehicles.remove().kill();
			toRemove -= 1;
		}
		return true;
	}
	
	public int getNumberOfActiveVehicles() {
		int count = 0;
		for (int i = 0 ; i < activeVehicles.size() && i < pool.getMaximumPoolSize() ; ++i)
			if (activeVehicles.get(i).getFlag() == true)
				count += 1;
		return count;
	}
	
	public IVehicle getActiveVehicle(int index) {
		if (index >= getNumberOfActiveVehicles())
			return null;
		return activeVehicles.get(index);
	}
	
	public LinkedList<IVehicle> getActiveVehicles() {
		LinkedList<IVehicle> temp = new LinkedList<IVehicle>();
		for (int i = 0 ; i < getNumberOfActiveVehicles() ; ++i)
			temp.add(activeVehicles.get(i));
		return temp;
	}
	
	public boolean isEmpty() {
		return getNumberOfActiveVehicles() == 0;
	}
	
	public boolean shutdown() {
		killAllVehicles();
		pool.shutdown();
		return true;
	}
}
