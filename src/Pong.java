import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class Pong extends GameObject {

	Handler handler;

	public Pong(String ref,float x, float y, ID id, Handler handler) {
		super(ref,x, y, id);
		this.handler = handler;
	}

	public void tick() {

	}

	public void render(Graphics g) {
		g.setColor(Color.blue);
		g.fillRect((int)x, (int)y, 20, 70);
	}

	private void collision() {

	}

	public Rectangle getBounds() {
		return new Rectangle((int) x, (int) y , 20, 70);
	}

}