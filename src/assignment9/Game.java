package assignment9;

import java.awt.event.KeyEvent;

import edu.princeton.cs.introcs.StdDraw;

public class Game {
	// instance variables
	private Snake snake;
	private Food food;
	private int score;
	
	public Game() {
		StdDraw.enableDoubleBuffering();
		this.snake = new Snake();
		this.food = new Food();
		//FIXME - construct new Snake and Food objects
	}
	
	public void play() {
		while (snake.isInbounds()) { //TODO: Update this condition to check if snake is in bounds

			int dir = getKeypress();
			//Testing only: you will eventually need to do more work here
			
			if (dir != -1) { //there is some key that is pressed
				snake.changeDirection(dir); // change the direction according to the key pressed
			} snake.move(); // move in the direction specified
			
			if (snake.eatFood(food)) {
				score++;
				food = new Food(); // draw new location of good
			}
			updateDrawing();

			System.out.println("Keypress: " + dir);
			
			/*
			 * 1. Pass direction to your snake
			 * 2. Tell the snake to move
			 * 3. If the food has been eaten, make a new one
			 * 4. Update the drawing
			 */

		} 
		System.out.println(score);

	}
	
	private int getKeypress() {
		if(StdDraw.isKeyPressed(KeyEvent.VK_W)) {
			return 1;
		} else if (StdDraw.isKeyPressed(KeyEvent.VK_S)) {
			return 2;
		} else if (StdDraw.isKeyPressed(KeyEvent.VK_A)) {
			return 3;
		} else if (StdDraw.isKeyPressed(KeyEvent.VK_D)) {
			return 4;
		} else {
			return -1;
		}
	}
	
	/**
	 * Clears the screen, draws the snake and food, pauses, and shows the content
	 */
	private void updateDrawing() {
		//FIXME
		
		/*
		 * 1. Clear screen
		 * 2. Draw snake and food
		 * 3. Pause (50 ms is good)
		 * 4. Show
		 */
		
		//clear screen
		StdDraw.clear();
		//draw snake and food
		this.snake.draw();
		this.food.draw();
		StdDraw.setPenColor(0, 0, 0); // Black color for text
		StdDraw.text(0.5, 0.95, "Score: " + score);
		//pause for 50 ms
		StdDraw.pause(50);
		//show
		StdDraw.show();
	}
	
	public static void main(String[] args) {
		Game g = new Game();
		g.play();
	}
}
