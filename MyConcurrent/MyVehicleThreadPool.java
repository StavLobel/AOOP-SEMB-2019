package MyConcurrent;

import java.util.ArrayList;
import java.util.concurrent.ArrayBlockingQueue;

import vehicles.Vehicle;

public class MyVehicleThreadPool {
	private final int MAX_THREADS;
	private ArrayBlockingQueue<Vehicle> missionsQueue;
	private ArrayList<Vehicle> nowRunning = new ArrayList<Vehicle>();
	
	public MyVehicleThreadPool(int maxOfWorkingThreads,int maxSizeOfQueue) {
		MAX_THREADS = maxOfWorkingThreads;
		missionsQueue = new ArrayBlockingQueue<Vehicle>(maxSizeOfQueue);
	}
	
	public boolean insertMission(Vehicle mission) {
		boolean result = missionsQueue.add(mission);
		notifyThreads();
		return result;
	}
	
	private boolean notifyThreads() {
		while (nowRunning.size() < MAX_THREADS && !missionsQueue.isEmpty()) {
			nowRunning.add(missionsQueue.remove());
		}
		startThreads();
		return true;
	}
	
	private boolean startThreads() {
		nowRunning.forEach(n -> startThread(n));
		return true;
	}
	
	private static boolean startThread(Vehicle toStart) {
		if (!toStart.getFlag()) {
			toStart.start();
			return true;
		}
		return false;
	}
	
	public boolean clearAll() {
		missionsQueue.clear();
		nowRunning.forEach(n -> n.kill());
		return true;
	}
}
