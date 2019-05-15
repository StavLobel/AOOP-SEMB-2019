package MyConcurrent;

import java.util.ArrayList;
import java.util.concurrent.ArrayBlockingQueue;

public class MyThreadPool {
	private final int MAX_THREADS;
	private ArrayBlockingQueue<Runnable> missionsQueue;
	private ArrayList<Thread> nowRunning = new ArrayList<Thread>();
	
	public MyThreadPool(int maxOfWorkingThreads,int maxSizeOfQueue) {
		MAX_THREADS = maxOfWorkingThreads;
		missionsQueue = new ArrayBlockingQueue<Runnable>(maxSizeOfQueue);
	}
	
	public boolean insertMission(Runnable mission) {
		boolean result = missionsQueue.add(mission);
		notifyThreads();
		return result;
	}
	
	private boolean notifyThreads() {
		while (nowRunning.size() < MAX_THREADS && !missionsQueue.isEmpty()) {
			nowRunning.add(new Thread(missionsQueue.remove()));
		}
		startThreads();
		return true;
	}
	
	private boolean startThreads() {
		nowRunning.forEach(n -> startThread(n));
		return true;
	}
	
	private static boolean startThread(Thread toStart) {
		if (!toStart.isAlive()) {
			toStart.start();
			return true;
		}
		return false;
	}
	
	public boolean clearAll() {
		missionsQueue.clear();
		nowRunning.forEach(n -> n.);
	}
}
