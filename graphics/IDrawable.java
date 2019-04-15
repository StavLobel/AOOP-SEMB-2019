package graphics;
import java.awt.Graphics;

/**
 * The Interface IDrawable.
 */
public interface IDrawable {
	
	/** The Constant PICTURE_PATH. */
	public final static String PICTURE_PATH = "PNGs//";
	
	/**
	 * Load images.
	 *
	 * @param nm the nm
	 */
	public void loadImages();
	
	/**
	 * Draw object.
	 *
	 * @param g the g
	 */
	public void drawObject (Graphics g);
	
	/**
	 * Gets the color.
	 *
	 * @return the color
	 */
	public String getColor();

}
