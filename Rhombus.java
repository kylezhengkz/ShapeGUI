
/**
* Rhombus 
* @author Kyle Zheng
* @version Eclipse macOS May 14, 2021
* Submitted May 14, 2021
* 
* Subclass of Shapes (inheritance)
* Manages information of rhombus (class)
*/
public class Rhombus extends Shapes {

	// stores the coordinates of rhombus
	// dependent on the centre coordinates (changing the centre coordinates will automatically adjust these coordinates accordingly) 
	private int[] xCoor = new int[4];
	private int[] yCoor = new int[4];

	private int side;

	Rhombus(int side, int x, int y, int red, int green, int blue) {
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
	 * @param side -> length of Rhombus
	 * @return VOID -> does not return anything
	 */
	void setDimensions(int side) {
		this.side = side;

		double[] triangleDimensions = triDimensionCal(side);
		this.perimeter = 4 * side;
		perimeter = Math.round(perimeter*100.00)/100.00;

		int intTriangleHeight = roundAndInt(triangleDimensions[1]); // refer to Shapes.java

		/*
		 * The area for rhombus is height*base
		 * The height can be determined using the ratio rule (5:4:3) - refer to Shapes.java
		 */
		double sideCopy = side;
		this.area = intTriangleHeight * sideCopy;
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
		
		double[] triangleDimensions = triDimensionCal(side);
		int intTriangleBase = roundAndInt(triangleDimensions[0]);
		xCoor[0] = centreX + intTriangleBase + (side - intTriangleBase) / 2;
		xCoor[1] = centreX - (side - intTriangleBase) / 2;
		xCoor[2] = centreX - intTriangleBase - (side - intTriangleBase) / 2;
		xCoor[3] = centreX + (side - intTriangleBase) / 2;
	}
	
	/**
	 * setCentreY
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
		
		double[] triangleDimensions = triDimensionCal(side);
		int intTriangleHeight = roundAndInt(triangleDimensions[1]);
		yCoor[0] = centreY - intTriangleHeight / 2;
		yCoor[1] = centreY - intTriangleHeight / 2;
		yCoor[2] = centreY + intTriangleHeight / 2;
		yCoor[3] = centreY + intTriangleHeight / 2;
	}
	
	/**
	 * getCoorX
	 * 
	 * Description: Gets the X coordinates of rhombus
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
	 * Description: Gets the Y coordinates of rhombus
	 * 
	 * @param getCoorY -> array of y coordinates
	 * @return VOID -> does not return anything
	 */
	public int[] getCoorY() {
		return yCoor;
	}

}
