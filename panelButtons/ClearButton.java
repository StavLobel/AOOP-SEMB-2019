package panelButtons;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import graphics.CityPanel;

public class ClearButton extends JButton {

	/** The Constant CLEAR_LABEL. */
	private static final String CLEAR_LABEL = "Clear";
	
	private CityPanel panel;
	
	public ClearButton(CityPanel panel) {
		super(CLEAR_LABEL);
		this.panel = panel;
		this.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				panel.pool.ClearActivePool();
				panel.repaint();
			}
		});
	}
	
}
