package graphics;
import java.awt.BorderLayout;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import vehicles.*;


/**
 * The Class CityPanel.
 * 
 * @author Stav Lobel
 */
public class CityPanel extends JPanel {
	
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
	
	/** The v. */
	static Vehicle v;
	
	static Thread vThread;
	
	/** The info. */
	static JTable info;
	
	/** The info dialog. */
	static JDialog infoDialog = new JDialog();
	
	/** The num of vehicles. */
	static int numOfVehicles = 0;
	
	/** The table. */
	static Object[][] table = new Object[0][10];
	
	/** The Constant columnNames. */
	static final String[] columnNames = {"Vehicle","ID","Color","Wheels","Speed","FuelAmount","Distance","Fuel consuption","Lights","Hitting Vehicle"};
	
	/** The info scroll pane. */
	static JScrollPane infoScrollPane;
	
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
				if (v != null)
					saveLastVehicleInTable();
				v.killVehicle();
				v = null;
				repaint();
			}
		});
		
		buttons[3].addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				if(v == null)
					JOptionPane.showMessageDialog(CityFrame.frame,"Error !\n"+"No vehicle to change it's lights.","Error !",JOptionPane.ERROR_MESSAGE);
				else
					v.setLights(!v.isLights());
			}
		});
		buildTable();
		buttons[4].addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				if (v != null)
					tableRefresh();
				infoDialog.pack();
				infoDialog.setLocationRelativeTo(null);
				infoDialog.setVisible(true);
			}
		});
		
		buttons[5].addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
	}
	
	/* (non-Javadoc)
	 * @see javax.swing.JComponent#paintComponent(java.awt.Graphics)
	 */
	protected void paintComponent(Graphics g)
	{
	    super.paintComponent(g);
	    g.drawImage(backgroundImage,0, 0, getWidth(), getHeight(), this);
	    if (v != null){ //if the vehicle object exists
	        	v.drawObject(g);
	    }
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
					fuel(n);
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
	
	/**
	 * Builds the table.
	 *
	 * @return true, if successful
	 */
	private static boolean buildTable() {
		info = new JTable(table,columnNames);
		infoDialog.setTitle("Vehicle List");
		infoScrollPane = new JScrollPane(info);
		infoDialog.add(infoScrollPane);
		return true;
	}
	
	
	/**
	 * Adds the row to table.
	 *
	 * @return true, if successful
	 */
	public static boolean addRowToTable() {
		Object[][] tempTable = new Object[numOfVehicles][10];
		for (int i = 0 ; i < numOfVehicles-1 ; ++i) {
			tempTable[i] = new Object[10];
			for(int j = 0 ; j < 10 ; ++j)
				tempTable[i][j] = table[i][j];
		}
		table = tempTable;
		table[numOfVehicles-1] = new Object[10];
		for (int i = 0 ; i < 10 ; ++i)
			table[numOfVehicles-1][i] = v.getTable()[i];
		return true;
	}
	
	/**
	 * Save last vehicle in table.
	 *
	 * @return true, if successful
	 */
	private boolean saveLastVehicleInTable() {
		table[numOfVehicles-1] = v.getTable();
		for (int i = 0 ; i < table[numOfVehicles-1].length; ++i) {
			String temp = ""+table[numOfVehicles-1][i];
			table[numOfVehicles-1][i] = temp;
			}
		return true;
	}
	
	/**
	 * Table refresh.
	 *
	 * @return true, if successful
	 */
	private boolean tableRefresh() {
		infoDialog.remove(infoScrollPane);	
		for(int i = 0 ; i < table[numOfVehicles-1].length ; ++i)
			table[numOfVehicles-1][i] = v.getTable()[i];
		info = new JTable(table,columnNames);
		infoScrollPane = new JScrollPane(info);
		infoDialog.add(infoScrollPane);
		return true;
	}
}
