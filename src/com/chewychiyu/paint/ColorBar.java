package com.chewychiyu.paint;

import java.awt.Graphics;

import javax.swing.JPanel;

@SuppressWarnings("serial")
public class ColorBar extends JPanel{
	
	
	public ColorBar(){
		panel();
	}
	
	public void panel(){
		setPreferredSize(Style.color_bar_dim);
		setBorder(Style.bevel_line_border);
	}
	
	public void paintComponent(Graphics g){
		
	}
	
}
