import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
/**
 * Uses abstract class GameObject so MIS of GameObject is the same as Alien
 */
public class Alien extends GameObject {

	public Alien(float x, float y, ID id) {
		
		super(x, y, id);
		velX = 5;
	}
	

	public void tick() {
			x += velX;
			y += velY;
			
			if(x <= 0 || x >= Game.WIDTH-16) velX *= -1;
			if(x <= 0 || x >= Game.WIDTH-16) y -= -39;
			//////////////////////////////////////////////////////////// Game State Change
			if(y >= Game.HEIGHT-150){
				velX = 0;
				x = 0+32;
			}
	}

	public void render(Graphics g) {
		g.setColor(Color.white);
		g.fillRect((int)x, (int)y, 16, 16);
	}

	@Override
	public Rectangle getBounds() {
		// TODO Auto-generated method stub
		return null;
	}

}
