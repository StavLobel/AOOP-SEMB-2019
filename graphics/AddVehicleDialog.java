package graphics;
import java.awt.BorderLayout;
import javax.swing.JOptionPane;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class AddVehicleDialog extends JDialog {
	static final String CARRIAGE_LABEL = "Carriage";
	static final String BIKE_LABEL = "Bike";
	static final String CAR_BENZINE = "Car with benzine engine";
	static final String CAR_SOLAR = "Car with solar engine";
	static final Object[] TYPE_OPTIONS = {CARRIAGE_LABEL,BIKE_LABEL,CAR_BENZINE,CAR_SOLAR};
	static final Object[] COLOR_OPTIONS = {"Red","Green","Silver","White"};
	static final String FIRST_QUESTION = "Please choose a type of vehicle :";
	static final String SECOND_QUESTION = "Please choose a color for your vehicle :";
	
	public AddVehicleDialog(JFrame frame) {
		super(frame);
	}
}
