package com.chewychiyu.paint;

import java.awt.BasicStroke;
import java.awt.Graphics;

import javax.swing.JPanel;
@SuppressWarnings("serial")
public class ToolBar extends JPanel{
	
	public ColorBar color_bar;
	public ColorChanger color_changer;
	
	public int current_color_index = 7; // black
	public BasicStroke current_stroke = new BasicStroke(10);
	
	public ToolBar(){
		panel();
		addElements();
	}
	
	public void addElements(){
		
		color_bar = new ColorBar(this);
		color_changer = new ColorChanger(this);
		
		add(color_bar);
		add(color_changer);
	}
	
	public void panel(){
		setPreferredSize(Style.tool_bar_dim);
		setBorder(Style.bevel_line_border);
		setLayout(Style.tool_bar_layout);
	}
	
	public void paintComponent(Graphics g){
		
	}
	
}
