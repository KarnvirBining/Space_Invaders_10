import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
/**
 * Uses abstract class GameObject so MIS of GameObject is the same as Player
 */
public class Player extends GameObject {

	public Player(float x, float y, ID id) {
		super(x, y, id);
		

		
	}

	@Override
	public void tick() {
		x += velX;
		y +=velY;
		x = Game.Clamp((int)x, 3, Game.WIDTH -39);
	}

	@Override
	public void render(Graphics g) {
		g.setColor(Color.white);
		g.fillRect((int)x, (int)y, 32, 32);
		
	}

	@Override
	public Rectangle getBounds() {
		// TODO Auto-generated method stub
		return null;
	}


}
