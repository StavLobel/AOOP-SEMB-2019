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
	private static final String EXIT_LABEL = "Exit";
	static BufferedImage backGround = null;
	
	public static boolean setBackground() {
        try {
            backGround = ImageIO.read(new File("PNGs//cityBackground.png"));
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        Image dimg = backGround.getScaledInstance(frame.getWidth(),frame.getHeight(),Image.SCALE_SMOOTH);
        JLabel backgroundLabel = new JLabel(new ImageIcon(dimg));
        frame.add(backgroundLabel);
        backgroundLabel.setLayout(new FlowLayout());
        return true;
	}
	
	public CityFrame(String title) {
		setTitle(TITLE);
		setSize(800,600);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
        setLayout(new BorderLayout());
	}
	
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
	
	public static void main(String[] args) {
		frame = new CityFrame(TITLE);
		createMenu();
		setBackground();
		CityPanel bottomPanel = new CityPanel();
		frame.add(bottomPanel,BorderLayout.SOUTH);
		frame.pack();  
	}
}
