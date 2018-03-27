package com.chewychiyu.paint;

import javax.swing.JFrame;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class PaintFrame extends JFrame{

	public PaintFrame(){
		super("Paint");
		setPreferredSize(Style.paint_panel_dim);
		setVisible(true);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public void addElement(JPanel panel){
		add(panel);
		pack();
	}
	
}
