package cityFrame;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JOptionPane;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JSlider;
import javax.swing.border.TitledBorder;

import DesignPatterns.*;
import vehicleMovingService.CityPanelMover;
import vehicles.*;

public class AddVehicleDialog extends JDialog {
	static final String TITLE = "Add a vehicle to the city";
	static final String CARRIAGE_LABEL = "Carriage";
	static final String BIKE_LABEL = "Bike";
	static final String CAR_BENZINE = "Car with benzine engine";
	static final String CAR_SOLAR = "Car with solar engine";
	static final String[] BUTTONS_LABELS = {CAR_BENZINE,CAR_SOLAR,BIKE_LABEL,CARRIAGE_LABEL,"Red","Green","Silver","White"};
	static final String FIRST_QUESTION = "Please choose a type of vehicle :";
	static final String SECOND_QUESTION = "Please choose a color for your vehicle :";
	static ButtonGroup qType,qColor;
	static JRadioButton[] buttons = new JRadioButton[8];
	JPanel qPanel = new JPanel(new BorderLayout());
	JPanel typePanel = new JPanel(new GridLayout(2,2));
	JPanel colorPanel = new JPanel(new GridLayout(2,2));
	JSlider gears = new JSlider(1, 10, 1);
	JPanel gearsPanel = new JPanel();
	JPanel bottomPanel = new JPanel();
	JButton ok = new JButton("OK");
	JButton cancel = new JButton("Cancel");
	public static CityPanel panel;
	
	public AddVehicleDialog(CityPanel panel) {
		setTitle(TITLE);
		setLayout(new BorderLayout());
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setRadioButtons();
		setSlider();
		setBottomPanel();
		setOKButton();
		this.add(qPanel);
		this.pack();
		AddVehicleDialog.panel = panel;
	}
	
	public void setRadioButtons() {
		for (int i = 0 ; i < 8 ; ++i) {
			buttons[i] = new JRadioButton(BUTTONS_LABELS[i]);
			buttons[i].setActionCommand(BUTTONS_LABELS[i]);
		}
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
		typePanel.setBorder(new TitledBorder("Choose type :"));
		colorPanel.setBorder(new TitledBorder("Choose color :"));
		JPanel top = new JPanel();
		top.add(typePanel,BorderLayout.WEST);
		top.add(colorPanel,BorderLayout.EAST);
		qPanel.add(top,BorderLayout.NORTH);
	}
	
	public void setSlider() {
		gearsPanel.setBorder(new TitledBorder("Choose number of gears"));
		gears.setMajorTickSpacing(1);
		gears.setPaintTicks(true);
		gears.setSnapToTicks(true);
		gears.setPaintLabels(true);
		gearsPanel.add(gears);
		qPanel.add(gearsPanel,BorderLayout.CENTER);
		gearsPanel.setVisible(true);
		gears.setVisible(true);
		gears.setEnabled(false);
		gearsPanel.setEnabled(false);
		setSliderHiding();
	}
	
	public void setBottomPanel() {
		cancel.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		bottomPanel.add(ok);
		bottomPanel.add(cancel);
		qPanel.add(bottomPanel,BorderLayout.SOUTH);
	}
	
	public void setSliderHiding() {
		buttons[2].addItemListener(new ItemListener() {
			
			@Override
			public void itemStateChanged(ItemEvent e) {
				if(((JRadioButton)e.getItem()).isSelected()==true) {
					gears.setEnabled(true);
					gearsPanel.setEnabled(true);
				}
				else {
					gears.setEnabled(false);
					gearsPanel.setEnabled(false);
				}		
			}
		});
	}
	
	public void setOKButton() {
		ok.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if (qType.getSelection() == null || qColor.getSelection() == null)
					JOptionPane.showMessageDialog(panel,"Error !\n" + "Please choose the type of the vehicle and the color","Error !",JOptionPane.ERROR_MESSAGE);
				else {
					String type = qType.getSelection().getActionCommand();
					String color = qColor.getSelection().getActionCommand();
					int numOfGears = gears.getValue();
					createVehicle(type,color,numOfGears);
					dispose();
				}
			}
		});
	}
	
	private static boolean createVehicle(String type,String color,int numberOfGears) {
		IVehicle v = null;
		try {
		if (type.equals(CAR_BENZINE)) 
			v = CarFactory.getCar("Benzine", color, new CityPanelMover(AddVehicleDialog.panel));
		else if (type.equals(CAR_SOLAR))
			v = CarFactory.getCar("Solar", color, new CityPanelMover(AddVehicleDialog.panel));
		else if (type.equals(BIKE_LABEL))
			v = BikeFactory.getBike(numberOfGears, color, new CityPanelMover(AddVehicleDialog.panel));
		else if (type.equals(CARRIAGE_LABEL))
			v = CarriageFactory.getCarriage(color, new CityPanelMover(AddVehicleDialog.panel));
		CityPanel.pool.addVehicle(v);
		}
		catch (Exception e) {
			JOptionPane.showMessageDialog(panel,"Error !\n" + e.getMessage(),"Error !",JOptionPane.ERROR_MESSAGE);
			return false;
		}
		CityPanel.numOfVehicles += 1;
		panel.repaint();
		return true;
	}
	
}
