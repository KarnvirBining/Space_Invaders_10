import java.awt.*;

public class Bullet extends GameObject {

	public Bullet(float x, float y, ID id) {
		super(x, y, id);
	}

	@Override
	public void tick() {
		x += velX;
		y += velY;
	}

	@Override
	public void render(Graphics g) {
		g.setColor(Color.white);
		g.fillRect((int)x, (int)y, 15, 15);

	}

	@Override
	public Rectangle getBounds() {
		return null;
	}
}
