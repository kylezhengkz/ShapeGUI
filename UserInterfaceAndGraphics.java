/**
* 
* [Kyle_Zheng.zip]
* 
* UserInterfaceAndGraphics
* Computer Science OOP summative 
* @author Kyle Zheng
* @version Eclipse macOS May 14, 2021
* Submitted May 14, 2021
* 
* This program allows the user to add 2D shapes (of their choice) onto a screen (graphically).
* The user can add as many shapes as he/she desires until he/she decides the quit the program.
* The user can also remove and translate shapes, as well as listing the characterisitcs of the shapes.
* User friendly.
* 
*/

//import statements
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.Color;
import java.util.ArrayList;
import java.util.Scanner;

/**
* UserInterfaceAndGraphics 
* This class is an interface system that provides the users with instructions. 
* Also contains inner classes that has information regarding graphics.
*/
class UserInterfaceAndGraphics {
	static JFrame frame;
	
	public static ArrayList<Shapes> shapeArray = new ArrayList<>(); // stores objects (shapes)

	// MAIN - PROGRAM STARTS HERE
	public static void main(String[] args) {

		GeometryScreen gs = new GeometryScreen();
		Scanner sc = new Scanner(System.in);

		// input variables
		String command = "";
		String shapeCommand = "";
		int shapeRemove = 0;
		int shapeTranslate;
		int translateX = 0;
		int translateY = 0;
		
		// shape information variables
		int centreXInput = 0;
		int centreYInput = 0;
		int widthInput = 0;
		int heightInput = 0;
		int sideLength = 0;
		int diameter = 0;
		int red = 0;
		int green = 0;
		int blue = 0;
		
		// other variables
		int listIndex = 0;
		
		do {
			// menu display
			System.out.println("Select one of the following options(numbers) below");
			System.out.println("1. Display all shapes to console w/ relevant data (type, coords, area, perimeter)");
			System.out.println("2. Add a single shape");
			System.out.println("3. Remove a single shape");
			System.out.println("4. Translate a single shape");
			System.out.println("5. Translate entire drawing (transition applied to all shapes)");
			System.out.println("6. Quit");
			System.out.println();
			System.out.print("Selection: ");

			command = sc.next();
			
			// display all shapes to console w/ relevant data (type, coords, area, perimeter)
			if (command.equals("1")) {
				
				if (shapeArray.size() <= 0) { // no objects
					System.out.println();
					System.out.println("No shapes so far. Try adding one instead.");
					System.out.println();
				} else {
					System.out.println();
					System.out.println("Here are the list of shapes you have added thus far");
					Shapes.listAllShapes(shapeArray); // refer to Shapes.java for more details about the method
				}

			// add a single shape
			} else if (command.equals("2")) {

				System.out.println();
				System.out.println("Select one of the following shapes(numbers) below");
				System.out.println("1. Oval");
				System.out.println("2. Rectangle");
				System.out.println("3. Parallelogram");
				System.out.println("4. Rhombus");
				System.out.println("5. Square");
				System.out.println("6. Triangle");
				System.out.println("7. Circle");
				System.out.println();
				System.out.print("Selection: ");
				shapeCommand = sc.next();
				System.out.println();

				// shape menu
				// non-equilateral shapes
				if (shapeCommand.equals("1") || shapeCommand.equals("2") || shapeCommand.equals("3")) {
					
					System.out.print("Input x-coordinate for the centre of your shape: ");
					centreXInput = sc.nextInt();
					centreXInput = centreXInput + 250; // shift to origin

					System.out.print("Input y-coordinate for the centre of your shape: ");
					centreYInput = sc.nextInt();
					
					// reverse the sign for y coordinate (the program reads coordinates differently)
					centreYInput = -centreYInput + 250; // shift to origin

					System.out.print("Input width (must be >=1): ");
					widthInput = sc.nextInt();

					System.out.print("Input height (must be >=1): ");
					heightInput = sc.nextInt();
					
					System.out.print("Input red color value (0-255): ");
					red = sc.nextInt();
					
					System.out.print("Input green color value (0-255): ");
					green = sc.nextInt();
					
					System.out.print("Input blue color value (0-255): ");
					blue = sc.nextInt();

					System.out.println();
					
					/*
					 * Separated the shapes to match their inputs.
					 * For example, ovals, rectangles and parallelograms receives the width and height,
					 * while other shapes such as squares and rhombuses receives ONE side
					*/
					
					// input both width and height
					
					if (widthInput > 0 && heightInput > 0 && 0 <= red && red <= 255 && 0 <= green && green <= 255 && 0 <= blue && blue <= 255) {
					// the if statement above is used to scan for any user input errors; will notify the user if that happens
						
						if (shapeCommand.equals("1")) { // oval
							shapeArray.add(new Oval(widthInput, heightInput, centreXInput, centreYInput, red, green, blue));		
						
						} else if (shapeCommand.equals("2")) { // rectangle
							shapeArray.add(new Rectangle(widthInput, heightInput, centreXInput, centreYInput, red, green, blue));

						} else if (shapeCommand.equals("3")) { // parallelogram
							shapeArray.add(new Parallelogram(widthInput, heightInput, centreXInput, centreYInput, red, green, blue));
						}
					
						System.out.println("Shape added.");
					
					} else { // input error
						System.out.println("Invalid shape characteristics. Please try again."); // returns back to menu
					}

				// equilateral shapes (input single side)
				} else if (shapeCommand.equals("4") || shapeCommand.equals("5")  || shapeCommand.equals("6")) {
					
					System.out.print("Input x-coordinate for the centre of your shape: ");
					centreXInput = sc.nextInt();
					centreXInput = centreXInput + 250; // shift to origin

					System.out.print("Input y-coordinate for the centre of your shape: ");
					centreYInput = sc.nextInt();
					centreYInput = -centreYInput + 250; // shift to origin
					
					System.out.print("Input length of side (must be >=1): ");
					sideLength = sc.nextInt();
					
					System.out.print("Input red color value (0-255): ");
					red = sc.nextInt();
					
					System.out.print("Input green color value (0-255): ");
					green = sc.nextInt();
					
					System.out.print("Input blue color value (0-255): ");
					blue = sc.nextInt();
					
					System.out.println();
					
					if (sideLength > 0 && 0 <= red && red <= 255 && 0 <= green && green <= 255 && 0 <= blue && blue <= 255) {
						
						if (shapeCommand.equals("4")) { // rhombus
							shapeArray.add(new Rhombus(sideLength, centreXInput, centreYInput, red, green, blue));
							
						} else if (shapeCommand.equals("5")) { // square
							shapeArray.add(new Square(sideLength, centreXInput, centreYInput, red, green, blue));
					
						} else if (shapeCommand.equals("6")) { // triangle
							shapeArray.add(new Triangle(sideLength, centreXInput, centreYInput, red, green, blue));
						}
					
						System.out.println("Shape added.");
					
					} else {
						System.out.println("Invalid shape characteristics. Please try again.");
					}
				
				// circle
				// input diameter
				} else if (shapeCommand.equals("7")) {
					System.out.print("Input x-coordinate for the centre of your shape: ");
					centreXInput = sc.nextInt();
					centreXInput = centreXInput + 250; // shift to origin

					System.out.print("Input y-coordinate for the centre of your shape: ");
					centreYInput = sc.nextInt();
					centreYInput = -centreYInput + 250; // shift to origin
					
					System.out.print("Input diameter (must be >=1): ");
					diameter = sc.nextInt();
					
					System.out.print("Input red color value (0-255): ");
					red = sc.nextInt();
					
					System.out.print("Input green color value (0-255): ");
					green = sc.nextInt();
					
					System.out.print("Input blue color value (0-255): ");
					blue = sc.nextInt();
					
					System.out.println();
					
					if (diameter > 0 && 0 <= red && red <= 255 && 0 <= green && green <= 255 && 0 <= blue && blue <= 255) {
						shapeArray.add(new Circle(diameter, centreXInput, centreYInput, red, green, blue));
						System.out.println("Shape added.");
					} else {
						System.out.println("Invalid shape characteristics. Please try again.");
					}

				}	
				
				// none of the above
				else {
					System.out.println("Unknown option. Please try again."); // goes back to main options
				}
				
				System.out.println();

			// remove a single shape
			} else if (command.equals("3")) {
				
				if (shapeArray.size() <= 0) { // no objects
					System.out.println();
					System.out.println("No shapes to remove. Try adding one instead.");
					System.out.println();
				} else {
					System.out.println();
					Shapes.listAllShapes(shapeArray);
					
					System.out.print("Enter the shape(number) you would like to remove: ");
					shapeRemove = sc.nextInt();
					shapeArray.remove(shapeRemove - 1);
					System.out.println();
					System.out.println("Shape removed.");
					System.out.println();
				}
				
			// translate a single shape
			} else if (command.equals("4")) {
				
				if (shapeArray.size() <= 0) { // no objects
					System.out.println();
					System.out.println("No shapes to translate. Try adding one instead.");
					System.out.println();
					
				} else {
					
					System.out.println();
					Shapes.listAllShapes(shapeArray);
					
					System.out.print("Enter the shape(number) you would like to translate: ");
					shapeTranslate = sc.nextInt();
					listIndex = shapeTranslate - 1;
					
					System.out.print("Enter horizontal translation: ");
					translateX = sc.nextInt(); // X translation
					
					System.out.print("Enter vertical translation: ");
					translateY = sc.nextInt(); // Y translation
					
					Shapes objectClone = shapeArray.get(listIndex); // casts objectClone
					// sets the new translated coordinates through the following methods (refer to Shapes.java)
					objectClone.translationX(translateX);
					objectClone.translationY(-translateY);
					
					System.out.println();
					
				}
			// translate entire drawing
			} else if (command.equals("5")) {
				
				if (shapeArray.size() <= 0) { // no objects
					System.out.println();
					System.out.println("No shapes to translate. Try adding one instead.");
					System.out.println();
				} else {
					System.out.print("Enter horizontal translation: ");
					translateX = sc.nextInt();
					
					System.out.print("Enter vertical translation: ");
					translateY = sc.nextInt();
					
					// runs through the array list
					for (int i = 0; i < shapeArray.size(); i++) {
						Shapes objectCloner = shapeArray.get(i);
						// sets each index (class) with its new respective translated coordinates through the following methods (refer to Shapes.java)
						objectCloner.translationX(translateX);
						objectCloner.translationY(-translateY);
					}
					
				}
				
			} else if (command.equals("6")) {
			System.out.println("Program closed.");

			} else {
				System.out.println();
				System.out.println("Unknown command. Please try again."); // returns to menu
				System.out.println();
			}
			
			frame.repaint(); // update the screen
			
		} while (!command.equals("6"));
		
		sc.close(); // close scanner
		
		System.exit(0);
	
	} // END OF MAIN
	
	/**
	* GeometryScreen 
	* This is an inner class - it has access to the static variables defined above. 
	* Designs the graphic panel for the user to look at. All shapes will be sketched there.
	*/
	public static class GeometryScreen {

		// constructor - do not modify
		GeometryScreen() {
			frame = new JFrame("Geometry Drawing Program 1.0");

			// create a new "custom" panel for graphics based on the inner class below
			JPanel graphicsPanel = new GraphicsPanel();

			// add the panel and the frame to the window
			frame.getContentPane().add(graphicsPanel);

			// set the frame to full screen
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.setSize(520, 540);
			frame.setUndecorated(false); // set to true to remove title bar
			frame.setVisible(true);

		}

		/**
		* GeometryScreen 
		* Contains all the details about drawing to the screen.
		* This is the class where shapes are drawn.
		*/
		public static class GraphicsPanel extends JPanel {

			/**
			 * paintComponent
			 * 
			 * Description: 
			 * Sketches everything onto the screen panel.
			 * 
			 * @param Graphics g
			 * @return VOID -> does not return anything
			 */
			public void paintComponent(Graphics g) {
				setDoubleBuffered(true);
				
				// draw the X/Y Axis
				// origin (250, 250)
				g.setColor(Color.BLACK);
				g.drawLine(250, 0, 250, 520);
				g.drawLine(0, 250, 520, 250);
				
				// variables that stores the extracted variables from objects (shapes)
				// used for printing
				int x;
				int y;
				int width;
				int height;
				int side;
				int diameter;
						
				// runs through each shape (class) of the array list of objects
				// prints all shapes onto the graphics panel according to its current information
				for (int i = 0; i < shapeArray.size(); i++) {
					
					// set color
					Color shapeCol = new Color(shapeArray.get(i).colorRed, shapeArray.get(i).colorGreen, shapeArray.get(i).colorBlue);
					g.setColor(shapeCol);
					
					// non-equilateral shapes
					Shapes s = shapeArray.get(i); // casts into objects to receive its desired values
					if (s instanceof Oval == true) { // determines class of object
						x = ((Oval) s).getTopLeftX(); // as shown, casting is being applied (same concept applies throughout the code below)
						y = ((Oval) s).getTopLeftY();
						width = ((Oval) s).getWidth();
						height = ((Oval) s).getHeight();

						// x and y represents the top left coordinate (to draw from)
						// width and height represents the dimensions
						g.drawOval(x, y, width, height); // sketches shape (information inside brackets includes coordinates and dimensions)
						
					}  else if (s instanceof Rectangle == true) {
						x = ((Rectangle) s).getTopLeftX();
						y = ((Rectangle) s).getTopLeftY();
						width = ((Rectangle) s).getWidth();
						height = ((Rectangle) s).getHeight();
						
						g.drawRect(x, y, width, height);
						
					} else if (s instanceof Parallelogram == true) {
						int[] parallelogramX = ((Parallelogram) s).getCoorX();
						int[] parallelogramY = ((Parallelogram) s).getCoorY();
						
						g.drawPolygon(parallelogramX, parallelogramY, 4); // plots coordinates and connects those points to create a closed shape
					}

					// equilateral shapes 
					// circles don't classify as equilateral shapes, but the radius is always constant, so in a sense, it is (kind of)
					else if (s instanceof Square == true) {
						x = ((Square) s).getTopLeftX();
						y = ((Square) s).getTopLeftY();
						side = ((Square) s).getSide();
						
						g.drawRect(x, y, side, side);

					} else if (s instanceof Triangle == true) {
						int[] triangleX = ((Triangle) s).getCoorX();
						int[] triangleY = ((Triangle) s).getCoorY();
					
						g.drawPolygon(triangleX, triangleY, 3); // plots coordinates and connects those points to create a closed shape

					} else if (s instanceof Rhombus == true) {
						int[] rhombusX = ((Rhombus) s).getCoorX();
						int[] rhombusY = ((Rhombus) s).getCoorY();
				
						g.drawPolygon(rhombusX, rhombusY, 4); // plots coordinates and connects those points to create a closed shape

					} else if (s instanceof Circle == true) {
						x = ((Circle) s).getTopLeftX();
						y = ((Circle) s).getTopLeftY();
						diameter = ((Circle) s).getDiameter();
					
						g.drawOval(x, y, diameter, diameter);

					}
					
				}
				
			}
			
		}
		
	}
	
}


