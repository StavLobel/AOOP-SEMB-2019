package panelButtons;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import graphics.AddVehicleDialog;
import graphics.CityPanel;

public class AddVehicleButton extends JButton {
	
	private static final String ADD_VEHICLE_LABEL = "Add Vehicle";
	
	/** The dialog. */
	AddVehicleDialog dialog;
	
	private CityPanel panel; 
	
	public AddVehicleButton(CityPanel panel) {
		super(ADD_VEHICLE_LABEL);
		this.panel = panel;
		dialog = new AddVehicleDialog(panel);
		this.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				dialog.setVisible(true);
				dialog.setLocationRelativeTo(null);
			}
		});
	}
	
}
