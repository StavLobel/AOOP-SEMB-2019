package panelButtons;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;

import javax.swing.JButton;
import javax.swing.JOptionPane;

import designPatterns.IVehicle;
import designPatterns.Observer;
import graphics.CityFrame;
import graphics.CityPanel;

public class MementoButton extends JButton {
	
	private static final String TITLE = "Memento";
	
	private CityPanel panel;
	
	private CityMemento memento = null;
	
	public MementoButton(CityPanel panel) {
		super(TITLE);
		this.panel = panel;
		
		this.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String[] options = {"Save","Load"};
				int n = JOptionPane.showOptionDialog(CityFrame.frame,"Select Option : ","The question",JOptionPane.YES_NO_CANCEL_OPTION,JOptionPane.QUESTION_MESSAGE,null,options,options[1]);
				if (n == 0)
					saveMemento();
				else if (n ==1 )
					loadMemento();
			}
		});
	}
	
	private boolean saveMemento() {
		memento = new CityMemento();
		memento.addVehiclesToMemento(panel.pool.getAllVehicles());
		memento.addTableToMemento(panel.infoButton.getInfo());
		return true;
	}
	
	private boolean loadMemento() {
		if (memento == null)
			return false;
		panel.resetPanel();
		panel.infoButton.setTable(memento.getTable());
		LinkedList<IVehicle> vehicles = memento.getVehicles();
		for (int i = 0 ; i < vehicles.size() ; ++i) {
			try {
				panel.pool.addVehicle(vehicles.get(i));
				vehicles.get(i).getCore().addObserver(CityPanel.trafficManager);
				vehicles.get(i).getCore().addObserver((Observer) panel.fuelFoodButton);
				vehicles.get(i).getCore().addObserver(panel);
			}
			catch (Exception e) {}
		}
		memento.clearMemento();
		saveMemento();
		return true;
	}
}
