package graphics;

import java.awt.Color;
import javax.swing.JButton;
import cityTraffic.Observable;
import cityTraffic.Observer;

public class FuelButton extends JButton implements Observer {
	
	private int needsFueling = 0;
	
	public FuelButton(String title) {
		super(title);
	}
	
	@Override
	public boolean getNotified(Observable observable, String msg) {
		if (msg.equals("RunOutOfFuel")) {
			needsFueling++;
			paintButtonRed();
		}
		else if (msg.equals("Fueled")) {
			needsFueling--;
			backToStart();
		}
		else if (msg.equals("Killed")) {
			needsFueling--;
			backToStart();
			}
		return true;
	}
	
	public void paintButtonRed() {
		this.setBackground(Color.RED);
		this.setForeground(Color.WHITE);
		this.repaint();
	}
	
	public void rePaintButton() {
		this.setBackground((new JButton()).getBackground());
		this.setForeground((new JButton()).getForeground());
		this.repaint();
	}
	
	public boolean backToStart() {
		if (needsFueling == 0) {
			rePaintButton();
			return true;
		}
		return false;
	}
}
