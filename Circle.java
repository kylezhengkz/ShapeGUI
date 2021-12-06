
/**
* Circle
* @author Kyle Zheng
* @version Eclipse macOS May 14, 2021
* Submitted May 14, 2021
* 
* Subclass of Shapes (inheritance)
* Manages information of circles (class)
*/
public class Circle extends Shapes {
	
	// stores the top left coordinate of circle
	// dependent on the centre coordinates (changing the centre coordinates will automatically adjust these coordinates accordingly) 
	private int topLeftX;
	private int topLeftY;
	
	private int diameter;
	
	// it is important for the dimension(s) to come first because the area and perimeter calculations depends on it
	// if it doesn't come first, then it won't be assigned a value by the time the area and perimeter calculations are performed
	Circle(int d, int x, int y, int red, int green, int blue) {
		setDimensions(d);
		setCentreX(x);
		setCentreY(y);
		this.colorRed = red;
		this.colorGreen = green;
		this.colorBlue = blue;
	}
	
	/**
	 * setDimensions
	 * 
	 * Description: Setter method for the diamater 
	 * The diamater is also used to calculate area and perimeter
	 * 
	 * @param diameter -> diameter of circle
	 * @return VOID -> does not return anything
	 */
	void setDimensions(int diameter) {
		this.diameter = diameter;
		double copyDiameter = diameter;

		this.perimeter = 2*PI*(copyDiameter/2);
		perimeter = Math.round(perimeter*100.00)/100.00; // round to the nearest hundredth
		
		this.area = PI*Math.pow(copyDiameter/2, 2);
		area = Math.round(area*100.00)/100.00;
	}
	
	/**
	 * getDiameter
	 * 
	 * Description: Getter method for the diameter
	 * 
	 * @param diameter -> diameter of circle
	 * @return VOID -> does not return anything
	 */
	public int getDiameter() {
		return diameter;
	}
	
	/**
	 * setCentreX
	 * 
	 * Description: Setter method for the X coordinate (centre)
	 * 
	 * @param x -> x coordinate
	 * @return VOID -> does not return anything
	 */
	@Override
	public void setCentreX(int x) {
		centreX = x;
		topLeftX = centreX - diameter/2;
	}
	
	/**
	 * setCentreY
	 * 
	 * Description: Setter method for the Y coordinate  (centre)
	 * 
	 * @param y -> y coordinate
	 * @return VOID -> does not return anything
	 */
	@Override
	public void setCentreY(int y) {
		centreY = y;
		topLeftY = centreY - diameter/2;
	}
	
	/**
	 * getTopLeftX
	 * 
	 * Description: Gets the centre X coordinate, which is private btw (centre)
	 * 
	 * @param x -> x coordinate
	 * @return VOID -> does not return anything
	 */
	public int getTopLeftX() {
		return topLeftX;
	}
	
	/**
	 * getTopLeftY
	 * 
	 * Description: Gets the centre Y coordinate, which is private btw (centre)
	 * 
	 * @param y -> y coordinate
	 * @return VOID -> does not return anything
	 */
	public int getTopLeftY() {
		return topLeftY;
	}
	
}
