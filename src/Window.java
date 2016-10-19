

import java.awt.Canvas;
import java.awt.Dimension;

import javax.swing.JFrame;

public class Window extends Canvas{


	private static final long serialVersionUID = -650585914685456797L;

	public Window (int width, int height, String title, Game game){
		JFrame frame = new JFrame(title);
		
		frame.setPreferredSize(new Dimension(width,height));
		frame.setMaximumSize(new Dimension(width,height));
		frame.setMinimumSize(new Dimension(width,height));
		
		//allows to close game
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//makes window not sizeable
		frame.setResizable(false);
		//draws window in middle of screen
		frame.setLocationRelativeTo(null);
		//adds game class in to frame
		frame.add(game);
		//frame can be seen
		frame.setVisible(true);
		game.start();
		
	}
	
}