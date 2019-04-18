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
import javax.swing.JPanel;

import vehicles.*;

public class CityPanel extends JPanel {
	private static final int VEHICLE_ARRAY_SIZE = 1;
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
	static Vehicle[] v = new Vehicle[VEHICLE_ARRAY_SIZE];
	static int numOfVehicles = 0;
	}
	
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
		Vehicle.setPanel(this);
		this.setSize(800, 600);
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
		
	}
	
	protected void paintComponent(Graphics g)
	{
	    super.paintComponent(g);
	    g.drawImage(backgroundImage,0, 0, getWidth(), getHeight(), this);
	    if (numOfVehicles > 0){ //if the vehicle object exists
	        for (int i = 0 ; i < numOfVehicles ; ++i) {
	        	v[i].drawObject(g);
	        	v[i].move(v[i].nextLocation());
	        }
	    }
	}
}
