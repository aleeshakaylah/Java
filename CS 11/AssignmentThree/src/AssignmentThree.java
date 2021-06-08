
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.Line2D;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;


/**
*Assignment Four: Recursive Fractal Image Generation
*
*@author Aleesha Nageer for CMPS 11, anageer@ucsc.edu
*
*/

public class AssignmentThree {
	/**
	 * Writes a sample image to file "sierpinski-demo.png"
	 * The width (in pixels) of the image, as a positive decimal integer
The height (in pixels) of the image, as a positive decimal integer
The minimum area (in pixels) that a triangle must have in order to be drawn, as a decimal floating-point value to double precision.
The foreground/drawing color, as a string acceptable to method Color.decode, as in the starter code below.
The output filename, i.e. a path to a file in which the output will be stored as a PNG image.

	 * @param args unused
	 */
	static Graphics2D graphics;
	static double area;
	public static void main(String[] args) {


		double width = Double.parseDouble(args[0]);
		double height = Double.parseDouble(args[1]);
		area = Float.parseFloat(args[2]);
		String color = args[3];
		String filename = args[4].substring(0, args[4].lastIndexOf('.'));

    // A 320x240-pixel RGB image
    BufferedImage image = new BufferedImage((int)width, (int)height, BufferedImage.TYPE_INT_RGB);
    // Graphics2D is our "drawing" class
    graphics = image.createGraphics();
    // Any clearing operations will use a yellow color

    Color c = Color.white;

	try {

		if (!color.matches(".*\\d.*"))
                    c = (Color)Color.class.getField(color).get(null) ;
                        else
                    c = Color.decode(color);

	} catch (IllegalArgumentException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	} catch (IllegalAccessException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	} catch (NoSuchFieldException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	} catch (SecurityException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	}
        Color cb = new Color(255-c.getRed(),
                         255-c.getGreen(),
                         255-c.getBlue());
    graphics.setBackground(cb);
    // Clear the image to the background color
    graphics.clearRect(0, 0, image.getWidth(), image.getHeight());
    // Any drawing operations will use a blue color
    graphics.setColor(c);
    Sierpinski (width/2, 0, 0, height, width, height);// Draw a line from the upper-left corner (0, 0) to the lower-right corner (width - 1, height - 1):
    //graphics.drawLine(0, 0, image.getWidth() - 1, image.getHeight() - 1);
    // Draw a line from the lower-left corner (0, height - 1) to the upper-right corner (width - 1, 0):
    //graphics.drawLine(0, image.getHeight() - 1, image.getWidth() - 1, 0);
    // Save the image as a PNG file named "sierpinski-demo.png"
    try {
      ImageIO.write(image, "png", new File(filename + ".png"));

    }
    catch (Exception e) {
      System.err.println("Unable to write image file!: " + e.getMessage());
    }
  }
	public static void Sierpinski(double tx, double ty, double lx, double ly, double rx, double ry) {

		double areaTriangle = Math.abs(((rx - lx) * (ry - ty)) / 2);

		if (areaTriangle < area) {

		    return;
		}
		graphics.drawLine((int)Math.round(tx), (int)Math.round(ty), (int)Math.round(lx), (int)Math.round(ly));
		graphics.drawLine((int)Math.round(lx), (int)Math.round(ly), (int)Math.round(rx), (int)Math.round(ry));
		graphics.drawLine((int)Math.round(rx), (int)Math.round(ry), (int)Math.round(tx), (int)Math.round(ty));
	    Sierpinski(tx, ty, Math.abs((tx + lx) / 2), Math.abs((ly + ty) / 2), Math.abs((rx + tx) / 2), Math.abs((ry + ty) / 2));
	    Sierpinski(Math.abs((tx + lx) / 2), Math.abs((ly + ty) / 2), lx, ly, Math.abs((rx + lx) / 2), Math.abs((ry + ly) / 2));
	    Sierpinski(Math.abs((rx + tx) / 2), Math.abs((ry + ty) / 2), Math.abs((rx + lx) / 2), Math.abs((ry + ly) / 2), rx, ry);
	}
}