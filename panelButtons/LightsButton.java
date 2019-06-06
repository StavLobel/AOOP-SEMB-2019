package panelButtons;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;

import javax.swing.JButton;

import designPatterns.IVehicle;
import designPatterns.LightsDecorator;
import designPatterns.Observable;
import designPatterns.Observer;
import designPatterns.VehicleDecorator;
import graphics.CityPanel;

public class LightsButton extends JButton implements Observable{
	/** The Constant LIGHTS_LABEL. */
	private static final String LIGHTS_LABEL = "Lights";
	
	public static final String LIGHTS_CHANGED = "Lights have changed";
	
	private LinkedList<Observer> observers = new LinkedList<Observer>();
	
	private CityPanel panel;
	
	public LightsButton(CityPanel panel) {
		super(LIGHTS_LABEL);
		this.panel = panel;
		this.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				IVehicle[] vehicles = panel.pool.GetPool();
				for (int i = 0 ; i < vehicles.length ; ++i) {
					VehicleDecorator v = (VehicleDecorator) vehicles[i];
					while (v.equals(v.getCore()) == false) {
						if (v instanceof LightsDecorator) {
							((LightsDecorator) v).switchLights();
							break;
							}
						v = (VehicleDecorator) v.getLowerLayer();
					}
				}
				notifyObservers(LIGHTS_CHANGED);
			}
		});
	}
	
	public synchronized boolean addObserver(Observer observer) {
		return observers.add(observer);
	}
	
	public synchronized boolean removeObserver(Observer observer) {
		return observers.remove(observer);
	}
	
	public boolean notifyObservers(String msg) {
		observers.forEach(n -> n.getNotified(this,msg));
		return true;
	}
}
