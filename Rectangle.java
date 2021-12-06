
/**
* Rectangle 
* @author Kyle Zheng
* @version Eclipse macOS May 14, 2021
* Submitted May 14, 2021
* 
* Subclass of Shapes (inheritance)
* Manages information of rectangle (class)
*/
public class Rectangle extends Shapes {
	
	// stores the top left coordinate of rectangle
	// dependent on the centre coordinates (changing the centre coordinates will automatically adjust these coordinates accordingly) 
	private int topLeftX;
	private int topLeftY;
	
	private int width;
	private int height;
	
	Rectangle(int width, int height, int x, int y, int red, int green, int blue) {
		setDimensions(width, height);
		setCentreX(x);
		setCentreY(y);
		this.colorRed = red;
		this.colorGreen = green;
		this.colorBlue = blue;
	}
	
	/**
	 * setDimensions
	 * 
	 * Description: Setter method for the width and height 
	 * The width and height are also used to calculate area and perimeter
	 * 
	 * @param width and height -> dimensions of Rectangle
	 * @return VOID -> does not return anything
	 */
	void setDimensions(int width, int height) {
		this.width = width;
		this.height = height;
		
		this.area = width*height;
		area = Math.round(area*100.00)/100.00;
		
		this.perimeter = (2*width) + (2*height);
		perimeter = Math.round(perimeter*100.00)/100.00;
	}
	
	public int getWidth() {
		return width;
	}
	
	public int getHeight() {
		return height;
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
		topLeftX = centreX - width/2;
	}
	
	/**
	 * setCentreY
	 * 
	 * Description: Setter method for the Y coordinate (centre)
	 * 
	 * @param y -> y coordinate
	 * @return VOID -> does not return anything
	 */
	@Override
	public void setCentreY(int y) {
		centreY = y;
		topLeftY = centreY - height/2;
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
