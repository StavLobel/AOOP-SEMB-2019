package cityTraffic;

import java.util.LinkedList;

import DesignPatterns.IVehicle;
import DesignPatterns.VehicleDecorator;

public class ObserversDecorator extends VehicleDecorator implements Observable {
	
	private LinkedList<Observer> observers = new LinkedList<Observer>();
	
	public ObserversDecorator(IVehicle vehicle) {
		super(vehicle);
	}
	
	public synchronized boolean addObserver(Observer observer) {
		return observers.add(observer);
	}
	
	public synchronized boolean removeObserver(Observer observer) {
		return observers.remove(observer);
	}
	
	public boolean notifyObservers() {
		observers.forEach(n -> n.getNotified(this));
		return true;
	}
	
	public void run() {
		super.run();
		notifyObservers();
	}
	
}
