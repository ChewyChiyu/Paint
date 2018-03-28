package com.chewychiyu.paint;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

public class Stroke {
	
	public List<Point> points;
	public Color c;
	public BasicStroke girth;
	
	public static final int MAX_LENGTH = 100;
	
	public Stroke(Color c, BasicStroke girth){
		points = new ArrayList<Point>();
		this.girth = girth;
		this.c = c;
	}
	
	public void add(Point p){
		points.add(p);
	}
	
	public int size(){
		return points.size();
	}
	
	public Point get(int index){
		return points.get(index);
	}
	
	public void clear(){
		points.clear();
	}

	public boolean isEmpty(){
		return points.isEmpty();
	}

	public void truncate(){
		for(int index = 0; index < (int)(points.size()*.75); index++){
			points.remove(index);
			index--;
		}
	}
}
