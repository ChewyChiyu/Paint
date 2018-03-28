package com.chewychiyu.paint;

import java.awt.BorderLayout;

import javax.swing.JPanel;

public class PaintLauncher{

	
	public PaintLauncher(){
		
		JPanel master_panel = new JPanel();
		
		PaintFrame frame = new PaintFrame();
		ToolBar tool_bar = new ToolBar();
		PaintPanel paint_panel = new PaintPanel(tool_bar);

		master_panel.add(tool_bar, BorderLayout.NORTH);
		master_panel.add(paint_panel, BorderLayout.SOUTH);

		frame.addElement(master_panel);
	}
	
	
	public static void main(String[] args){
		Storage.load_preferences(); //load storage from files
		new PaintLauncher();
	}
	
}
