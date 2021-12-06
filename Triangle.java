
/**
* Triangle 
* @author Kyle Zheng
* @version Eclipse macOS May 14, 2021
* Submitted May 14, 2021
* 
* Subclass of Shapes (inheritance)
* Manages information of triangle (class)
*/
public class Triangle extends Shapes {
	
	// stores the coordinates of triangle
	// dependent on the centre coordinates (changing the centre coordinates will automatically adjust these coordinates accordingly) 
	private int[] xCoor = new int[3];
	private int[] yCoor = new int[3];
	
	private int side;
	double height;
		
	Triangle(int side, int x, int y, int red, int green, int blue) {
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
	 * @param side -> length of Triangle
	 * @return VOID -> does not return anything
	 */
	void setDimensions(int side) {
		this.side = side;
		
		this.perimeter = 3*side;
		perimeter = Math.round(perimeter*100.00)/100.00;
		
		height = pythaLength(side/2, side); // used pythagorean theorem to calculate the height
		height = Math.round(height*100.00)/100.00;
		
		this.area = (side*height)/2;
		area = Math.round(area*100.00)/100.00;
	}
	
	public int getSide() {
		return side;
	}
	
	/**
	 * setCentreX
	 * 
	 * Description: Setter method for the X coordinate (centre)
	 * Uses the coordinate to find the X coordinates of shape (tips)
	 * 
	 * @param x -> x coordinate
	 * @return VOID -> does not return anything
	 */
	@Override
	public void setCentreX(int x) {
		centreX = x;
		this.xCoor[0] = centreX;
		this.xCoor[1] = centreX - (side / 2);
		this.xCoor[2] = centreX + (side / 2);
	}
	
	/**
	 * getTopLeftY
	 * 
	 * Description: Setter method for the Y coordinate (centre)
	 * Uses the coordinate to find the Y coordinates of shape (tips)
	 * 
	 * @param y -> y coordinate
	 * @return VOID -> does not return anything
	 */
	@Override
	public void setCentreY(int y) {
		centreY = y;
		this.yCoor[0] = centreY - (side / 2);
		this.yCoor[1] = centreY + (side / 2);
		this.yCoor[2] = centreY + (side / 2);
	}
	
	/**
	 * getCoorX
	 * 
	 * Description: Gets the X coordinates of triangle
	 * 
	 * @param getCoorX -> array of x coordinates
	 * @return VOID -> does not return anything
	 */
	public int[] getCoorX() {
		return xCoor;
	}
	
	/**
	 * getCoorY
	 * 
	 * Description: Gets the Y coordinates of triangle
	 * 
	 * @param getCoorY -> array of y coordinates
	 * @return VOID -> does not return anything
	 */
	public int[] getCoorY() {
		return yCoor;
	}
	
}
