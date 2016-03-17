package com.tutorial.main;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class KeyInput extends KeyAdapter {
	
	private Handler handler;
	private boolean[] keyDown = new boolean[4];
	
	public KeyInput(Handler handler) {
		this.handler = handler;
		
		keyDown[0] = false;
		keyDown[1] = false;
		keyDown[2] = false;
		keyDown[3] = false;
	}
	
	public void keyPressed(KeyEvent e) {
		int key = e.getKeyCode();
		
		for (GameObject o : handler.object) {
			if (o.getId() == ID.PLAYER) {
				// Key events for player 1
				
				if (key == KeyEvent.VK_W) { o.setVelY(-5); keyDown[0] = true; }
				if (key == KeyEvent.VK_S) { o.setVelY(5); keyDown[1] = true; }
				if (key == KeyEvent.VK_D) { o.setVelX(5); keyDown[2] = true; }
				if (key == KeyEvent.VK_A) { o.setVelX(-5); keyDown[3] = true; }
			}
		}
		
		if (key == KeyEvent.VK_ESCAPE) System.exit(1);
		
	}
	
	public void keyReleased(KeyEvent e) {
		int key = e.getKeyCode();
		
		for (GameObject o : handler.object) {
			if (o.getId() == ID.PLAYER) {
				// Key events for player 1
				
				if (key == KeyEvent.VK_W) keyDown[0] = false; //o.setVelY(0);
				if (key == KeyEvent.VK_S) keyDown[1] = false; //o.setVelY(0);
				if (key == KeyEvent.VK_D) keyDown[2] = false; //o.setVelX(0);
				if (key == KeyEvent.VK_A) keyDown[3] = false; //o.setVelX(0);
				
				// Vertical movement
				if (!keyDown[0] && !keyDown[1]) o.setVelY(0);
				// Horizontal movement
				if (!keyDown[2] && !keyDown[3]) o.setVelX(0);
			}
		}
	}
	
	
}
