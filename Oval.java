
/**
* Oval 
* @author Kyle Zheng
* @version Eclipse macOS May 14, 2021
* Submitted May 14, 2021
* 
* Subclass of Shapes (inheritance)
* Manages information of ovals (class)
*/
public class Oval extends Shapes {
	
	// stores the top left coordinate of oval
	// dependent on the centre coordinates (changing the centre coordinates will automatically adjust these coordinates accordingly) 
	private int topLeftX;
	private int topLeftY;
	
	private int width;
	private int height;
	
	Oval(int width, int height, int x, int y, int red, int green, int blue) {
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
	 * @param width and height -> dimensions of Oval
	 * @return VOID -> does not return anything
	 */
	void setDimensions(int width, int height) {
		this.width = width;
		this.height = height;
		
		this.area = width*height*PI;
		area = Math.round(area*100.00)/100.00;
		
		//perimeter of oval - 2pi * root of ((width^2 + height^2)/2)
		this.perimeter = 2*PI* Math.sqrt( ((Math.pow(width, 2) + Math.pow(height, 2)) / 2) );
		perimeter = Math.round(perimeter*100.00)/100.00;
	}
	
	/**
	 * getWidth
	 * 
	 * Description: Getter method for the width  
	 * 
	 * @param width -> width of oval
	 * @return VOID -> does not return anything
	 */
	public int getWidth() {
		return width;
	}
	
	/**
	 * getHeight
	 * 
	 * Description: Getter method for the height  
	 * 
	 * @param height -> height of oval
	 * @return VOID -> does not return anything
	 */
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
	 * Description: Setter method for the Y coordinate  (centre)
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