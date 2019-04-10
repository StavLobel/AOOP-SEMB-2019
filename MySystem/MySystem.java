package MySystem;
import java.util.Scanner;
import java.util.Arrays;

import vehicles.*;

/**
 * The Class MySystem.
 * 
 * @author Stav Lobel ID 308549898
 */
public class MySystem {
	
	/** The input method. */
	public static Scanner input = new Scanner(System.in);
	
	/**
	 * Drive.
	 *
	 * @param vehicleArray the vehicle array
	 * @param borders the borders
	 * @param licensePlate the license plate of the vehicle you want to drive
	 * @param toGo the new point to drive to
	 * @return true, if successful
	 */
	public static boolean drive(Vehicle[] vehicleArray,int[] borders,int licensePlate,Point toGo) {
		for (int i = 0 ; i < vehicleArray.length ; ++i)
			if (vehicleArray[i].getLicensePlate() == licensePlate)
				if (toGo.getX() >= borders[0] && toGo.getX() <= borders[1])
					if (toGo.getY() <= borders[2] && toGo.getY() >= borders[3])
						return vehicleArray[i].drive(toGo);
		return false;
	}
	
	/**
	 * Inits the borders.
	 *
	 * @param borders the borders array
	 * @return true, if successful
	 */
	public static boolean initBorders(int[] borders) {
		System.out.println("Please Enter X left limit :");
		borders[0] = input.nextInt();
		System.out.println("Please Enter X right limit :");
		borders[1] = input.nextInt();
		System.out.println("Please Enter Y max limit :");
		borders[2] = input.nextInt();
		System.out.println("Please Enter Y min limit :");
		borders[3] = input.nextInt();
		return true;
	}
	
	/**
	 * Inits the vehicles array.
	 *
	 * @return new vehicles array
	 */
	public static Vehicle[] initArray() {
		Vehicle[] vehicleArray;
		int size,pick,i,licensePlate;
		String color;
		System.out.println("Please Enter vehicles array size :");
		size = input.nextInt();
		vehicleArray = new Vehicle[size];
		for (i = 0 ; i < vehicleArray.length ; ++i) {
			System.out.println("=======Creating " + (i+1)+ "/" + vehicleArray.length + "=======");
			System.out.println("Which vehicle you would like to create ?");
			System.out.println("1. With Engine");
			System.out.println("2. Without Engine");
			pick = input.nextInt();
			while (pick != 1 && pick != 2) {
				System.out.println("Invalid choise ! Try again ...");
				pick = input.nextInt();
			}
			System.out.println("Please enter vehicle license plate :");
			licensePlate = input.nextInt();
			while (licensePlate < Vehicle.getlicenseRange()[0] || licensePlate > Vehicle.getlicenseRange()[1]) {
				System.out.println("Invalid license plate ! please enter number in range "+Vehicle.getlicenseRange()[0]+ "-"+Vehicle.getlicenseRange()[1]);
				licensePlate = input.nextInt();
			}
			System.out.println("Please Enter color of the following :" + Arrays.toString(Vehicle.getColors()));
			input.nextLine();
			color = input.nextLine();
			while (!Arrays.asList(Vehicle.getColors()).contains(color)) {
				System.out.println("Invalid color ! Try again ...");
				color = input.nextLine();
			}
			if (pick == 1)
				withEngine(vehicleArray,i,licensePlate,color);
			else
				withoutEngine(vehicleArray,i,licensePlate,color);
		}
		return vehicleArray;
	}
	
	/**
	 * Creating vehicle without engine.
	 *
	 * @param vehicleArray the vehicle array
	 * @param index the index
	 * @param licensePlate the license plate
	 * @param color the color
	 * @return true, if successful
	 */
	public static boolean withoutEngine(Vehicle[] vehicleArray,int index,int licensePlate,String color) {
		int pick,gears;
		String animal;
		System.out.println("Please enter vehicle type :");
		System.out.println("1. Carriage");
		System.out.println("2. Bike");
		pick = input.nextInt();
		while (pick != 1 && pick != 2) {
			System.out.println("Invalid input ! Try again ...");
			pick = input.nextInt();
		}
		if (pick == 1) {
			System.out.println("Please enter type of animal to carry the carriage :");
			input.nextLine();
			animal = input.nextLine();
			vehicleArray[index] = new Carriage(licensePlate, color, animal);
			return true;
		}
		else if (pick == 2) {
			System.out.println("Please enter number of gears :");
			gears = input.nextInt();
			while(gears < 1) {
				System.out.println("Invalid input ! Try again ...");
				gears = input.nextInt();
			}
			vehicleArray[index] = new Bike(licensePlate, color, gears);
			return true;
		}
		return false;
	}
	
	/**
	 * creating vehicle with engine.
	 *
	 * @param vehicleArray the vehicle array
	 * @param index the index
	 * @param licensePlate the license plate
	 * @param color the color
	 * @return true, if successful
	 */
	public static boolean withEngine(Vehicle[] vehicleArray,int index,int licensePlate,String color){
		int enginetype,numOfPassengers,minAge;
		System.out.println("With which engine you would like to build your vehicle ?");
		System.out.println("1. Solar Engine");
		System.out.println("2. Benzine Engine");
		enginetype = input.nextInt();
		while (enginetype != 1 && enginetype != 2) {
			System.out.println("Invalid choise ! Try again ...");
			enginetype = input.nextInt();
		}
		System.out.println("Please enter number of passengers :");
		numOfPassengers = input.nextInt();
		while(numOfPassengers < 1) {
			System.out.println("Invalid input ! Try again ...");
			numOfPassengers = input.nextInt();
		}
		System.out.println("Please enter minimum age to drive :");
		minAge = input.nextInt();
		while (minAge < 16) {
			System.out.println("Invalid input ! Try again ...");
			minAge = input.nextInt();
		}
		
		if (enginetype == 1) {
			vehicleArray[index] = new Car(licensePlate,color,minAge,"SolarEngine",numOfPassengers);
			return true;
		}
		else if (enginetype ==2) {
			vehicleArray[index] = new Car(licensePlate,color,minAge,"BenzineEngine",numOfPassengers);
			return true;
		}
		return false;
	}
	
	/**
	 * Prints the array.
	 *
	 * @param vehicleArray the vehicle array
	 * @return true, if successful
	 */
	public static boolean printArray(Vehicle[] vehicleArray) {
		for (int i = 0 ; i < vehicleArray.length ; ++i)
			System.out.println((i+1)+". " + vehicleArray[i]);
		return true;
	}
	
	/**
	 * Menu.
	 *
	 * @param vehicleArray the vehicle array
	 * @param borders the borders
	 * @return true, if successful
	 */
	public static boolean menu(Vehicle[] vehicleArray,int[] borders) {
		int i,x,y;
		System.out.println("=======Menu=======");
		System.out.println("Please Enter index of vehicle to work with :");
		i = input.nextInt();
		while (i > 0 && i <= vehicleArray.length) {
			--i;
			System.out.println(vehicleArray[i]);
			System.out.println("Please Enter point's X value to drive to :");
			x = input.nextInt();
			System.out.println("Please Enter point's Y value to drive to :");
			y = input.nextInt();
			if (drive(vehicleArray,borders,vehicleArray[i].getLicensePlate(),new Point(x,y)))
				System.out.println("The drive went successfully !");
			else
				System.out.println("We could't drive your car ...");
			System.out.println(vehicleArray[i]);
			System.out.println();
			System.out.println("=======Menu=======");
			System.out.println("Please Enter index of vehicle to work with :");
			printArray(vehicleArray);
			i = input.nextInt();
		}
		System.out.println("Bye Bye !");
		return true;
	}
	
	/**
	 * The main method.
	 *
	 * @param args the arguments
	 */
	public static void main(String[] args) {
		int[] borders = {0,0,0,0};
		initBorders(borders);
		Vehicle vehicleArray[] = initArray();
		printArray(vehicleArray);
		menu(vehicleArray,borders);

	}
}
