

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
/**
 * Uses abstract class GameObject so MIS of GameObject is the same as Player
 */
public class Player extends GameObject {

	Handler handler;
	
	public Player(float x, float y, ID id, Handler handler) {
		super(x, y, id);
		this.handler = handler;
	}

	public void tick() {
		x += velX;
		y += velY;
		
		x = Game.Clamp((int)x, 3, Game.WIDTH -39);
		collision();
	}
	
	private void collision(){
		for(int i= 0; i<handler.object.size(); i++){
			GameObject tempObject = handler.object.get(i);
			
			if(tempObject.getId() == ID.Alien){//tempObject is BasicEnemy
				//collision code
				if(getBounds().intersects(tempObject.getBounds())){
					//collision code
					HUD.HEALTH -=50;
					}
				}

		}
	}

	public void render(Graphics g) {
		
//		Graphics2D g2d =(Graphics2D) g;
//		g.setColor(Color.green);
//		g2d.draw(getBounds());
		
		g.setColor(Color.red);
		g.fillRect((int)x, (int)y, 32, 32);
		
	}

	public Rectangle getBounds() {
		return new Rectangle(0, Game.HEIGHT-75 ,Game.WIDTH, 32);
	}


}
