
/**
* Square 
* @author Kyle Zheng
* @version Eclipse macOS May 14, 2021
* Submitted May 14, 2021
* 
* Subclass of Shapes (inheritance)
* Manages information of square (class)
*/
public class Square extends Shapes {
	
	// stores the top left coordinate of square
	// dependent on the centre coordinates (changing the centre coordinates will automatically adjust these coordinates accordingly) 
	private int topLeftX;
	private int topLeftY;
	
	private int side;
	
	Square(int side, int x, int y, int red, int green, int blue) {
		setDimensions(side);
		setCentreX(x);
		setCentreY(y);
		this.colorRed = red;
		this.colorGreen = green;
		this.colorBlue = blue;
	}
	
	/**
	 * setDimensions
	 * 
	 * Description: Setter method for the side length 
	 * The side length is also used for calculating the area and perimeter
	 * 
	 * @param side -> length of Square
	 * @return VOID -> does not return anything
	 */
	void setDimensions(int side) {
		this.side = side;
		
		this.area = side*side;
		area = Math.round(area*100.00)/100.00;

		this.perimeter = 4*side;
		perimeter = Math.round(perimeter*100.00)/100.00;
		
		this.topLeftX = centreX - side/2;
		this.topLeftY = centreY - side/2;
	}
	
	public int getSide() {
		return side;
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
		topLeftX = centreX - side/2;
	}
	
	/**
	 * getTopLeftY
	 * 
	 * Description: Gets the centre Y coordinate, which is private btw (centre)
	 * 
	 * @param y -> y coordinate
	 * @return VOID -> does not return anything
	 */
	@Override
	public void setCentreY(int y) {
		centreY = y;
		topLeftY = centreY - side/2;
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
