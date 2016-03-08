package com.tutorial.main;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class KeyInput extends KeyAdapter{
	
	private Handler handler;
	
	public KeyInput(Handler handler){
		this.handler = handler;
	}
	
	public void keyPressed(KeyEvent e){
		int key = e.getKeyCode();
		
		for(GameObject o : handler.object){
			if(o.getId() == ID.Player){
				// Key events for player 1
				
				if(key == KeyEvent.VK_W) o.setVelY(-5);
				if(key == KeyEvent.VK_S) o.setVelY(5);
				if(key == KeyEvent.VK_D) o.setVelX(5);
				if(key == KeyEvent.VK_A) o.setVelX(-5);
			}
		}
		
		if(key == KeyEvent.VK_ESCAPE) System.exit(1);
		
	}
	
	public void keyReleased(KeyEvent e){
		int key = e.getKeyCode();
		
		for(GameObject o : handler.object){
			if(o.getId() == ID.Player){
				// Key events for player 1
				
				if(key == KeyEvent.VK_W) o.setVelY(0);
				if(key == KeyEvent.VK_S) o.setVelY(0);
				if(key == KeyEvent.VK_D) o.setVelX(0);
				if(key == KeyEvent.VK_A) o.setVelX(0);
			}
		}
	}
	
	
}
