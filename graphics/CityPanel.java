package graphics;
import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JPanel;

public class CityPanel extends JPanel {
	private static final String ADD_VEHICLE_LABEL = "Add Vehicle";
	private static final String CLEAR_LABEL = "Clear";
	private static final String FUEL_OR_FOOD_LABEL = "Fuel/Food";
	private static final String LIGHTS_LABEL = "Lights";
	private static final String INFO_LABEL = "Info";
	private static final String EXIT_LABEL = "Exit";
	private static final String[] BOTTTOM_PANEL_LABELS = {ADD_VEHICLE_LABEL,CLEAR_LABEL,FUEL_OR_FOOD_LABEL,LIGHTS_LABEL,INFO_LABEL,EXIT_LABEL};
	private static JButton[] buttons;
	
	public CityPanel(){
		super();
		buttons = new JButton[BOTTTOM_PANEL_LABELS.length];
		for (int i=0 ; i < buttons.length ; ++i ) {
			buttons[i] = new JButton(BOTTTOM_PANEL_LABELS[i]);
			this.add(buttons[i]);
		}
	}
}
