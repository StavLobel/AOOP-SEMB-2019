package graphics;

import javax.swing.*;
import java.awt.event.*;


/**
 * The Class CityFrame.
 * 
 * @author Stav Lobel, ID 308549898 , Campus Ashdod
 */
public class CityFrame extends JFrame{
	
	/** The frame. */
	public static CityFrame frame;
	
	/** The Constant TITLE. */
	public static final String TITLE = "City";
	
	/** The Constant FILE_TITLE. */
	public static final String FILE_TITLE = "File";
	
	/** The Constant HELP_TITLE. */
	public static final String HELP_TITLE = "Help";
	
	/** The Constant EXIT_LABEL. */
	public static final String EXIT_LABEL = "Exit";
	
	/** The panel. */
	public CityPanel panel = new CityPanel();
	
	
	/**
	 * Instantiates a new city frame.
	 *
	 * @param title the title
	 */
	public CityFrame(String title) {
		super(TITLE);
		setSize(800,600);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);	
		this.add(panel);
	}
	
	/**
	 * Creates the menu.
	 *
	 * @return true, if successful
	 */
	public static boolean createMenu() {
		JMenuBar menuBar;
		JMenu menu;
		JMenuItem menuItem;
		
		menuBar = new JMenuBar();
		
		menu = new JMenu(FILE_TITLE);
		menuBar.add(menu);
		
		menuItem = new JMenuItem(new AbstractAction(EXIT_LABEL){
		    public void actionPerformed(ActionEvent e) {
		        System.exit(0);
		    }
		});
		menu.add(menuItem);
		
		menu = new JMenu(HELP_TITLE);
		menuBar.add(menu);
		
		menuItem = new JMenuItem(new AbstractAction(HELP_TITLE){
		    public void actionPerformed(ActionEvent e) {
		    	JOptionPane.showMessageDialog(frame,"Home Work 2\n" + "GUI");
		    }
		});
		menu.add(menuItem);
		
		frame.setJMenuBar(menuBar);
		return true;
	}
	
	/**
	 * The main method.
	 *
	 * @param args the arguments
	 */
	public static void main(String[] args) {
		frame = new CityFrame(TITLE);
		createMenu();
	}
}
