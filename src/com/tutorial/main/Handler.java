package com.tutorial.main;

import java.awt.Graphics;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class Handler {
	
	List<GameObject> object = new LinkedList<GameObject>();
	List<GameObject> toAdd = new LinkedList<GameObject>();
	
	public void tick() {
	
		// Update Objects with iterator and remove if necessary
		Iterator<GameObject> iterator = object.iterator();
		while (iterator.hasNext()) {
			GameObject tempObject = iterator.next();
			tempObject.tick();
			if (tempObject.removed) {
				iterator.remove();
			}
		}
		
		// Combine new objects into object list
		this.object.addAll(toAdd);
		this.toAdd.clear();
	}
	
	public void render(Graphics g) {
		for(GameObject tempObject : object) {
			tempObject.render(g);
		}
	}
	
	public void addObject(GameObject object) {
		this.toAdd.add(object);
	}
	
	public void removeObject(GameObject object) {
		object.removed = true;
	}
}
