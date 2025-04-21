package assignment9;

import java.awt.Color;

import edu.princeton.cs.introcs.StdDraw;

public class BodySegment {

	private double x, y, size;
	private Color color;
	
	public BodySegment(double x, double y, double size) {
		this.x = x;
		this.y = y;
		this.size = size;
		this.color = ColorUtils.solidColor();
		//FIXME
		
		//See ColorUtils for some color options (or choose your own)
	}	
	
	public double getX() {
		return x;
	}

	public void setX(double x) {
		this.x = x;
	}

	public double getY() {
		return y;
	}

	public void setY(double y) {
		this.y = y;
	}

	/**
	 * Draws the segment
	 */
	public void draw() {
		StdDraw.setPenColor(this.color); 
		StdDraw.filledCircle(this.x, this.y, this.size);
		StdDraw.show();
		//FIXME
	}
	
}


