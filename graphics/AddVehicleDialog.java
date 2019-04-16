package graphics;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JSlider;
import javax.swing.border.TitledBorder;

public class AddVehicleDialog extends JDialog {
	static final String TITLE = "Add a vehicle to the city";
	static final String CARRIAGE_LABEL = "Carriage";
	static final String BIKE_LABEL = "Bike";
	static final String CAR_BENZINE = "Car with benzine engine";
	static final String CAR_SOLAR = "Car with solar engine";
	static final String[] BUTTONS_LABELS = {CARRIAGE_LABEL,BIKE_LABEL,CAR_BENZINE,CAR_SOLAR,"Red","Green","Silver","White"};
	static final String FIRST_QUESTION = "Please choose a type of vehicle :";
	static final String SECOND_QUESTION = "Please choose a color for your vehicle :";
	static ButtonGroup qType,qColor;
	static JRadioButton[] buttons = new JRadioButton[8];
	JPanel qPanel = new JPanel(new BorderLayout());
	JPanel typePanel = new JPanel(new GridLayout(2,2));
	JPanel colorPanel = new JPanel(new GridLayout(2,2));
	JSlider gears = new JSlider(1, 10, 1);
	JPanel gearsPanel = new JPanel();
	
	public AddVehicleDialog() {
		setTitle(TITLE);
		setLayout(new BorderLayout());
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setRadioButtons();
		setSlider();
		this.add(qPanel);
		this.pack();
		
	}
	
	public void setRadioButtons() {
		for (int i = 0 ; i < 8 ; ++i)
			buttons[i] = new JRadioButton(BUTTONS_LABELS[i]);
		qType = new ButtonGroup();
		qColor = new ButtonGroup();
		for (int i = 0 ; i < 4 ; ++i) {
			qType.add(buttons[i]);
			typePanel.add(buttons[i]);
		}
		for (int i = 4 ; i < 8 ; ++i) {
			qColor.add(buttons[i]);
			colorPanel.add(buttons[i]);
		}
		buttons[1].addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				gearsPanel.setEnabled(true);	
			}
		});
		typePanel.setBorder(new TitledBorder("Choose type :"));
		colorPanel.setBorder(new TitledBorder("Choose color :"));
		qPanel.add(typePanel,BorderLayout.WEST);
		qPanel.add(colorPanel,BorderLayout.EAST);
	}
	
	public void setSlider() {
		gearsPanel.setBorder(new TitledBorder("Choose number of gears"));
		gears.setMajorTickSpacing(1);
		gears.setPaintTicks(true);
		gears.setSnapToTicks(true);
		gears.setPaintLabels(true);
		gearsPanel.add(gears);
		qPanel.add(gearsPanel,BorderLayout.SOUTH);
		gearsPanel.setVisible(true);
		gears.setVisible(true);
		gearsPanel.setEnabled(false);
	}
	
}
