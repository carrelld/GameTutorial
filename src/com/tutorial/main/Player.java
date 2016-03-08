package com.tutorial.main;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Random;

public class Player extends GameObject {

	Random r = new Random();
	Handler handler;
	
	public Player(int x, int y, ID id, Handler handler) {
		super(x, y, id);
		this.handler = handler;
		
		
	
	}

	public void tick() {
		x += velX;
		y += velY;
		
		x = Game.clamp(x, 0, Game.WIDTH - 37);
		y = Game.clamp(y, 0, Game.HEIGHT - 60);
		
		collision();
		
	}

	private void collision(){
		for(GameObject o : handler.object){
			
			if(o.getId() == ID.BasicEnemy){
				if(getBounds().intersects(o.getBounds())){
					// Collision code
					HUD.HEALTH -= 2;
				}
			}
		}
	}
	
	public void render(Graphics g) {
		g.setColor(Color.white);
		g.fillRect(x, y, 32, 32);
	}
	
	public Rectangle getBounds() {
		return new Rectangle(x, y, 32, 32);
	}
	
	

}
