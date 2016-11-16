import java.awt.*;

public class Bullet extends GameObject {

	public Bullet(float x, float y, ID id) {
		super(x, y, id);
		velX = 20;
	}

	@Override
	public void tick() {

	}

	@Override
	public void render(Graphics g) {

	}

	@Override
	public Rectangle getBounds() {
		return null;
	}
}
