package com.tutorial.main;

import java.awt.Graphics;
import java.util.Iterator;
import java.util.LinkedList;

public class Handler {
	
	LinkedList<GameObject> object = new LinkedList<GameObject>();
	
	public void tick(){
		
		for(int i = 0; i < object.size(); i++){
			GameObject tempObject = object.get(i);
			tempObject.tick();
		}
		// had to remove enhanced for loop when I started creating a trail for basic enemy
//		for(GameObject tempObject : object){
//			tempObject.tick();
//		}
	}
	
	public void render(Graphics g){
		for(GameObject tempObject : object){
			tempObject.render(g);
		}
	}
	
	public void addObject(GameObject object){
		this.object.add(object);
	}
	
	public void removeObject(GameObject object){
		this.removeObject(object);
	}
}
