package graphics;

/**
 * The Interface IAnimal.
 * 
 * @author Stav Lobel
 */
public interface IAnimal extends IMoveable {
	
	/**
	 * Gets the animal name.
	 *
	 * @return the animal name
	 */
	public String getAnimalName();
	
	/**
	 * Eat - Feeding the animal for full energy.
	 *
	 * @return true, if successful. false if already full.
	 */
	public boolean eat();

}
