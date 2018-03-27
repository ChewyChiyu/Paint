package com.chewychiyu.paint;

import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class PaintFrame extends JFrame{

	public PaintFrame(Dimension dim){
		super("Paint");
		setPreferredSize(new Dimension(dim));
		setVisible(true);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public void addElement(JPanel panel){
		add(panel);
		pack();
	}
	
}
