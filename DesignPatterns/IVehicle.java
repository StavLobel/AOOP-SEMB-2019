package DesignPatterns;

import java.awt.Graphics;

import vehicles.Location;

/**
 * The Interface IVehicle.
 * 
 * @author Stav Lobel
 */
public interface IVehicle extends Runnable{
	
	public void run();
	
	public void kill();
	
	public boolean getFlag();
	
	public Location getLocation();
}
