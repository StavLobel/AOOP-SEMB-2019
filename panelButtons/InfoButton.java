package panelButtons;

import java.awt.Color;
import java.awt.Dialog;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.concurrent.ConcurrentHashMap;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import colorsDecorators.ColorDecorator;
import designPatterns.IVehicle;
import designPatterns.LightsDecorator;
import designPatterns.Observable;
import designPatterns.Observer;
import designPatterns.VehicleDecorator;
import graphics.CityPanel;
import vehicles.IUsingFuel;
import vehicles.Vehicle;

public class InfoButton extends JButton implements Runnable,Observer {
	
	/** The Constant INFO_LABEL. */
	private static final String INFO_LABEL = "Info";
	
	/** The Constant columnNames. */
	private static final String[] columnNames = {"Vehicle","ID","Color","Wheels","Speed","FuelAmount","Distance","Fuel consuption","Lights","Disabled By"};
	
	private CityPanel panel;
	
	private boolean flag = true;
	private boolean changed = false;
	
	private JDialog infoDialog = new JDialog();
	
	private ConcurrentHashMap<IVehicle,ConcurrentHashMap<String, String>> table = new ConcurrentHashMap<IVehicle,ConcurrentHashMap<String, String>>();
	
	public InfoButton (CityPanel panel) {
		super(INFO_LABEL);
		Object[] headline = columnNames;
		panel.lightsButton.addObserver(this);
		this.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				infoDialog.setLocationRelativeTo(null);
				infoDialog.pack();
				infoDialog.setVisible(true);
			}
		});
	}
	
	public boolean addVehicle(IVehicle v) {
		synchronized (v) {
			ConcurrentHashMap<String, String> row = new ConcurrentHashMap<String, String>();
			row.put("Vehicle", v.getCore().getVehicleName());
			row.put("ID", v.getCore().getLicensePlate()+"");
			
			row.put("Color", getColor(v));
			
			row.put("Wheels", v.getCore().getNumberOfWheels()+"");
			row.put("Speed", v.getCore().getSpeed()+"");
			if (v.getCore() instanceof IUsingFuel)
				row.put("FuelAmount", ((IUsingFuel) v.getCore()).getCurrentFuel()+"");
			else
				row.put("FuelAmount", "Not using fuel");
			
			row.put("Distance", v.getCore().getMileage()+"");
			row.put("Fuel Consumption", v.getCore().getConsumedFuelAmount()+"");
			
			row.put("Lights", getLights(v)+"");
			
			row.put("Disabled By",v.getCore().getTakenDownBy());
			
			table.put(v, row);
		}
		
		return true;
	}
	
	private String getColor(IVehicle v) {
		IVehicle temp = v;
		while (temp != null){
			if (temp instanceof ColorDecorator)
				return ((ColorDecorator) temp).getColorName();
			temp = temp.getLowerLayer();
		}
		return "None";
	}
	
	private boolean getLights(IVehicle v) {
		IVehicle temp = v;
		while ((temp instanceof LightsDecorator) == false) {
			if (temp == temp.getCore()) {
				return false;
			}
			temp = temp.getLowerLayer();
		}
		return ((LightsDecorator) temp).isLights();
	}
	
	private IVehicle getIVehicle(Vehicle v) {
		for (IVehicle key : table.keySet()) {
			if (key.getCore().equals(v))
				return key;
		}
		return null;
	}
	
	public synchronized boolean getNotified(Observable observable,String msg) {
		if (msg.equals(LightsButton.LIGHTS_CHANGED)) {
			synchronized (table) {
				for (IVehicle v : table.keySet()) {
					if (v.getCore().getFlag())
						table.get(v).put("Lights", getLights(v)+"");
				}	
			}
		}
		
		else if (msg.equals(Vehicle.KILLED)) {
			synchronized (table) {
				table.get(getIVehicle((Vehicle) observable)).put("Disabled By", ((Vehicle) observable).getTakenDownBy());
			}
		}
		
		else if (msg.equals(Vehicle.MOVED)) {
			synchronized (observable) {
				Vehicle v = (Vehicle) observable;
				IVehicle iV = getIVehicle(v);
				table.get(iV).put("Distance", v.getMileage()+"");
				if (v instanceof IUsingFuel)
					table.get(iV).put("FuelAmount",((IUsingFuel) v).getCurrentFuel()+"");
			}
		}
		
		else if (msg.equals(Vehicle.CAN_MOVE)) {
			synchronized (observable) {
				Vehicle v = (Vehicle) observable;
				IVehicle iV = getIVehicle(v);
				table.get(iV).put("Fuel Consumption", v.getConsumedFuelAmount()+"");
			}
		}
		changed = true;
		synchronized (this) {
			this.notify();
		}
		return true;
		
	}
	
	public void run() {
		while (flag) {
			while (changed == false) {
				synchronized (this) {
					try {
						wait();
					}
					catch (InterruptedException e) {}
				}
			}
			if (changed) {
				synchronized (this) {
					updateTable();
				}
				this.repaint();
			}
		}
	}
	
	public boolean kill() {
		this.flag = false;
		return true;
	}
	
	private boolean updateTable() {
		JTable newTable = buildTable();
		JScrollPane pane = new JScrollPane(newTable);
		 infoDialog = new JDialog();
		infoDialog.add(pane);
		changed = false;
		return true;
	}
	
	private JTable buildTable() {
		Object[][] jTable = new Object[table.size()+1][columnNames.length];
		
		int i = 0;
		for (IVehicle v : table.keySet()) {
			for (int j = 0 ; j < columnNames.length ; ++j)
				jTable[i][j] = table.get(v).get(columnNames[j]);
			i++;
		}
		return new JTable(jTable,columnNames);
	}
	
	public ConcurrentHashMap<IVehicle,ConcurrentHashMap<String, String>> getInfo(){
		return this.table;
	}
	
	public boolean setTable(ConcurrentHashMap<IVehicle,ConcurrentHashMap<String, String>> table) {
		this.table = table;
		return true;
	}
}
