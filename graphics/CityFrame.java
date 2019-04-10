package graphics;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;


public class CityFrame extends JFrame{
	public static CityFrame frame;
	public static final String TITLE = "City";
	public static final String FILE_TITLE = "File";
	public static final String HELP_TITLE = "Help";
	public static final String ADD_VEHICLE_LABEL = "Add Vehicle";
	public static final String CLEAR_LABEL = "Clear";
	public static final String FUEL_OR_FOOD_LABEL = "Fuel/Food";
	public static final String LIGHTS_LABEL = "Lights";
	public static final String INFO_LABEL = "Info";
	public static final String EXIT_LABEL = "Exit";
	public static final String[] BOTTTOM_PANEL_LABELS = {ADD_VEHICLE_LABEL,CLEAR_LABEL,FUEL_OR_FOOD_LABEL,LIGHTS_LABEL,INFO_LABEL,EXIT_LABEL};
	public static BufferedImage backGround = null;
	
	public boolean setBackground() {
        try {
            backGround = ImageIO.read(new File("PNGs//cityBackground.png"));
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        Image dimg = backGround.getScaledInstance(this.getWidth(),this.getHeight(),Image.SCALE_SMOOTH);
        JLabel backgroundLabel = new JLabel(new ImageIcon(dimg));
        this.add(backgroundLabel);
        backgroundLabel.setLayout(new FlowLayout());
        return true;
	}
	
	public CityFrame(String title) {
		setTitle(TITLE);
		setSize(400,400);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
        setLayout(new BorderLayout());
	}
	
	public static JMenuBar createMenu() {
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
		
		return menuBar;
	}
	
	public Boolean createBottomPanel(){
		JPanel bottomPanel = new JPanel();
		JButton[] buttons = new JButton[BOTTTOM_PANEL_LABELS.length];
		for (int i=0 ; i < buttons.length ; ++i ) {
			buttons[i] = new JButton(BOTTTOM_PANEL_LABELS[i]);
			bottomPanel.add(buttons[i]);
		}
		this.add(bottomPanel,BorderLayout.SOUTH);
		return true;
	}
	
	public static void main(String[] args) {
		frame = new CityFrame(TITLE);
		frame.setJMenuBar(createMenu());
		frame.setBackground();
		frame.createBottomPanel();
		frame.pack();  
	}
}
