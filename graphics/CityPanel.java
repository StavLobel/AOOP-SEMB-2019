package graphics;
import java.awt.BorderLayout;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JPanel;

import cityPannelConcurrent.CityPanelThreadPool;
import cityPannelConcurrent.CityTrafficManager;
import designPatterns.Observable;
import designPatterns.Observer;
import panelButtons.*;
import vehicles.Vehicle;


/**
 * The Class CityPanel.
 * 
 * @author Stav Lobel
 */
public class CityPanel extends JPanel implements Observer{
	
	private static volatile CityPanel panel = null;
	
	private static final int MAX_RUNNING = 5;
	
	private static final int MAX_WAITING = 5;
	
	AddVehicleButton addVehicleButton = new AddVehicleButton(this);
	ClearButton clearButton = new ClearButton(this);
	public FuelButton fuelFoodButton = new FuelButton(this);
	public LightsButton lightsButton = new LightsButton(this);
	public InfoButton infoButton = new InfoButton(this);
	ExitButton exitButton = new ExitButton(this);
	MementoButton mementoButton = new MementoButton(this);
	
	/** The buttons. */
	JButton[] buttons = {addVehicleButton,clearButton,fuelFoodButton,lightsButton,infoButton,exitButton,new JButton("Add Border"),mementoButton};
	
	/** The bottom. */
	JPanel bottom = new JPanel();
	
	/** The background image. */
	static BufferedImage backgroundImage = null;
	
	public CityPanelThreadPool pool = new CityPanelThreadPool(MAX_RUNNING, MAX_WAITING,this);
	
	public static CityTrafficManager trafficManager = new CityTrafficManager();
	
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
		for (int i=0 ; i < buttons.length ; ++i)
			bottom.add(buttons[i]);
		
		setBackground();
		
		(new Thread(pool)).start();
		(new Thread(infoButton)).start();
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
	
	public boolean getNotified(Observable observable,String msg) {
		if (msg.equals(Vehicle.KILLED) || msg.equals(Vehicle.MOVED) || msg.equals(Vehicle.CREATED))
			this.repaint();
		return true;
	}
	
	/* (non-Javadoc)
	 * @see javax.swing.JComponent#paintComponent(java.awt.Graphics)
	 */
	protected void paintComponent(Graphics g)
	{
	    super.paintComponent(g);
	    g.drawImage(backgroundImage,0, 0, getWidth(), getHeight(), this);
	    synchronized (pool) {
	    	pool.paintVehicles(g);	
		}
	}
	
	public boolean resetPanel() {
		this.pool.ClearPool();
		this.infoButton = new InfoButton(this);
		
		(new Thread(pool)).start();
		(new Thread(infoButton)).start();
		
		return true;
	}
}
