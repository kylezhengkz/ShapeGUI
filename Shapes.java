import java.util.ArrayList;


/**
* Shapes 
* @author Kyle Zheng
* @version Eclipse macOS May 14, 2021
* Submitted May 14, 2021
* 
* Superclass (abstract)
* Assigns all the blueprint traits to all subclasses
* Consists of useful methods for the subclasses (and the user interface class)
*/
abstract public class Shapes {

	// all shapes inherit the following traits
	
	// centre of shape (coordinate)
	int centreX;
	int centreY;
	
	// colors
	int colorRed;
	int colorGreen;
	int colorBlue;
	
	// measurements
	double area;
	double perimeter;
	
	/**
	 * setCentreX
	 * 
	 * Description: Setter for the centre X coordinate
	 * This method can be overriden by all subclasses
	 * 
	 * @param x -> stores the X centre coordinate
	 * @return VOID -> does not return anything
	 */
	public void setCentreX(int x) {
		centreX = x;
	}
	
	/**
	 * setCentreY
	 * 
	 * Description: Setter for the centre Y coordinate
	 * This method can be overriden by all subclasses
	 * 
	 * @param x -> stores the Y centre coordinate
	 * @return VOID -> does not return anything
	 */
	public void setCentreY(int y) {
		centreY = y;
	}
	
	/**
	 * translationX
	 * 
	 * Description:
	 * Used for translations
	 * Sets the new translated centre X coordinate  
	 * 
	 * @param x -> stores the translated X centre coordinate
	 * @return VOID -> does not return anything
	 */
	public void translationX(int x) {
		setCentreX(centreX + x);
	}
	
	/**
	 * translationY
	 * 
	 * Description:
	 * Used for translations
	 * Sets the new translated centre Y coordinate  
	 * 
	 * @param y -> stores the translated Y centre coordinate
	 * @return VOID -> does not return anything
	 */
	public void translationY(int y) {
		setCentreY(centreY + y);
	}
	
	public static double PI = 3.14; // constant
	
	/**
	 * listAllShapes
	 * 
	 * Description: 
	 * Lists the characteristics of all the shapes in the array list (perimeter, area, dimensions, type).
	 * Uses a four loop to scan through the indexes.
	 * 
	 * @param sideLength -> an array list that stores all the objects (shapes)
	 * @return VOID -> does not return anything
	 */
	static void listAllShapes(ArrayList<Shapes> printArray) {
		
		// variables that stores the extracted variables from objects (shapes)
		// used for printing
		int base;
		int height;
		int width;
		double heightDouble;
		int side;
		int diameter;
		double area;
		double perimeter;
		
		// stores the adjusted coordinates (matches origin)
		int userCentreX;
		int userCentreY;

		for (int i = 0; i < printArray.size(); ++i) {
			if (printArray.get(i) != null) {
				System.out.print((i + 1) + ". ");
				System.out.println(printArray.get(i).getClass().getName());

				// list colors
				System.out.print("Color RGB: (");
				System.out.print(printArray.get(i).colorRed + ", ");
				System.out.print(printArray.get(i).colorGreen + ", ");
				System.out.println(printArray.get(i).colorBlue + ")");

				// list centre coordinates
				
				// adjust to origin
				userCentreX = printArray.get(i).centreX - 250;
				userCentreY = -(printArray.get(i).centreY - 250);
				
				System.out.print("Centre: (");
				System.out.print(userCentreX + ", ");
				System.out.println(userCentreY + ")");

				// list dimensions + areas + perimeters
				/*
				 * 1) Determines the type of inherited classes (shape) through a series of if statements
				 * 2) Gets the desired information from those classes and stores in another variable
				 * 3) Print
				 */
				
				Shapes objectCopy = printArray.get(i); // stores an index (shape) of the array list
				
				if (objectCopy instanceof Triangle == true) {
					
					base = ((Triangle) objectCopy).getSide();
					System.out.println("Base: " + base);
					
					heightDouble = ((Triangle) objectCopy).height;
					System.out.println("Height: " + heightDouble);
					
					area = ((Triangle) objectCopy).area;
					System.out.println("Area: " + area);
					
					perimeter = ((Triangle) objectCopy).perimeter;
					System.out.println("Perimeter: " + perimeter);
					
				} else if (objectCopy instanceof Rhombus == true) {
					
					side = ((Rhombus) objectCopy).getSide();
					System.out.println("Side length: " + side);
					
					area = ((Rhombus) objectCopy).area;
					System.out.println("Area: " + area);
					
					perimeter = ((Rhombus) objectCopy).perimeter;
					System.out.println("Perimeter: " + perimeter);

				} else if (objectCopy instanceof Square == true) {
					
					side = ((Square) objectCopy).getSide();
					System.out.println("Side length: " + side);
					
					area = ((Square) objectCopy).area;
					System.out.println("Area: " + area);
					
					perimeter = ((Square) objectCopy).perimeter;
					System.out.println("Perimeter: " + perimeter);
					
				} else if (objectCopy instanceof Rectangle == true) {
					
					width = ((Rectangle) objectCopy).getWidth();
					System.out.println("Width: " + width);
					
					height = ((Rectangle) objectCopy).getHeight();
					System.out.println("Height: " + height);
					
					area = ((Rectangle) objectCopy).area;
					System.out.println("Area: " + area);
					
					perimeter = ((Rectangle) objectCopy).perimeter;
					System.out.println("Perimeter: " + perimeter);
					
				} else if (objectCopy instanceof Circle == true) {
					
					diameter = ((Circle) objectCopy).getDiameter();
					System.out.println("Diameter: " + diameter);
					
					area = ((Circle) objectCopy).area;
					System.out.println("Area: " + area);
					
					perimeter = ((Circle) objectCopy).perimeter;
					System.out.println("Perimeter: " + perimeter);
					
				} else if (objectCopy instanceof Oval == true) {
					
					width = ((Oval) objectCopy).getWidth();
					System.out.println("Width: " + width);
					
					height = ((Oval) objectCopy).getHeight();
					System.out.println("Height: " + height);
					
					area = ((Oval) objectCopy).area;
					System.out.println("Area: " + area);
					
					perimeter = ((Oval) objectCopy).perimeter;
					System.out.println("Perimeter: " + perimeter);
					
				} else if (objectCopy instanceof Parallelogram == true) {
					
					width = ((Parallelogram) objectCopy).getWidth();
					System.out.println("Width: " + width);
					
					height = ((Parallelogram) objectCopy).getHeight();
					System.out.println("Height: " + height);
					
					area = ((Parallelogram) objectCopy).area;
					System.out.println("Area: " + area);
					
					perimeter = ((Parallelogram) objectCopy).perimeter;
					System.out.println("Perimeter: " + perimeter);

				}

				System.out.println(); // spacing
				
			} else {
				return;
			}
		}
	}

	/**
	 * triDimensionCal
	 * 
	 * Description: 
	 * If you draw a vertical line from one corner of a rhombus to the opposite side, it forms an inscribed right angled triangle.
	 * Determines the dimensions of the inscribed triangles in a given rhombus.
	 * This can be used to calculate the height of the rhombus, which can then be used to determine the area. 
	 * 
	 * @param sideLength -> int variable that stores the length of the rhombus
	 * @return triDimensions -> double array that contains the dimensions of the inscribed triangle (of rhombus)
	 */
	public static double[] triDimensionCal(int sideLength) {
		/*
		 * 
		 * For every rhombus, the ratio of LENGTH:HEIGHT:BASE of an inscribed right angled triangle (defined above) is 5:4:3
		 * 
		 * We can use that to determine the dimensions of the inscribed right angled triangle (based on user length)
		 * 
		 * For example, if the side length is 15...
		 * 
		 * 15:height:base -> 5:4:3
		 * 
		 * You multiply 5:4:3 by 3 to get 15:height:base
		 * 
		 * 4(x) = 4*3 = 12
		 * 
		 * 3(x) = 3*3 = 9
		 * 
		 * Therefore, the dimensions of the inscribed right angled triangle is 15:12:9
		 * 
		 */

		// multiplier of reduced ratio
		double quotient = 0;

		double doubleSide = sideLength;
		quotient = doubleSide / 5;

		// stores the dimensions of the inscribed triangle
		double triangleBase = quotient * 3;
		double triangleHeight = quotient * 4;

		double[] triDimensions = new double[2];
		triDimensions[0] = triangleBase; // stores the base of the inscribed right angled triangle
		triDimensions[1] = triangleHeight; // stores the height of the inscribed right angled triangle
		return triDimensions;
	}

	/**
	 * roundAndInt
	 * 
	 * Description: Rounds a given double variable into the nearest whole number, and converts from double to int
	 * Exception: if it rounds to 0, round it to 1
	 * 
	 * @param n -> double value
	 * @return returnVal -> returns the converted and rounded double as an int
	 */
	public static int roundAndInt(double n) {
		int returnVal;

		if (Math.rint(n) < 1) { // if the double value rounds to 0
			returnVal = (int) Math.ceil(n); // round UP to the nearest (all sides must be at least one unit long)
		} else {
			returnVal = (int) Math.rint(n); // rounds to nearest integer
		}

		return returnVal;
	}
	
	/**
	 * pythaHypo
	 * 
	 * Description: Determines the hypotenuse of a triangle, given the two other sides
	 * Uses pythagorean theorem
	 * 
	 * @param double a and double b -> represents side lengths
	 * @return double c -> returns the hypotenuse (largest side)
	 */
	public static double pythaHypo(double a, double b) {
		double c;
		c = Math.sqrt(Math.pow(a, 2) + Math.pow(b, 2)); // pythagorean theorem
		return c;
	}

	/**
	 * pythaLength
	 * 
	 * Description: Determines the length(NON-HYPOTENUSE) of a triangle, given the two other sides
	 * Uses pythagorean theorem
	 * 
	 * If you want to determine the missing hypotenuse, use the method called 'pythaHypo' (above)
	 * 
	 * @param double b and double c -> represents side lengths
	 * @return double a -> returns the missing side of triangle
	 */
	public static double pythaLength(double b, double c) {
		double a;
		a = Math.sqrt(Math.pow(c, 2) - Math.pow(b, 2)); // pythagorean theorem
		return a;
	}
	
}
