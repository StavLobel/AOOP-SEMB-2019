package graphics;

import java.util.LinkedList;

import javax.sql.PooledConnection;
import javax.swing.JDialog;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import vehicles.Vehicle;

public class CityInfoTable extends JDialog implements Runnable {
	
	/** The table. */
	Object[][] fixedTable = new Object[0][10];
	
	Object[][] liveTable;
	
	/** The Constant columnNames. */
	static final String[] columnNames = {"Vehicle","ID","Color","Wheels","Speed","FuelAmount","Distance","Fuel consuption","Lights","Hitting Vehicle"};
	
	/** The info. */
	static JTable info;
	
	/** The info scroll pane. */
	static JScrollPane infoScrollPane;
	
	static boolean flag = true;
	
	public CityInfoTable() {
		setTitle("Vehicle List");
	}
	
	@Override
	public void run() {
		while (flag) {
			liveTable = new Object[CityPanel.pool.getNumberOfActiveVehicles()][10];
			LinkedList<Vehicle> toUpdate = CityPanel.pool.getActiveVehicles();
			for (int i = 0 ; i < toUpdate.size() ; ++i) {
				Object[] temp = toUpdate.get(i).getTable();
				for (int j = 0 ; j < temp.length ; ++j)
					liveTable[i][j] = "" + temp[j];
			}
			Object[][] table = mergeTables();
			info = new JTable(table,columnNames);
			infoScrollPane = new JScrollPane(info);
			this.repaint();
		}
	}
	
	public boolean shutdown() {
		flag = false;
		return true;
	}
	
	public Object[][] mergeTables() {
		Object[][] merged = new Object[CityPanel.numberOfCreatedVehicles][10];
		for (int i = 0 ; i < fixedTable.length ; ++i)
			for (int j = 0 ; j < fixedTable[i].length ; ++j)
				merged[i][j] = fixedTable[i][j];
		for (int i = 0 ; i < liveTable.length ; ++i)
			for (int j = 0 ; j < liveTable[i].length ; ++j)
				merged[i][j] = liveTable[i][j];
		return merged;
	}

}
