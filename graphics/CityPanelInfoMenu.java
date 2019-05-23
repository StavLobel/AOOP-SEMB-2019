package graphics;

import javax.swing.JDialog;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class CityPanelInfoMenu extends JDialog{

	/** The info. */
	static JTable info;
	
	/** The table. */
	static Object[][] table = new Object[0][9];
	
	/** The info scroll pane. */
	static JScrollPane infoScrollPane;
	
	/** The Constant columnNames. */
	static final String[] columnNames = {"Vehicle","ID","Color","Wheels","Speed","FuelAmount","Distance","Fuel consuption","Lights"};
	
	CityPanel panel;
	
	/**
	 * Builds the table.
	 *
	 * @return true, if successful
	 */
	public CityPanelInfoMenu(CityPanel panel) {
		info = new JTable(table,columnNames);
		infoDialog.setTitle("Vehicle List");
		infoScrollPane = new JScrollPane(info);
		infoDialog.add(infoScrollPane);
		this.panel = panel;
	}
	
	/**
	 * Adds the row to table.
	 *
	 * @return true, if successful
	 */
	public static boolean addRowToTable() {
		Object[][] tempTable = new Object[numOfVehicles][9];
		for (int i = 0 ; i < numOfVehicles-1 ; ++i) {
			tempTable[i] = new Object[9];
			for(int j = 0 ; j < 9 ; ++j)
				tempTable[i][j] = table[i][j];
		}
		table = tempTable;
		table[numOfVehicles-1] = new Object[9];
		for (int i = 0 ; i < 9 ; ++i)
			table[numOfVehicles-1][i] = v.getTable()[i];
		return true;
	}
	
	/**
	 * Save last vehicle in table.
	 *
	 * @return true, if successful
	 */
	public boolean saveLastVehicleInTable() {
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
	public boolean tableRefresh() {
		infoDialog.remove(infoScrollPane);	
		for(int i = 0 ; i < table[numOfVehicles-1].length ; ++i)
			table[numOfVehicles-1][i] = v.getTable()[i];
		info = new JTable(table,columnNames);
		infoScrollPane = new JScrollPane(info);
		infoDialog.add(infoScrollPane);
		return true;
	}
	
}
