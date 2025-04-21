package assignment9;

import java.util.LinkedList;

public class Snake {

	private static final double SEGMENT_SIZE = 0.02;
	private static final double MOVEMENT_SIZE = SEGMENT_SIZE * 1.5;
	private LinkedList<BodySegment> segments;
	private double deltaX;
	private double deltaY;
	
	public Snake() {
		//FIXME - set up the segments instance variable
		deltaX = 0;
		deltaY = 0;
		
		this.segments = new LinkedList<>();
		BodySegment firstSegment = new BodySegment(0.5, 0.5, SEGMENT_SIZE);
		segments.add(firstSegment);
	}
	
	public void changeDirection(int direction) {
		if(direction == 1) { //up
			deltaY = MOVEMENT_SIZE;
			deltaX = 0;
		} else if (direction == 2) { //down
			deltaY = -MOVEMENT_SIZE;
			deltaX = 0;
		} else if (direction == 3) { //left
			deltaY = 0;
			deltaX = -MOVEMENT_SIZE;
		} else if (direction == 4) { //right
			deltaY = 0;
			deltaX = MOVEMENT_SIZE;
		}
	}
	
	/**
	 * Moves the snake by updating the position of each of the segments
	 * based on the current direction of travel
	 */
	public void move() {
		//FIXME
		for (int i = segments.size() - 1; i >0; i-- ) { // starting from the back of the list
//			BodySegment currently = segments.get(i);
			double xPrevious = segments.get(i-1).getX();
			double yPrevious = segments.get(i-1).getY(); // x and y position from tail will get the position from the segment right before it
			segments.get(i).setX(xPrevious);
			segments.get(i).setY(yPrevious);


		}
		
		
		BodySegment head = segments.get(0);
		double newX = head.getX() + deltaX;  
		double newY = head.getY() + deltaY; 
		head.setX(newX);
		head.setY(newY);
	}
	
	/**
	 * Draws the snake by drawing each segment
	 */
	public void draw() {
		//FIXME
		for(int i = 0; i < segments.size(); i++) {
			segments.get(i).draw();
		}
	}
	
	/**
	 * The snake attempts to eat the given food, growing if it does so successfully
	 * @param f the food to be eaten
	 * @return true if the snake successfully ate the food
	 */
	public boolean eatFood(Food f) {
		BodySegment head = segments.get(0);
		double distance = Math.sqrt(Math.pow(head.getX() - f.getX(), 2) + Math.pow(head.getY() - f.getY(), 2));

		if (distance < SEGMENT_SIZE + Food.FOOD_SIZE) { 
			int end = segments.size() - 1;
			BodySegment lastSegment =segments.get(end);
			BodySegment newSegment = new BodySegment(lastSegment.getX(), lastSegment.getX(), SEGMENT_SIZE);
			segments.add(newSegment);
			return true;
		}
		//FIXME
		return false;
	}
	
	/**
	 * Returns true if the head of the snake is in bounds
	 * @return whether or not the head is in the bounds of the window
	 */
	public boolean isInbounds() {
		//FIXME
		BodySegment head = segments.get(0);
		double x = head.getX();
		double y = head.getY();
		if (x >= 0 && x <= 1 && y >= 0 && y <= 1) {
			return true;
		} else { 
			return false;
		}
	}
}
