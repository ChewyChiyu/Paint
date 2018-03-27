package com.chewychiyu.paint;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Graphics;

import javax.swing.JPanel;

@SuppressWarnings("serial")
public class ToolBar extends JPanel{
	
	private ColorBar color_bar;
	
	public Color current_color =  Color.BLACK;
	public BasicStroke current_stroke = new BasicStroke(10);
	
	public ToolBar(){
		panel();
		addElements();
	}
	
	public void addElements(){
		color_bar = new ColorBar();
		add(color_bar);
	}
	
	public void panel(){
		setPreferredSize(Style.tool_bar_dim);
		setBorder(Style.bevel_line_border);
		setLayout(new FlowLayout(Style.FLOW_BUFFER));
	}
	
	public void paintComponent(Graphics g){
		
	}
	
}
