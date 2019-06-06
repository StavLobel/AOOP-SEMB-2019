package panelButtons;

import java.util.LinkedList;
import java.util.concurrent.ConcurrentHashMap;

import designPatterns.IVehicle;

public class CityMemento {
	private LinkedList<IVehicle> vehicles = new LinkedList<IVehicle>();
	
	private ConcurrentHashMap<IVehicle,ConcurrentHashMap<String, String>> table = new ConcurrentHashMap<IVehicle, ConcurrentHashMap<String,String>>();
	
	public void addVehiclesToMemento(LinkedList<IVehicle> vehicles) {
		this.vehicles = vehicles;
	}
	
	public void addTableToMemento(ConcurrentHashMap<IVehicle,ConcurrentHashMap<String, String>> table) {
		for (IVehicle iV : table.keySet()) {
			this.table.put((IVehicle) iV.clone(), table.get(iV));
		}
	}
	
	public LinkedList<IVehicle> getVehicles(){
		return vehicles;
	}
	
	public  ConcurrentHashMap<IVehicle,ConcurrentHashMap<String, String>> getTable(){
		return this.table;
	}
	
	public boolean clearMemento() {
		vehicles = new LinkedList<IVehicle>();
		table = new ConcurrentHashMap<IVehicle, ConcurrentHashMap<String,String>>();
		return true;
	}
}
