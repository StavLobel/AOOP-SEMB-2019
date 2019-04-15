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
	Vehicle v = new Bike("Red",10);
	
	public static boolean setBackground() {
        try {
        	backgroundImage = ImageIO.read(new File("PNGs//cityBackground.png"));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return true;
	}
	
	
	public CityPanel(){
		super(new BorderLayout());
		this.add(bottom,BorderLayout.SOUTH);
		buttons = new JButton[BOTTTOM_PANEL_LABELS.length];
		for (int i=0 ; i < buttons.length ; ++i ) {
			buttons[i] = new JButton(BOTTTOM_PANEL_LABELS[i]);
			bottom.add(buttons[i]);
		}
		setBackground();
	}
	
	protected void paintComponent(Graphics g)
	{
	    super.paintComponent(g);
	    g.drawImage(backgroundImage,0, 0, getWidth(), getHeight(), this);
	    if (v!=null){ //if the vehicle object exists
	        v.drawObject(g);
	        v.move(v.nextLocation());
	    }
	}

}
