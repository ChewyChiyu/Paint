package com.chewychiyu.paint;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JPanel;

@SuppressWarnings("serial")
public class ColorBar extends JPanel{
	
	private Dimension dim;
	
	public ColorBar(Dimension dim){
		this.dim = dim;
		panel(dim);
	}
	
	public void panel(Dimension dim){
		setPreferredSize(dim);
		setBorder(Style.bevel_line_border);
	}
	
	public void paintComponent(Graphics g){
		
	}
	
}
