package com.game;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class Player extends GameObject {

	public Player(float x, float y, ID id) {
		super(x, y, id);
		
		velX= 2;
		velY = 1;
//		for (int i = 0; i <4; i+=0.5){
//			velX += i;
//		}
		
	}

	@Override
	public void tick() {
		x+=velX;
		y +=velY;
		
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
