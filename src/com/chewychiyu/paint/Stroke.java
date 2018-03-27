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
}
