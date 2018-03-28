package com.chewychiyu.paint;

import java.awt.BorderLayout;

import javax.swing.JPanel;

public class PaintLauncher{

	
	public PaintLauncher(){		
		JPanel master_panel = new JPanel();
		
		PaintFrame frame = new PaintFrame();
		
		PaintPanel paint_panel = new PaintPanel();
		ToolBar tool_bar = new ToolBar();

		paint_panel.tool_bar = tool_bar;
		tool_bar.paint_panel = paint_panel;
		
		master_panel.add(tool_bar, BorderLayout.NORTH);
		master_panel.add(paint_panel, BorderLayout.SOUTH);

		frame.addElement(master_panel);
	}
	
	
	public static void main(String[] args){
		Storage.load_preferences(); //load storage from files
		new PaintLauncher();
	}
	
}
