import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class Alien extends GameObject {

	public Alien(float x, float y, ID id) {
		
		super(x, y, id);
		velX = 5;
	}

	public void tick() {
			x += velX;
			y += velY;
			
			if(x <= 0 || x >= Game.WIDTH-16) velX *= -1;
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
