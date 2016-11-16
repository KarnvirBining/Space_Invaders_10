import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


public class Menu extends MouseAdapter{

	private Game game; 
	private Handler handler;

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
				handler.addObject(new Player(Game.WIDTH/2-32,Game.HEIGHT-75,ID.Player, handler));
				for(int i = 0; i<5; i++){
					handler.addObject(new Alien(100+(i*40),100,ID.Alien));
				}

			}

			//Instructions menu option
			if(mouseOver(mx, my, 225, 200, 200, 64)){
				game.gameState = Game.STATE.Instructions;
			}

			//Quit menu option
			if(mouseOver(mx, my, 225,300, 200, 64)){
				System.exit(1);
			}
		}

		if(game.gameState == Game.STATE.Game){
			if(HUD.HEALTH != 100){
				handler.clearEnemys();
				game.gameState = Game.STATE.GAMEOVER;
				HUD.HEALTH = 100;
			}
		}

		//Back Button 
		if(game.gameState == Game.STATE.Instructions || game.gameState == Game.STATE.GAMEOVER){
			if (mouseOver(mx, my, 225, 300, 200, 64)){
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

	public void render(Graphics g){
		if(game.gameState == Game.STATE.Menu){
			Font fnt = new Font("arial", 1, 50);
			Font fnt2 = new Font("arial", 1, 30);

			g.setFont(fnt);
			g.setColor(Color.white);
			g.drawString("Pong Invaders", 150, 50);

			g.setFont(fnt2);
			g.setColor(Color.white);
			g.drawRect(225, 100, 200, 64);
			g.drawString("Start", 290, 145);

			g.setColor(Color.white);
			g.drawRect(225, 200, 200, 64);
			g.drawString("Instructions", 240, 245);

			g.setColor(Color.red);
			g.drawRect(225, 300, 200, 64);
			g.drawString("Quit", 295, 345);
		}else if(game.gameState == Game.STATE.Instructions){
			Font fnt = new Font("arial", 1, 50);
			Font fnt2 = new Font("arial", 1, 20);

			g.setFont(fnt);
			g.setColor(Color.white);
			g.drawString("Instructions", 175, 50);

			g.setFont(fnt2);
			g.drawString("A, D = Left, Right", 25, 100);
			g.drawString("Spacebar = Shoot", 25, 150);
			g.drawString("Win Condition: Stop all aliens from landing", 25, 200);
			g.drawString("If aliens make a landing GAME OVER", 25, 250);

			g.setFont(fnt2);
			g.setColor(Color.white);
			g.drawRect(225, 300, 200, 64);
			g.drawString("Back", 295, 345);
		}
		else if(game.gameState == Game.STATE.GAMEOVER){
			Font fnt = new Font("arial", 1, 50);
			Font fnt2 = new Font("arial", 1, 20);

			g.setFont(fnt);
			g.setColor(Color.white);
			g.drawString("GAME OVER", 175, 50);

			g.setFont(fnt2);
			g.setColor(Color.white);
			g.drawRect(225, 300, 200, 64);
			g.drawString("Back", 295, 345);

		}
	}
}
