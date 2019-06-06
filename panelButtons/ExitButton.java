package panelButtons;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import designPatterns.Observable;
import designPatterns.Observer;
import graphics.CityPanel;

public class ExitButton extends JButton implements Observable{
	
	/** The Constant EXIT_LABEL. */
	private static final String EXIT_LABEL = "Exit";
	
	private CityPanel panel;
	
	private Observer pool;
	
	public ExitButton(CityPanel panel) {
		super(EXIT_LABEL);
		this.panel = panel;
		this.addObserver(panel.pool);
		
		this.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				panel.infoButton.kill();
				notifyObservers("Exit");
				System.exit(0);
			}
		});
	}
	
	public boolean notifyObservers(String msg) {
		pool.getNotified(this, msg);
		return true;
	}
	
	public boolean addObserver(Observer observer) {
		pool = observer;
		return true;
	}
	
	public boolean removeObserver(Observer observer) {
		pool = null;
		return true;
	}
}