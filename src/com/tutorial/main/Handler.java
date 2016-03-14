package com.tutorial.main;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.LinkedList;

public class Handler {
	
	LinkedList<GameObject> object = new LinkedList<GameObject>();
	LinkedList<GameObject> toAdd = new LinkedList<GameObject>();
	
	public void tick(){
		// Will declaring this inside of the loop make it clear after each call to tick()?
		ArrayList<Integer> toRemoveIndex = new ArrayList<Integer>();
		
		// Update Objects
		for(GameObject tempObject : object){
			tempObject.tick();
			
			// Save index of array objects to be removed
			if (tempObject.removed) {
				toRemoveIndex.add(object.indexOf(tempObject));
			}
		}
	
		// Remove marked objects
		for (int index = toRemoveIndex.size() - 1; index >= 0; index--) {
			this.removeObject(object.get(toRemoveIndex.get(index)));
		}
		// toRemoveIndex.clear(); //doesn't seem to be doing anything
		
		
		// Combine new objects into object list
		this.object.addAll(toAdd);
		this.toAdd.clear();
	}
	
	public void render(Graphics g){
		for(GameObject tempObject : object){
			tempObject.render(g);
		}
	}
	
	public void addObject(GameObject object){
		this.toAdd.add(object);
	}
	
	public void removeObject(GameObject object){
		this.object.remove(object);
	}
}
