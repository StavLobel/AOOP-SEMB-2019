package graphics;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.Shape;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;
import java.io.File;
import java.text.AttributedCharacterIterator;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;

import vehicles.*;

public class CityPanel extends JPanel {
	private static final String ADD_VEHICLE_LABEL = "Add Vehicle";
	private static final String CLEAR_LABEL = "Clear";
	private static final String FUEL_OR_FOOD_LABEL = "Fuel/Food";
	private static final String LIGHTS_LABEL = "Lights";
	private static final String INFO_LABEL = "Info";
	private static final String EXIT_LABEL = "Exit";
	private static final String[] BOTTTOM_PANEL_LABELS = {ADD_VEHICLE_LABEL,CLEAR_LABEL,FUEL_OR_FOOD_LABEL,LIGHTS_LABEL,INFO_LABEL,EXIT_LABEL};
	private static JButton[] buttons;
	JPanel bottom = new JPanel();
	static BufferedImage backgroundImage = null;
	AddVehicleDialog dialog = new AddVehicleDialog(this);
	static Vehicle v;
	static JTable info;
	
	
	public static boolean setBackground() {
        try {
        	backgroundImage = ImageIO.read(new File("PNGs/cityBackground.png"));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return true;
	}
	
	
	public CityPanel(){
		super(new BorderLayout());
		this.setSize(800, 600);
		Vehicle.setPanel(this);
		this.add(bottom,BorderLayout.SOUTH);
		buttons = new JButton[BOTTTOM_PANEL_LABELS.length];
		for (int i=0 ; i < buttons.length ; ++i ) {
			buttons[i] = new JButton(BOTTTOM_PANEL_LABELS[i]);
			bottom.add(buttons[i]);
		}
		setBackground();
		buttons[0].addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				dialog.setVisible(true);
				dialog.setLocationRelativeTo(null);
			}
		});
		
		setRefuelButton();
		
		buttons[1].addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				v = null;
				repaint();
			}
		});
		
		buttons[3].addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
					v.setLights(!v.isLights());
			}
		});
		
		buttons[5].addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		
		buildTable();
	}
	
	protected void paintComponent(Graphics g)
	{
	    super.paintComponent(g);
	    g.drawImage(backgroundImage,0, 0, getWidth(), getHeight(), this);
	    if (v != null){ //if the vehicle object exists
	        	v.drawObject(g);
	        	v.move(v.nextLocation());
	    }
	}
	
	private static boolean setRefuelButton() {
		buttons[2].addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				String[] options = {"Benzine","Solar","Food"};
				int n = JOptionPane.showOptionDialog(CityFrame.frame,"Please choose type of refueling","The question",JOptionPane.YES_NO_CANCEL_OPTION,JOptionPane.QUESTION_MESSAGE,null,options,options[2]);
				try{
					fuel(n);
				}
				catch (FuelTypeException error) {
					JOptionPane.showMessageDialog(CityFrame.frame, error);
				}
				catch (Exception error) {
					JOptionPane.showMessageDialog(CityFrame.frame, error);
				}
			}
		});
		return true;
	}
	
	private static boolean fuel(int n) throws Exception {
		String[] engineTypes = {"Benzine Engine","Solar Engine","Pack Animal"};
		if (v == null)
			throw new Exception("No vehicle to refuel.");
		if (v.getEngineType() == null)
			throw new Exception("Cannot refuel this vehicle.");
		else if (!v.getEngineType().equals(engineTypes[n]))
			throw new FuelTypeException(v.getEngineType(),engineTypes[n]);
		v.refuel();
		v.move(v.nextLocation());
		return true;
	}
	
	private static boolean buildTable() {
		
		return true;
	}
}
