
/**
* Parallelogram 
* @author Kyle Zheng
* @version Eclipse macOS May 14, 2021
* Submitted May 14, 2021
* 
* Subclass of Shapes (inheritance)
* Manages information of parallelogram (class)
*/
public class Parallelogram extends Shapes {

	// stores the coordinates of parallelogram
	// dependent on the centre coordinates (changing the centre coordinates will automatically adjust these coordinates accordingly) 
	private int[] xCoor = new int[4];
	private int[] yCoor = new int[4];
	
	private int width;
	private int height;

	Parallelogram(int width, int height, int x, int y, int red, int green, int blue) {
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
	 * @param width and height -> dimensions of Parallelogram
	 * @return VOID -> does not return anything
	 */
	void setDimensions(int width, int height) {
		this.width = width;
		this.height = height;
		
		this.area = width*height;
		area = Math.round(area*100.00)/100.00;
		
		/*
		 * Finding perimeter of parallelogram (given height and width).
		 * 
		 * If you draw a line from one corner of the parallelogram to the other side, it creates an inscribed right angled triangle.
		 * In order for the parallelogram to be 45 degrees, the height and base of the right angled triangle must be equal.
		 * The height of the triangle has been provided (from height of parallelogram).
		 * Use pythagorean theorem to calculate the side length.
		 * 
		 * If the height is greater than the width, then there is no vertical line from any corner to the opposite side.
		 * As a result, it creates a right angled triangle diagram OUTSIDE the parallelogram.
		 * However, it's still a triangle, and the same rules can apply for calculating the area and perimeter.
		 */
		
		// coordinates of triangle (both equal since it's 45 degrees)
		double triHeight = height;
		double triBase = height;
		
		double hypo = (pythaHypo(triHeight, triBase)); // used pythagorean theorem to calculate the side length (hypotenuse)
		this.perimeter = (2*hypo) + (2*width);
		perimeter = Math.round(perimeter*100.00)/100.00;
		
		int distanceBetweenTriX = width - height;
		
		// determine the coordinates
		
		// top right
		xCoor[0] = (int) (centreX + distanceBetweenTriX/2 + triBase);
		yCoor[0] = centreY - height/2;

		// top left
		xCoor[1] = centreX - distanceBetweenTriX/2;
		yCoor[1] = centreY - height/2;

		// bottom left
		xCoor[2] = (int) (centreX - distanceBetweenTriX/2 - triBase);
		yCoor[2] = centreY + height/2;

		// bottom right
		xCoor[3] = centreX + distanceBetweenTriX/2;
		yCoor[3] = centreY + height/2;
		
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
	 * Uses the coordinate to find the X coordinates of shape (tips)
	 * 
	 * @param x -> x coordinate
	 * @return VOID -> does not return anything
	 */
	@Override
	public void setCentreX(int x) {
		int distanceBetweenTriX = width - height;
		double triBase = height;
		centreX = x;
		xCoor[0] = (int) (centreX + distanceBetweenTriX/2 + triBase);
		xCoor[1] = centreX - distanceBetweenTriX/2;
		xCoor[2] = (int) (centreX - distanceBetweenTriX/2 - triBase);
		xCoor[3] = centreX + distanceBetweenTriX/2;
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
		yCoor[0] = centreY - height/2;
		yCoor[1] = centreY - height/2;
		yCoor[2] = centreY + height/2;
		yCoor[3] = centreY + height/2;
	}
	
	/**
	 * getCoorX
	 * 
	 * Description: Gets the X coordinates of parallelogram
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
	 * Description: Gets the Y coordinates of parallelogram
	 * 
	 * @param getCoorY -> array of y coordinates
	 * @return VOID -> does not return anything
	 */
	public int[] getCoorY() {
		return yCoor;
	}

}
