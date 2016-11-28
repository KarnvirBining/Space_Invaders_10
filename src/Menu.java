import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


public class Menu extends MouseAdapter{

	private Game game; 
	private Handler handler;
	private int menuBoxX = 225; 
	private int menuBoxY = 100; 
	private int menuBoxHeight = 200;
	private int menuBoxWidth = 64;

	public Menu(Game game, Handler handler){
		this.game = game; 
		this.handler = handler;
	}

	public void mousePressed(MouseEvent e){
		int mx = e.getX();
		int my = e.getY();

		if(game.gameState == Game.STATE.Menu){

			if(mouseOver(mx, my, 225, 100, 200, 64)){
				game.gameState = Game.STATE.Game;
			    handler.addObject(new Player("sprites/ship.gif",Game.WIDTH/2-32,Game.HEIGHT-70,ID.Player, handler));
				//handler.addObject(new Pong(null,5, Game.HEIGHT/2-70, ID.Pong, handler));
				for(int i = 0; i<12; i++){
					for(int j = 0; j<3; j++) {
						handler.addObject(new Alien("sprites/alien.gif",70+(i*40),(j*40),ID.Alien));
					}
				}

			}

			//Instructions menu option
			if(mouseOver(mx, my, menuBoxX, menuBoxY+100, menuBoxHeight, menuBoxWidth)){
				game.gameState = Game.STATE.Instructions;
			}

			//Quit menu option
			if(mouseOver(mx, my, menuBoxX,menuBoxY+200, menuBoxHeight, menuBoxWidth)){
				System.exit(1);
			}
		}

		if(game.gameState == Game.STATE.Game){
			int counter = 0;
			for (int i = 0; i<handler.object.size(); i++){
				GameObject tempObject = handler.object.get(i);
				if (tempObject.getId() == ID.Alien) {
					counter++;
				}
			}
			if (counter == 0){
				handler.clearEnemy();
				game.gameState = Game.STATE.WIN;
			}
		}

		if(game.gameState == Game.STATE.Game){
			if(HUD.HEALTH != 100){
				handler.clearEnemy();
				game.gameState = Game.STATE.GAMEOVER;
				HUD.HEALTH = 100;
			}
		}

		//Back Button 
		if(game.gameState == Game.STATE.Instructions || game.gameState == Game.STATE.GAMEOVER || game.gameState == Game.STATE.WIN){
			if (mouseOver(mx, my, menuBoxX, menuBoxY+200, menuBoxHeight, menuBoxWidth)){
				game.gameState = Game.STATE.Menu;
				return;
			}
		}
	}

	public void mouseReleased(MouseEvent e){

	}

	private boolean mouseOver(int mx, int my, int x, int y, int width, int height){
		if(mx > x && mx < x + width){
			if(my > y && my < y + height){
				return true;
			}else return false;  
		}else return false;
	}


	public void tick(){

	}
	
	private void makeOption(int fntSize, Color colour, String option, int posX, int posY, int dHeight, Graphics g){
		Font fnt = new Font("arial", 1, fntSize);
		g.setFont(fnt);

		g.setColor(colour);
		g.drawRect(menuBoxX, menuBoxY+dHeight, menuBoxHeight, menuBoxWidth);
		g.drawString(option, posX, posY);
	}

	private void makeTitle(int fntSize, Color colour, String title, int posX, int posY, Graphics g){
		Font fnt = new Font("arial", 1, fntSize);
		g.setFont(fnt);
		
		g.setColor(colour);
		g.drawString(title, posX, posY);
	}
	
	public void render(Graphics g){
		if(game.gameState == Game.STATE.Menu){

			makeTitle(50, Color.white, "Pong Invaders", 150, 50, g);
			makeOption(30, Color.white, "Start", 290, 145, 0, g);
			makeOption(30, Color.white, "Instructions", 240, 245, 100, g);
			makeOption(30, Color.red, "Quit", 295, 345, 200, g);

		}else if(game.gameState == Game.STATE.Instructions){


			makeTitle(50, Color.white, "Instructions", 175, 50, g);
			
			makeTitle(20, Color.white, "A, D = Left, Right", 25, 100, g);
			makeTitle(20, Color.white, "Spacebar = Shoot", 25, 150, g);
			makeTitle(20, Color.white, "Win Condition: Stop all aliens from landing", 25, 200, g);
			makeTitle(20, Color.white, "If aliens make a landing GAME OVER", 25, 250, g);
			
			makeOption(30, Color.white, "Back", 295, 345, 200, g);

		}
		else if(game.gameState == Game.STATE.GAMEOVER){

			makeTitle(50, Color.red, "Game Over", 175, 50, g);
			makeOption(30, Color.white, "Back", 295, 345, 200, g);
		}
		else if(game.gameState == Game.STATE.WIN){

			makeTitle(50, Color.white, "Victory", 250, 50, g);
			makeOption(40, Color.white, "Back", 295, 345, 200, g);

		}
	}
}