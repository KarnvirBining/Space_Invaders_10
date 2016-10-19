
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;

public class Game extends Canvas implements Runnable  {

	private static final long serialVersionUID = -1930825029999864569L;
	
	public static final int WIDTH = 640, HEIGHT = WIDTH / 12*9;
	
	private Thread thread;
	private boolean running = false;
	
	private Handler handler;
	
	public Game(){
		handler = new Handler();
		this.addKeyListener(new KeyInput(handler));
		new Window(WIDTH,HEIGHT,"Pong Invaders",this);
		
		
		
		handler.addObject(new Player(WIDTH/2-32,HEIGHT-75,ID.Player));
		handler.addObject(new Alien(100,100,ID.Alien));
//		handler.addObject(new Alien(132,100,ID.Alien));
//		handler.addObject(new Alien(100,132,ID.Alien));
		
	}



	public synchronized void start(){
		thread = new Thread(this);
		thread.start();
		running = true;
	}
	
	public synchronized void stop(){
		try{
			thread.join();
			running = false;
			
			
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public void run(){
		this.requestFocus();
		long lastTime = System.nanoTime();
		double amountofTicks = 60.0;
		double ns = 1000000000 / amountofTicks;
		double delta = 0;
		long timer = System.currentTimeMillis();
		int frames =0;
		while(running){
			long now = System.nanoTime();
			delta += (now - lastTime)/ ns;
			lastTime = now;
			while(delta >= 1){
				tick();
				delta--;
			}
			if(running)
				render();
			frames++;
			
			
			if(System.currentTimeMillis() - timer> 1000){
				timer+= 1000;
				System.out.println ("FPS: " +frames);
				frames = 0;
			}
		}
		stop();
		
	}
	
	private void tick(){
		handler.tick();
	}
	
	private void render(){
		BufferStrategy bs = this.getBufferStrategy();
		if (bs == null){
			this.createBufferStrategy(3);
			return;
		}
		
		Graphics g  = bs.getDrawGraphics();
		
		g.setColor(Color.black);
		g.fillRect(0,0,WIDTH,HEIGHT);
		
		handler.reneder(g);
		
		
		g.dispose();
		bs.show();
	}
	
	

	public static void main (String args[]){
		new Game();
	}
	
	
}

