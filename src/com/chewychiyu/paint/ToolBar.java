package com.chewychiyu.paint;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;

import javax.swing.JPanel;

@SuppressWarnings("serial")
public class ToolBar extends JPanel{
	
	private Dimension dim;
	private ColorBar color_bar;
	private Dimension color_bar_dim;
	
	public Color current_color =  Color.BLACK;
	public BasicStroke current_stroke = new BasicStroke(10);
	
	public ToolBar(Dimension dim){
		this.dim = dim;
		color_bar_dim = new Dimension(dim.width/4,(int)(dim.height*.85));
		panel(dim);
		addElements();
	}
	
	public void addElements(){
		color_bar = new ColorBar(color_bar_dim);
		add(color_bar);
	}
	
	public void panel(Dimension dim){
		setPreferredSize(new Dimension(dim));
		setBorder(Style.bevel_line_border);
		setLayout(new FlowLayout(20));
	}
	
	public void paintComponent(Graphics g){
		
	}
	
}
