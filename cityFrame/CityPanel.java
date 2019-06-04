package cityFrame;
import java.awt.BorderLayout;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.LinkedList;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import cityPannelConcurrent.CityPanelThreadPool;
import refuelers.FuelTypeException;
import vehicleGraphicsDecorator.VehicleGraphicDecorator;


/**
 * The Class CityPanel.
 * 
 * @author Stav Lobel
 */
public class CityPanel extends JPanel {
	
	private static volatile CityPanel panel = null;
	
	private static final int MAX_RUNNING = 5;
	
	private static final int MAX_WAITING = 5;
	
	/** The Constant ADD_VEHICLE_LABEL. */
	private static final String ADD_VEHICLE_LABEL = "Add Vehicle";
	
	/** The Constant CLEAR_LABEL. */
	private static final String CLEAR_LABEL = "Clear";
	
	/** The Constant FUEL_OR_FOOD_LABEL. */
	private static final String FUEL_OR_FOOD_LABEL = "Fuel/Food";
	
	/** The Constant LIGHTS_LABEL. */
	private static final String LIGHTS_LABEL = "Lights";
	
	/** The Constant INFO_LABEL. */
	private static final String INFO_LABEL = "Info";
	
	/** The Constant EXIT_LABEL. */
	private static final String EXIT_LABEL = "Exit";
	
	/** The Constant BOTTTOM_PANEL_LABELS. */
	private static final String[] BOTTTOM_PANEL_LABELS = {ADD_VEHICLE_LABEL,CLEAR_LABEL,FUEL_OR_FOOD_LABEL,LIGHTS_LABEL,INFO_LABEL,EXIT_LABEL};
	
	/** The buttons. */
	private static JButton[] buttons;
	
	/** The bottom. */
	JPanel bottom = new JPanel();
	
	/** The background image. */
	static BufferedImage backgroundImage = null;
	
	/** The dialog. */
	AddVehicleDialog dialog = new AddVehicleDialog(this);
	
	/** The num of vehicles. */
	static int numOfVehicles = 0;
	
	static CityPanelThreadPool pool = new CityPanelThreadPool(MAX_RUNNING, MAX_WAITING);
	
	//CityPanelInfoMenu infoMenu;
	
	/**
	 * Sets the background.
	 *
	 * @return true, if successful
	 */
	public static boolean setBackground() {
        try {
        	backgroundImage = ImageIO.read(new File("PNGs/cityBackground.png"));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return true;
	}
	
	
	/**
	 * Instantiates a new city panel.
	 */
	private CityPanel(){
		super(new BorderLayout());
		this.setSize(800, 600);
		this.add(bottom,BorderLayout.SOUTH);
		buttons = new JButton[BOTTTOM_PANEL_LABELS.length];
		for (int i=0 ; i < buttons.length ; ++i ) {
			buttons[i] = new JButton(BOTTTOM_PANEL_LABELS[i]);
			bottom.add(buttons[i]);
		}
		//infoMenu = new CityPanelInfoMenu(this);
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
				pool.killAllActiveVehicles();
				repaint();
			}
		});
		
		buttons[3].addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				//LIGHTS
			}
		});
		buttons[4].addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				//INFOTABLE
			}
		});
		
		buttons[5].addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				pool.shutdown();
				System.exit(0);
			}
		});
	}
	
	/**
	 * Gets city panel instance.
	 *
	 * @return the panel
	 */
	public static CityPanel getPanel() {
		if (panel == null)
			synchronized (CityPanel.class) {
				if (panel == null)
					panel = new CityPanel();
			}
		return panel;
	}
	
	/* (non-Javadoc)
	 * @see javax.swing.JComponent#paintComponent(java.awt.Graphics)
	 */
	protected void paintComponent(Graphics g)
	{
	    super.paintComponent(g);
	    g.drawImage(backgroundImage,0, 0, getWidth(), getHeight(), this);
	    pool.paintVehicles(g);
	}
	
	/**
	 * Sets the refuel button.
	 *
	 * @return true, if successful
	 */
	private static boolean setRefuelButton() {
		buttons[2].addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				String[] options = {"Benzine","Solar","Food"};
				int n = JOptionPane.showOptionDialog(CityFrame.frame,"Please choose type of refueling","The question",JOptionPane.YES_NO_CANCEL_OPTION,JOptionPane.QUESTION_MESSAGE,null,options,options[2]);
				try{
					fuel(options[n]);
				}
				catch (FuelTypeException error) {
					JOptionPane.showMessageDialog(CityFrame.frame, error.toString(),"Error !",JOptionPane.ERROR_MESSAGE);
				}
				catch (Exception error) {
					JOptionPane.showMessageDialog(CityFrame.frame, error.toString(),"Error !",JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		return true;
	}
	
	/**
	 * Fuel.
	 *
	 * @param n the fueling choice
	 * @return true, if successful
	 * @throws Exception the exception
	 */
	private static boolean fuel(String type) throws Exception {
		//FUEL THE VEHICLE
		return true;
	}
}
