package panelButtons;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JOptionPane;

import designPatterns.IVehicle;
import designPatterns.Observable;
import designPatterns.Observer;
import graphics.CityFrame;
import graphics.CityPanel;
import refuelers.BenzineRefueler;
import refuelers.FuelTypeException;
import refuelers.PackAnimalRefueler;
import refuelers.Refueler;
import refuelers.SolarRefueler;
import vehicles.IUsingFuel;

public class FuelButton extends JButton implements Observer {
	
	/** The Constant FUEL_OR_FOOD_LABEL. */
	private static final String FUEL_OR_FOOD_LABEL = "Fuel/Food";
	
	private CityPanel panel;
	
	private int needsFueling = 0;
	
	public FuelButton(CityPanel panel) {
		super(FUEL_OR_FOOD_LABEL);
		this.panel = panel;
		this.addActionListener(new ActionListener() {
			
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
	
	private boolean fuel(String type) throws Exception {
		String msg = "\n";
		Refueler refueler;
		if (type.equals("Benzine"))
			refueler = new BenzineRefueler();
		else if (type.equals("Solar"))
			refueler = new SolarRefueler();
		else
			refueler = new PackAnimalRefueler();
		IVehicle[] toRefuel = panel.pool.GetPool();
		for (int i = 0 ; i < toRefuel.length ; ++i) {
			synchronized (toRefuel[i]) {
				if (!(toRefuel[i].getCore() instanceof IUsingFuel))
					msg = msg + "The Vehicle : " + toRefuel[i].getCore().getLicensePlate() + " don't using fuel .\n";
				else {
					try {
						((IUsingFuel) toRefuel[i].getCore()).letRefuel(refueler);
					}
					catch (Exception e) {
						msg = msg + e.getMessage()+"\n";
					}
				}
			}
		}
		if (msg.equals("\n") == false) 
			throw new Exception(msg);
		return true;
	}
}
